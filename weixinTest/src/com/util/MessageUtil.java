package com.util;



import com.po.TextMessage;
import com.thoughtworks.xstream.XStream;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MessageUtil {

    public static final String MESSAGE_TEXT = "text";
    public static final String MESSAGE_IMAGE = "image";
    public static final String MESSAGE_VOICE = "voice";
    public static final String MESSAGE_VIDEO = "video";
    public static final String MESSAGE_LINK = "link";
    public static final String MESSAGE_LOCATION = "location";
    public static final String MESSAGE_EVENT = "event";
    public static final String MESSAGE_SUBSCRIBE = "subscribe";
    public static final String MESSAGE_UNSUBSCRIBE = "unsubscribe";
    public static final String MESSAGE_CLICK = "CLICK";
    public static final String MESSAGE_VIEW = "VIEW";

    /***
     * xml转为map集合
     * @param request
     * @return
     * @throws IOException
     * @throws DocumentException
     */
    public static Map<String,String> xmlToMap(HttpServletRequest request) throws IOException, DocumentException {
        Map<String,String> map =new HashMap<>();

        SAXReader reader = new SAXReader();

        InputStream ins = request.getInputStream();
        Document doc = reader.read(ins);
        Element root = doc.getRootElement();

        List<Element> list = root.elements();

        for (Element e:list) {
            map.put(e.getName(),e.getText());
        }
        ins.close();
        return map;
    }

    /***
     * 将文本消息对象转换为xml对象
     * @param textMessage
     * @return
     */
    public static String textMessageToXml(TextMessage textMessage){
        XStream xStream = new XStream();
        xStream.alias("xml",textMessage.getClass());
        return xStream.toXML(textMessage);
    }

    public static String menuText(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<![CDATA[欢迎关注，请操作：\n\n");
        stringBuffer.append("1、选项一\n");
        stringBuffer.append("2、选项二\n");
        stringBuffer.append("回复？调出此菜单]]>");
        return stringBuffer.toString();
    }
    public static String firstText(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<![CDATA[这是选项一");
        stringBuffer.append("回复？调出此菜单]]>");
        return stringBuffer.toString();
    }
    public static String secondText(){
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("<![CDATA[这是选项二");
        stringBuffer.append("回复？调出此菜单]]>");
        return stringBuffer.toString();
    }

    public static String initText(String toUserName,String fromUserName,String content){
        TextMessage text = new TextMessage();
        text.setFromUserName(toUserName);
        text.setToUserName(fromUserName);
        text.setMsgType(MessageUtil.MESSAGE_TEXT);
        text.setCreateTime(Long.toString(new Date().getTime()));
        text.setContent(content);
        return textMessageToXml(text);
    }
}
