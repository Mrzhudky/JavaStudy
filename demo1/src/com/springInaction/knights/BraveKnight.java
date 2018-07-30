package com.springInaction.knights;


/**
 * Created by zhu on 2018/6/29.
 */
public class BraveKnight implements Knight{
    private Quest quest;
    public BraveKnight(Quest quest){
        this.quest = quest;
    }
    public void embarkOnQuest(){
        quest.embark();
    }
}
