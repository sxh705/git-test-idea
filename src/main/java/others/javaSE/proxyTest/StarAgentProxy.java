package others.javaSE.proxyTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class StarAgentProxy {
    public static Skill getProxy(Star obj) {
        return (Skill) Proxy.newProxyInstance(
                obj.getClass().getClassLoader(),
                obj.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("收钱...");
                        //调用method对象
                        Object rs = method.invoke(obj, args);
                        System.out.println("收尾款, 接回杨超越");
                        return rs;
                    }
                });
    }
}
