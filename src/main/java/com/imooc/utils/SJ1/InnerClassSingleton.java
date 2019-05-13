package com.imooc.utils.SJ1;

public class InnerClassSingleton {

    public static Singleton getInstance(){
        return Singleton.singleton;
    }

    private static class Singleton{
        protected static Singleton singleton = new Singleton();
    }

}
