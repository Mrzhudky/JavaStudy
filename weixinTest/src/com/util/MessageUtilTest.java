package com.util;

import com.po.TextMessage;

import static org.junit.Assert.*;

public class MessageUtilTest {
    @org.junit.Test
    public void textMessageToXml() throws Exception {
        TextMessage textMessage = new TextMessage();
        textMessage.setToUserName("zhudky");
        textMessage.setFromUserName("不语");
        textMessage.setCreateTime("1348831860");
        textMessage.setContent("this is a test");
        textMessage.setMsgType("text");
        textMessage.setMsgId("1348831860");

        String str = MessageUtil.textMessageToXml(textMessage);
        System.out.println(str);
    }

}