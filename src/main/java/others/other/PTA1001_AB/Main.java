package others.other.PTA1001_AB;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        var s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int c = a + b;
        if (c < 0) c = -c;
        System.out.print("-");
        var d = Integer.toString(c);
        int mod = (d.length() + 2) % 3;

        for (int i = 0; i < d.length(); ++i) {
            System.out.print(d.charAt(i));
            if (i == d.length() - 1) {
                continue;
            }
            if ((i - mod) % 3 == 0)
                System.out.print(",");
        }
    }
}
