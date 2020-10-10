package com.spring.springbeandemo.config;

import org.springframework.beans.factory.FactoryBean;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ConfigBeanFactoryBean implements FactoryBean, InvocationHandler {
    private Class clazz;

    public ConfigBeanFactoryBean(Class clazz){
        this.clazz = clazz;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        ConfigSql annotation = method.getAnnotation(ConfigSql.class);
        String sql = annotation.value();
        System.out.println(sql);
        return sql;
    }

    public Object getObject() throws Exception {
        Object o = Proxy.newProxyInstance(this.getClass().getClassLoader(),new Class[]{clazz},this);
        return o;
    }

    public Class<?> getObjectType() {
        return clazz;
    }
}
