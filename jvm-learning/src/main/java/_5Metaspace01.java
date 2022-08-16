import jdk.internal.org.objectweb.asm.ClassWriter;
import jdk.internal.org.objectweb.asm.Opcodes;

/**
 * @author wentao
 * 2022/8/3 - 19:30
 * 演示元空间内存溢出
 * -XX:MaxMetaspaceSize=10m
 */
public class _5Metaspace01 extends ClassLoader { // 可以用来加载类的二进制字节码
    public static void main(String[] args) throws Throwable {
        int j = 0;

        try {
            _5Metaspace01 test = new _5Metaspace01();
            for (int i = 0; i < 10000; i++, j++) {
                // ClassWriter 作用 生成类的二进制字节码
                ClassWriter cw = new ClassWriter(0);
                // 版本号，public，类名，包名，类的父类，接口
                cw.visit(Opcodes.V1_8,Opcodes.ACC_PUBLIC,"Class" + i, null, "java/lang/Object", null);
                // 返回byte数组
                byte[] code = cw.toByteArray();
                // 执行类加载
                test.defineClass("Class" + i, code, 0, code.length);

            }
        } finally {
            System.out.println(j);

        }

    }
}
