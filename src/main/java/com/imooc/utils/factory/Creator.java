package com.imooc.utils.factory;

public class Creator {

    private Creator(){}

    public static IProduct createProduct(String productName){

        if(productName == null){
            return null;
        }
        if(productName.equals("A")){
            return new ProductA();
        } else if(productName.equals("B")){
            return new ProductB();
        } else {
            return null;
        }

    }

}
