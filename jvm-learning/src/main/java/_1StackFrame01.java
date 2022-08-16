/**
 * @author wentao
 * 2022/8/3 - 16:45
 * 使用debug动态演示栈帧
 */

public class _1StackFrame01 {
    public static void main(String[] args) {
        method01();
    }
    private static void method01() {
        method02(1,2);
    }
    private static int method02(int a, int b) {
        int c = a + b;
        return c;
    }
}
// 思考问题
// 1. 垃圾回收是否涉及栈内存？
// 不会 栈内存是一次次方法调用所产生的栈帧内存，栈帧内存在每一次方法调用结束后都会被弹出栈，即自动回收掉，所以不需要GC
// 2. 栈内存分配越大越好吗？
// 栈内存可以通过参数-Xss Size指定大小，默认1M，栈内存分配得大，理论线程上限越少。可以提供更多空间给到递归方法调用
// 3. 方法内的局部变量是否线程安全？