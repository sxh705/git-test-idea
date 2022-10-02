package others.javaSE.Reflect2;

public class Student {
    private String name;
    private String hobby;
    private int age;

    public Student() {
    }

    public Student(String name, String hobby, int age) {
        this.name = name;
        this.hobby = hobby;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                ", age=" + age +
                '}';
    }
}
