package com.iamtek.spring1.beanfactory;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class DrawingApp {

    public static void main(String[] args) {

        //Triangle triangle = new Triangle();
        BeanFactory factory = new XmlBeanFactory(new FileSystemResource("JavaBrains/src/com/iamtek/spring1/spring-beanfactory.xml"));
        Triangle triangle = (Triangle) factory.getBean("triangle");
        triangle.draw();

    }

}
