package com.springInaction.knights;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhu on 2018/6/29.
 */
public class BraveKnightTest {
    @org.junit.Test
    public void embarkOnQuestTest() throws Exception {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configurationXMLs/knights.xml");
        BraveKnight knight = context.getBean(BraveKnight.class);
        knight.embarkOnQuest();;
        context.close();
    }
}
