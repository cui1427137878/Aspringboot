package com.atguigu.springcloud.entities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
//@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T>{
    //404 not_found,前后端交互，给前段简单的显示
    private Integer code;
    private String message;
    private   T      data;

    public CommonResult(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(Integer code, String message){
       this(200,"message",null);
    }
}
