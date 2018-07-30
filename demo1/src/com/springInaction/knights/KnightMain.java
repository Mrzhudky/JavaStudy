package com.springInaction.knights;

import org.springframework.context.support.ClassPathXmlApplicationContext;
/**
 * Created by zhu on 2018/7/3.
 */
public class KnightMain {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("configurationXMLs/knights.xml");
        BraveKnight knight = context.getBean(BraveKnight.class);
        knight.embarkOnQuest();;
        context.close();
    }
}
