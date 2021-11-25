package com.kuzmenko.exchange;

import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        System.out.println("run ...");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    }
}
