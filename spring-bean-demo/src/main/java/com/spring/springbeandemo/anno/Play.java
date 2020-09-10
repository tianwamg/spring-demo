package com.spring.springbeandemo.anno;

public class Play {

    private CD cd;

    public void play(){
        cd.sound();
    }

    public void setCd(CD cd){
        this.cd = cd;
    }
}
