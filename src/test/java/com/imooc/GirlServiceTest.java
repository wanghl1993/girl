package com.imooc;

import com.imooc.domain.Girl;
import com.imooc.service.GirlService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by xeshen_channelsoft on 2018/7/5.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class GirlServiceTest {

    @Autowired
    private GirlService girlService;

//    @Test
//    public void findOneTest(){
//        Girl girl = girlService.findOne(20);
//        //断言
//        Assert.assertEquals(new Integer(14),girl.getAge());
//    }

}
