/**
 * @author wentao
 * 2022/8/3 - 17:48
 * 演示堆内存和堆内存诊断工具 jps jmap jconsole
 */
public class _4HeapOutOfMemory02 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("1...");
        Thread.sleep(30000);
        byte[] array = new byte[1024 * 1024 * 10];
        System.out.println("2...");
        Thread.sleep(30000);
        array = null;
        System.gc();
        System.out.println("3...");
        Thread.sleep(1000000L);
    }
}
