package others.javaSE.reflect;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

public class TestU {
    Class c;
    Constructor e;

    @BeforeClass
    public void init() {
        c = Student.class;
    }

    @Test
    public void Test0() throws ClassNotFoundException {
        //class forName(全限名, 包 + 类)
        //得到类对象
        c = Class.forName("heima.javaSE.reflect.Student");
        c = Student.class;
        c = new Student().getClass();
        System.out.println(c);
    }

    @Test
    public void Test1() {
        var d = c.getConstructors();
        for (var e : d) {
            System.out.println(e.getName() + "==>" + e.getParameterCount());
        }
    }

    @Test
    public void Test2() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        e = c.getDeclaredConstructor(int.class, int.class);
        System.out.println(e.getName() + "==>" + e.getParameterCount());
        e.setAccessible(true);//反射破坏封装, 只针对当前构造器e有效.
        var f = (Student) e.newInstance(10, 10);//私有不可访问
        //var g = new Student(10, 10);
    }

    @Test
    public void Test3() throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        var e = c.getDeclaredConstructor(int.class, int.class);
        System.out.println(e.getName() + "==>" + e.getParameterCount());
        var f0 = this.e.newInstance(10, 10);//一次性的, 针对构造器?
        //var f = (Student) e.newInstance(10, 10);//私有不可访问
    }

    @Test
    public void Test4() {
        System.out.println("\"Test4\" = " + "Test4");
        var d = c.getDeclaredFields(); //全部变量
        for (var e : d) {
            System.out.println(e.getName() + "==>" + e.getType() + " ");
        }
    }

    @Test
    public void Test5() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        Student s = new Student();
        var a = c.getDeclaredField("b");
        a.setAccessible(true);
        a.set(s, 18);
        var b = c.getDeclaredMethod("tb", int.class);
        System.out.println("" + b.getParameterCount() + " " + b.getModifiers() + " " + b.getReturnType());
        b.setAccessible(true);
        Object res = b.invoke(s, 10);//调用方法 //无返回值返回null
        System.out.println("res = " + res);
    }

    @Test
    public void Test6() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        ArrayList<Integer> l1 = new ArrayList<>();
        l1.add(100);
        System.out.println(l1 + " " + l1.hashCode());
        //类型擦除
        var c = l1.getClass();
        var d = c.getDeclaredMethod("add", Object.class);
        var e = (boolean) d.invoke(l1, "类型擦除测试");
        System.out.println("l1 = " + l1);

        //        Collections.sort(l1);
        //        System.out.println("l1 = " + l1);//损坏

        ((ArrayList) l1).add("测试2");

        System.out.println("l1 = " + l1);
    }


}
