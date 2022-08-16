/**
 * @author wentao
 * 2022/8/3 - 21:47
 */
public class _7StringBuilder01 {
    // StringTable [ "a", "b", "ab" ] hashtable 结构，不能扩容
    public static void main(String[] args) {
        // 常量池中的信息，都会被加载到运行时常量池中，这时 a b ab 都是常量池中的符号，还没有变为 java 字符串对象
        // ldc #2 会把 a 符号变为"a"字符串对象
        // ldc #3 会把 b 符号变为"b"字符串对象
        // ldc #4 会把 ab 符号变为"ab"字符串对象

        String s1 = "a";
        String s2 = "b";
        String s3 = "ab";
        String s4 = s1 + s2;  // new StringBuilder().append("a").append("b").toString()  new String("ab")
        String s5 = "a" + "b"; // javac 在编译期间的优化，结果已经在编译器确定为ab
        String s6 = s4.intern();
        //intern方法在jdk1.8的解释如下：
        //public native String intern();
        //返回字符串对象的规范表示。
        //最初为空的字符串池由String类String 。
        //当调用intern方法时，如果池已经包含与equals(Object)方法确定的相当于此String对象的字符串，则返回来自池的字符串。 否则，此String对象将添加到池中，并返回对此String对象的引用。
        //由此可见，对于任何两个字符串s和t ， s.intern() == t.intern()是true当且仅当s.equals(t)是true 。


        //System.out.println(s3 == s4);
        //System.out.println(s3 == s5);
        //System.out.println(s3 == s6);

        //String x2 = new String("c") + new String("d");
        //
        //x2.intern();
        //String x1 = "cd";
        
        //System.out.println(x1 == x2);

    }
}
