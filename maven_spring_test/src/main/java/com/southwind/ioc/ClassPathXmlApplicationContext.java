package com.southwind.ioc;

import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class ClassPathXmlApplicationContext implements AppContext {
    private final Map<String, Object> ioc = new HashMap<>();

    public ClassPathXmlApplicationContext(String path) {
        try {
            var iterator = init(path);
            while (iterator.hasNext()) {
                var element = (Element) iterator.next();

                var id = element.attributeValue("id");
                var className = element.attributeValue("class");

                var clazz = Class.forName(className);
                var constructor = clazz.getConstructor();

                Object object = memoryConstruct(id, constructor);

                getProperties(object, element.elementIterator(), clazz);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    Object memoryConstruct(String id, Constructor<?> constructor) throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Object object;
        if (ioc.containsKey(id)) {
            object = ioc.get(id);
        } else {
            object = constructor.newInstance();
            ioc.put(id, object);
        }
        return object;
    }

    Iterator<?> init(String path) throws DocumentException {
        var reader = new SAXReader();
        var document = reader.read(path);
        var root = document.getRootElement();
        return root.elementIterator();
    }

    void getProperties(Object fatherObject, Iterator<?> iterator, Class<?> fatherClass) throws Exception {
        while (iterator.hasNext()) {
            var property = (Element) iterator.next();

            var name = property.attributeValue("name");
            var valueStr = property.attributeValue("value");
            var ref = property.attributeValue("ref");

            var methodName = "set" + name.substring(0, 1).toUpperCase() + name.substring(1);
            var field = fatherClass.getDeclaredField(name);
            var method = fatherClass.getMethod(methodName, field.getType());
            Object value = getValue(field.getType().getName(), valueStr);
            if (value == null) {
                if (ref != null)
                    value = memoryConstruct(ref, field.getDeclaringClass().getConstructor());
                else
                    throw new Exception("??? not support this type" + ioc);
            }
            method.invoke(fatherObject, value);
        }
    }

    Object getValue(String type, String valueStr) {
        Object value;
        switch (type) {
            case "char", "java.lang.Character" -> value = valueStr.indexOf(0);
            case "short", "java.lang.Short" -> value = Short.parseShort(valueStr);
            case "int", "java.lang.Integer" -> value = Integer.parseInt(valueStr);
            case "long", "java.lang.Long" -> value = Long.parseLong(valueStr);
            case "float", "java.lang.Float" -> value = Float.parseFloat(valueStr);
            case "double", "java.lang.Double" -> value = Double.parseDouble(valueStr);
            case "java.lang.String" -> value = valueStr;
            default -> value = null;
        }
        return value;
    }

    @Override
    public Object getBean(String id) {
        return ioc.get(id);
    }
}
