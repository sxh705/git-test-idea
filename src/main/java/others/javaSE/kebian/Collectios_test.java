package others.javaSE.kebian;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Collectios_test {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        Collections.addAll(a, "楚留香", "胡铁花", "张无忌", "陆小凤", "1", "2", "3", "4", "5");
        System.out.println(a);
        //打乱
        Collections.shuffle(a);
        System.out.println(a);
        //排序
        Collections.sort(a);
        System.out.println(a);

        //逆向
        //可排序
        //01. 继承comparable接口 重写public int compareTo(T a)
        //02.比较器对象
        a.sort(Comparator.reverseOrder());
        a.sort((o1, o2) -> o2.compareTo(o1));
        a.sort((o1, o2) -> {
            return o2.compareTo(o1);
        });

        Collections.sort(a, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        System.out.println(a);


    }

}
