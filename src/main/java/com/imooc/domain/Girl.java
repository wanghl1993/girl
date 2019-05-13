package com.imooc.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * Created by xeshen_channelsoft on 2018/6/24.
 */
@Entity
public class Girl {

    @Id
    @GeneratedValue
    private Integer id;

    @NotBlank(message = "这个字段必须传")
    private String cupSize;

    @Min(value = 18,message = "未成年禁止入内")
    private Integer age;

    @NotNull(message = "金额必传")
    private Double money;


    public Girl(){
        //这是个啥
    }

    @Override
    public String toString() {
        return "{" +
                "id:" + id +
                ", cupSize:'" + cupSize  +
                ", age:" + age +
                ", money:" + money +
                '}';
    }

    public Double getMoney() {
        return money;
    }

    public void setMoney(Double money) {
        this.money = money;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
