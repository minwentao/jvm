/**
 * @author wentao
 * 2022/8/3 - 17:11
 * 演示栈帧过多引起的栈内存溢出 java.lang.StackOverflowError
 * 栈帧过大不好演示
 * 在vm options 设置-Xss256k，调整栈内存大小
 */
public class _3StackOverflow01 {
    private static int count;

    public static void main(String[] args) {
        try {
            method1();
        } catch (Throwable e) { //这是一个error，所以要捕获Throwable
            e.printStackTrace();
            System.out.println(count);
        }
    }

    private static void method1() {
        count++;
        method1();
    }
}
