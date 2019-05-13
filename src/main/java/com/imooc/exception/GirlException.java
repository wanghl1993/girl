package com.imooc.exception;

import com.imooc.enums.ResultEnum;

/**
 * Created by xeshen_channelsoft on 2018/7/4.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum){
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
