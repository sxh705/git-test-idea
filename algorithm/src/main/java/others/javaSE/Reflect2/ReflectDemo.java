package others.javaSE.Reflect2;

import algorithm.DataStructure.TreeNode;

public class ReflectDemo {
    public static void main(String[] args) {
        var s = new Student("1", "2", 3);
        var t = new Teacher("1", "2", 3, 4);
        MybatisUtil.save(s);
        MybatisUtil.save(t);
        var a = new TreeNode(10);
        MybatisUtil.save(a);

    }
}
