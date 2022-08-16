import java.util.ArrayList;

/**
 * @author wentao
 * 2022/8/6 - 9:01
 * 演示1.8和1.6中StringTable的位置，前者在堆内存，后者在永久代
 * -Xmx10m -XX:-UseGCOverheadLimit
 */
public class _8StringTablePosition {
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        int i = 0;
        try {
            for (int j = 0; j < 260000; j++) {
                list.add(String.valueOf(j).intern());
                i++;
            }
        } catch (Throwable e) {
            e.printStackTrace();
        } finally {
            System.out.println(i);
        }
    }
}
