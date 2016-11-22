package com.iamtek.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

@Component
public class Circle implements Shape, ApplicationEventPublisherAware{

    @Resource(name = "pointZero")
    private Point center;
    private ApplicationEventPublisher publisher;

    public Point getCenter() {
        return center;
    }

    public void setCenter(Point center) {
        this.center = center;
    }

    public void draw() {
        System.out.println("Circle drawn.");
        System.out.println("Center point (" + this.center.getX() + ", " + this.center.getY() +")");
        DrawEvent event = new DrawEvent(this);
        publisher.publishEvent(event);
    }

    public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

}
