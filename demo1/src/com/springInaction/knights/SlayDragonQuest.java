package com.springInaction.knights;

import java.io.PrintStream;
/**
 * Created by zhu on 2018/7/3.
 */
public class SlayDragonQuest implements Quest {
    private PrintStream stream;
    public SlayDragonQuest(PrintStream stream){
        this.stream = stream;
    }
    public void embark(){
        stream.println("Embarking on quest to slay the dragon!");
    }
}
