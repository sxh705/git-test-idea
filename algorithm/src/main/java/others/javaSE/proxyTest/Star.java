package others.javaSE.proxyTest;

public class Star implements Skill {
    private final String name;

    public Star(String name) {
        this.name = name;
    }

    public void sing() {
        System.out.println(name + "唱歌, 喵喵喵喵喵喵~~");
    }

    public void dance() {
        System.out.println(name + "跳舞, 好看💃");
    }
}
