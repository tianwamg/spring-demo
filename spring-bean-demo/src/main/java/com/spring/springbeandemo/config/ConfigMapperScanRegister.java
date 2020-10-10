package com.spring.springbeandemo.config;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.BeanNameGenerator;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.annotation.AnnotationAttributes;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.type.AnnotationMetadata;

import java.io.File;

public class ConfigMapperScanRegister implements ImportBeanDefinitionRegistrar, ResourceLoaderAware {
    private ResourceLoader resourceLoader;
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }


    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        try{
            AnnotationAttributes attributes = AnnotationAttributes.fromMap(importingClassMetadata.getAnnotationAttributes(ConfigMapperScan.class.getName()));
            String pkgVal = attributes.getString("value");
            String pathVal = pkgVal.replace(".","/");
            File[] files = resourceLoader.getResource(pathVal).getFile().listFiles();
            for(File file:files){
                String name = file.getName().replace(".class","");
                Class<?> clazz = Class.forName(pkgVal+"."+name);
                if(clazz.isInterface() && !clazz.isAnnotation()){
                    BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition();
                    AbstractBeanDefinition beanDefinition = beanDefinitionBuilder.getBeanDefinition();
                    beanDefinition.setBeanClass(ConfigBeanFactoryBean.class);
                    beanDefinition.getConstructorArgumentValues().addGenericArgumentValue(pkgVal+"."+name);
                    registry.registerBeanDefinition(name,beanDefinition);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
