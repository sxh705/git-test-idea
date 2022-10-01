package others.javaSE.Reflect2;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class MybatisUtil {
    public static void save(Object obj) {
        try (
                //自动释放
                PrintStream ps = new PrintStream(new FileOutputStream("src/data.txt", true));
        ) {
            var c = obj.getClass();
            ps.println("=================" + c.getSimpleName() + "=================");
            var fields = c.getDeclaredFields();
            for (var field : fields) {
                String name = field.getName();
                field.setAccessible(true);
                String value = field.get(obj) + "";
                ps.println(name + "=" + value);
            }
            ps.println("=================" + "properties" + "=================");
        } catch (Exception ignored) {
            System.out.println("ignored = " + ignored);
        }
    }
}
