package others.javaSE.reflect;

public class Student {
    public static final String COUNTRY = "中国";
    public int a = 10;
    private int b = 20;
    private String name;

    Student() {
        a = 10;
        b = 20;
    }

    private Student(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void ta() {
        System.out.println(a);
    }

    private int tb(int a) {
        System.out.println(b);
        return a;
    }


}
