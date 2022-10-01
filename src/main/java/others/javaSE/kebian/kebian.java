package others.javaSE.kebian;

import java.util.Arrays;

public class kebian {
    public static void main(String[] args) {
        sum();
        sum(10);
        sum(10, 20);
        var s = new int[]{10, 20, 30, 40, 50};
        sum(s);

    }

    public static void sum(int... nums) {
        //a是一个数组 可变必须放在最后.

        System.out.println(nums.length);
        System.out.println(Arrays.toString(nums));
    }
}
