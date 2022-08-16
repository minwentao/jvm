/**
 * @author wentao
 * 2022/8/3 - 16:57
 * 局部变量的线程安全问题
 */

public class _2ThreadSafety01 {
    public static void main(String[] args) {

    }

    // 安全
    public static void m1() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    // 不安全
    public static void m2(StringBuilder sb) {
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
    }

    // 不安全，sb逃离方法
    public static StringBuilder m3() {
        StringBuilder sb = new StringBuilder();
        sb.append(1);
        sb.append(2);
        sb.append(3);
        System.out.println(sb.toString());
        return sb;
    }

}
// 接上一P第三个问题
// 1. 如果方法内局部变量没有逃离方法的作用访问，它是线程安全的
// 2. 如果是局部变量引用了对象，并逃离方法的作用方法，需要考虑线程安全