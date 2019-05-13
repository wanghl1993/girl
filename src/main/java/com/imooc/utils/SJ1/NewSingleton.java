package com.imooc.utils.SJ1;

public class NewSingleton {

    private NewSingleton(){

    }

    public static NewSingleton getInstance(){
        return SingletonInstance.instance;
    }

    private static class SingletonInstance{
        static NewSingleton instance = new NewSingleton();
    }


}
