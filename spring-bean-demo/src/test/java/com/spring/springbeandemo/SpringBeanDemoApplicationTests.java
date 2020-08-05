package com.spring.springbeandemo;

import com.spring.springbeandemo.bean.Person;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootTest
public class SpringBeanDemoApplicationTests {

    /**
     * 参考链接(https://www.cnblogs.com/zrtqsk/p/3735273.html)
     */
    @Test
    public void contextLoads() {
        System.out.println("现在开始初始化容器");

        ApplicationContext factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        System.out.println("容器初始化成功");
        //得到Preson，并使用
        Person person = factory.getBean("person",Person.class);
        System.out.println(person);

        System.out.println("现在开始关闭容器！");
        ((ClassPathXmlApplicationContext)factory).registerShutdownHook();
    }

}
