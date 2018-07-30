package com.springInaction.knights;

import java.io.PrintStream;

/**
 * Created by zhu on 2018/7/3.
 */
public class Minstrel {
    private PrintStream stream;

    public Minstrel(PrintStream stream){
        this.stream = stream;
    }

    //
    public void singBeforeQuest(){
        stream.println("Fa la la, the knight is do brave");
    }

    public void singAfterQuest(){
        stream.println("Tee hee hee, the brave knight" + "didi embark on a quest!");
    }
}
