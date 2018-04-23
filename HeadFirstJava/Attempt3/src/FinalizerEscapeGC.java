/*
 * “一次对象自我拯救的演示” -- 《深入理解Java虚拟机》
 * 观察Garbage Collection工作中的 finalize()
 */
public class FinalizerEscapeGC {

    public static FinalizerEscapeGC SAVE_HOOK = null;

    public  void isAlive(){
        System.out.println("yes,I am still alive ヾ(o◕∀◕)ﾉヾ");
    }

    @Override
    protected  void finalize() throws Throwable{
        super.finalize();
        System.out.println("finalize mathod executed!");
        FinalizerEscapeGC.SAVE_HOOK = this;
    }

    public static void main(String[] args) throws Throwable {
        SAVE_HOOK = new FinalizerEscapeGC();

        //first times save itself
        SAVE_HOOK = null;
        System.gc();
        //wait 0.5s for finalize mothod
        Thread.sleep(500);
        if (null != SAVE_HOOK ){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("No,I am dead o(>﹏<)o");
        }

        //another times to save itself
        SAVE_HOOK = null;
        System.gc();
        //wait 0.5s for finalize mothod
        Thread.sleep(500);
        if (null != SAVE_HOOK ){
            SAVE_HOOK.isAlive();
        }else {
            System.out.println("No,I am dead ");
        }
    }
}
