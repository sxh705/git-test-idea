package others.javaSE.proxyTest;

public class Test {
    public static void main(String[] args) {
        var s = new Star("杨超越");
        s.sing();
        s.dance();

        var s2 = StarAgentProxy.getProxy(s);

        s2.sing();
        s2.dance();

    }
}
