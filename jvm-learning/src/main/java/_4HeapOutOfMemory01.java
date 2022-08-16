import java.util.ArrayList;
import java.util.List;

/**
 * @author wentao
 * 2022/8/3 - 17:39
 * 演示堆内存溢出
 * -Xmx8m 设置堆内存
 */
public class _4HeapOutOfMemory01 {
    public static void main(String[] args) {
        int i = 0;
        try {
            List<String> list = new ArrayList<>();
            String a = "hello";
            while(true) {
                list.add(a);
                a = a + a;
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
            System.out.println(i);
        }
    }
}
