package org.example.components;

import org.apache.catalina.core.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author Ripples
 * @project_name JavaDeep
 * @date 2021/3/29
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("META-INF/applicationContext.xml");
        Test t = (Test) ctx.getBean("test");
        t.save();
    }
}
