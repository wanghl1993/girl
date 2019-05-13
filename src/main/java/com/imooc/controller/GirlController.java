package com.imooc.controller;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.imooc.aspect.HttpAspect;
import com.imooc.domain.Girl;
import com.imooc.domain.Result;
import com.imooc.respository.GirlRespository;
import com.imooc.service.GirlService;
import com.imooc.utils.ResultUtil;
import com.imooc.vo.ResultVo;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static jdk.nashorn.internal.objects.Global.getJSON;

/**
 * Created by xeshen_channelsoft on 2018/6/24.
 */
@RestController
public class GirlController {

    private  final static Logger logger = LoggerFactory.getLogger(GirlController.class);

    @Autowired
    private GirlRespository girlRespository;

    @Autowired
    private GirlService girlService;

    /**
     * 查询所有女生列表
     * @return
     */
    @GetMapping(value = "/girls")
    public List<Girl> girlList(){
        System.out.println("girlList");
//        long timestamps = new Date().getTime(); //时间戳
        return girlRespository.findAll();
    }

    /**opop
     * 添加一个女生
     * @return
     */
    @PostMapping(value = "/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult bingBindingResult){
        Result result = new Result();
        if(bingBindingResult.hasErrors()){
//            return null;
            return ResultUtil.error(1,bingBindingResult.getFieldError().getDefaultMessage());
        }

        girl.setCupSize(girl.getCupSize());
        girl.setAge(girl.getAge());

        return ResultUtil.success(girlRespository.save(girl));
    }

    /**
     * 查询一个女生
     */
//    @GetMapping(value = "/girls/{id}")
//    public Girl girlFindOne(@PathVariable("id") Integer id){
////        return girlRespository.findById(id).get();
//        return girlRespository.findOne(id);
//    }

    /**
     * 更新
     * x-www-form-urlencoded
     */
    @PutMapping(value = "/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age){
        Girl girl = new Girl();

        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);

        return girlRespository.save(girl);
    }

    /**
     * 删除
     */
    @DeleteMapping(value = "/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id){
        girlRespository.deleteById(id);
    }

    //通过年龄来查询女生列表
    @GetMapping(value = "/girls/age/{age}")
    public List<Girl> findByAge(@PathVariable("age") Integer age){
        return girlRespository.findByAge(age);
    }


    @PostMapping(value = "/girls/two")
    public void girlTwo(){
        girlService.insertTwo();
    }


    @PostMapping(value = "/girls/json")
    public ResultVo girlData(@RequestBody Girl girl){
        ResultVo rVo = new ResultVo();

        rVo.setCode(0);
        rVo.setMsg("ok");
        //JSON处理
        //Lambda JSONP  ::  map
        JSONObject jsonObject = JSONObject.fromObject(girl.toString());
        JSONArray jarr = jsonObject.getJSONArray(girl.toString());
        for (int i = 0; i < jarr.size(); i++) {

            /** **/
//            JSONObject jsono = (JSONObject)
            System.out.println(jarr.get(i));

            /**取出list下的name的值 **/
//            names=names+jsono.getString("name");

        }
        //        for (int i = 1;jsonObject.size()>0;i++){
//            System.out.print(jsonObject.g);
//        }
//        JSONArray jGirl =
//
//        getJSON(girl.toString());

        return rVo;
    }

    @GetMapping(value = "girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception {
//        Optional<Girl> optional = girlRespository.findById(id);
//        optional.get().getAge();
        girlService.getAge(id);
    }



}
