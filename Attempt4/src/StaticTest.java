//静态变量
class StaticSuper {
    static{
        System.out.println("super static block");
    }

    StaticSuper(){
        System.out.println("super constructor");
    }
}

public class StaticTest extends StaticSuper{
    static double rand;
    static final int x = 12;

    static {
        rand = Math.random()*6;
        System.out.println("StaticTest static block : rand = " +  rand);
    }

    public void go(final int x){
        System.out.println(x);
    }

    StaticTest(){
        System.out.println("StaticTest constructor");
    }

    public static void main(String [] args){
        System.out.println("main first line");
        StaticOther so = new StaticOther();
        StaticTest st = new StaticTest();
        st.go(1);
    }
}

class StaticOther{
    static int y;
    static {
        y = 123;
        System.out.println("StaticOther static block y=" + y);
    }
    StaticOther(){
        System.out.println("StaticOther constructor");
    }
}