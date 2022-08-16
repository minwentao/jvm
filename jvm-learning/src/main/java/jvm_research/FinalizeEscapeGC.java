package jvm_research;

/**
 * 此代码演示了两点：
 * 1.对象可以在被GC时获得自我拯救
 * 2.这种自救的机会只有一次，因为一个对象的finalize()方法最多只会被系统自动调用一次
 * @author wentao
 * 2022/8/6 - 12:29
 */
public class FinalizeEscapeGC {
    public static FinalizeEscapeGC SAVE_HOOK = null;
    private static String name = "sj";
    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println("finalize method executed!");
        FinalizeEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws InterruptedException {
        SAVE_HOOK = new FinalizeEscapeGC();



        SAVE_HOOK = null;
        System.gc();
        Thread.sleep(500);

        if(SAVE_HOOK != null) {
            System.out.println("alive");
        } else {
            System.out.println("dead");
        }
    }



}