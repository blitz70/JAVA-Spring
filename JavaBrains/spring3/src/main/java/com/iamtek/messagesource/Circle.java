package com.iamtek.messagesource;

import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

@Component
public class Circle implements Shape {

    @Resource(name = "pointZero")
    private Point center;
    @Resource(name = "messageSource")
    private MessageSource messageSource;

    public MessageSource getMessageSource() {
        return messageSource;
    }

    public void setMessageSource(MessageSource messageSource) {
        this.messageSource = messageSource;
    }

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {
        //System.out.println("Circle drawn.");
        System.out.println(messageSource.getMessage("draw.circle", null, "Default Draw", null));
        //System.out.println("Center point (" + this.center.getX() + ", " + this.center.getY() +")");
        Object[] param = {this.center.getX(), this.center.getY()};
        System.out.println(messageSource.getMessage("draw.point", param, "Default Draw", null));
        System.out.println(messageSource.getMessage("greeting.circle", null, "Default Greeting", null));

    }

    @PostConstruct
    public void initCircle() {
        System.out.println("Init of Circle");
    }

    @PreDestroy
    public void destroyCircle() {
        System.out.println("Destroy of Circle");
    }

}
