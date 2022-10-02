package others.javaSE.Reflect2;

import java.util.Objects;

public class Teacher {
    private String name;
    private String hobby;
    private int age;

    private int salary;

    public Teacher() {
    }

    public Teacher(String name, String hobby, int age, int salary) {
        this.name = name;
        this.hobby = hobby;
        this.age = age;
        this.salary = salary;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return age == teacher.age && salary == teacher.salary && Objects.equals(name, teacher.name) && Objects.equals(hobby, teacher.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, hobby, age, salary);
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", hobby='" + hobby + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
