package com.spring.springbeandemo.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

public class Person implements BeanFactoryAware, BeanNameAware, InitializingBean, DisposableBean {

    private String name;
    private String address;
    private String phone;

    private BeanFactory beanFactory;

    private String beanname;

    public Person(){
        System.out.println("【构造器】調用Person的实例化构造器");
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        System.out.println("【注入属性】注入属性name");
        this.name = name;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address){
        System.out.println("【注入属性】注入属性address");
        this.address = address;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        System.out.println("【注入属性】注入属性address");
        this.phone = phone;
    }

    @Override
    public String toString(){
        return "Person [ address ="+address+",name="+name+
                ",phone="+phone+" ]";
    }

    // 这是BeanFactoryAware接口方法
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("【BeanFactoryAware接口】调用BeanFactoryAware.setBeanFactory()");
        this.beanFactory = beanFactory;
    }

    // 这是BeanNameAware接口方法
    public void setBeanName(String s) {
        System.out.println("【BeanNameAware接口】调用BeanNameAware.setBeanName()");
        this.beanname = s;
    }

    public void destroy() throws Exception {
        System.out.println("【DiposibleBean接口】调用DiposibleBean.destory()");
    }

    // 这是InitializingBean接口方法
    public void afterPropertiesSet() throws Exception {
        System.out.println("【InitializingBean接口】调用InitializingBean.afterPropertiesSet()");
    }

    // 通过<bean>的init-method属性指定的初始化方法
    public void myInit() {
        System.out.println("【init-method】调用<bean>的init-method属性指定的初始化方法");
    }

    // 通过<bean>的destroy-method属性指定的初始化方法
     public void myDestory() {
        System.out.println("【destroy-method】调用<bean>的destroy-method属性指定的初始化方法");
     }

}
