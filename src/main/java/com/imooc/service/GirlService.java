package com.imooc.service;

import com.imooc.domain.Girl;
import com.imooc.enums.ResultEnum;
import com.imooc.exception.GirlException;
import com.imooc.respository.GirlRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

/**
 * Created by xeshen_channelsoft on 2018/6/25.
 */
@Service
public class GirlService {

    @Autowired
    private GirlRespository girlRespository;

    @Transactional
    public void insertTwo() {

        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(30);
        girlRespository.save(girlA);

        Girl girlB = new Girl();
        girlB.setCupSize("BBBB");
        girlB.setAge(30);
        girlRespository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = new Girl();
        girl.setId(id);
        Example<Girl> example = Example.of(girl);
//        Girl girl = girlRespository.findB;
        Optional<Girl> optional = girlRespository.findOne(example);
        Integer age = optional.get().getAge();
        if (age < 10) {
            //返回你还在上小学吧
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age < 16) {
            //返回你可能在上初中
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
        //如果>16岁,加钱
        //...
    }

    /**
     * 通过Id查询一个女生的信息
     *
     * @param id
     * @return
     */
    public Girl findOne(Integer id) {
        Girl girl = new Girl();
        girl.setId(id);
        Example<Girl> example = Example.of(girl);
        Optional<Girl> optional = girlRespository.findOne(example);
        return optional.get();
    }

}
