package com.gz.pigvideo.exceptions;

import com.gz.pigvideo.api.CommonResult;
import com.gz.pigvideo.api.ResultCode;

public class ExceptionHandler {
    public static CommonResult<?> handlerException(Throwable e) {
    	CommonResult<?> result = new CommonResult<Integer>();
        // 已知异常
        if (e instanceof ParaException) {
            result.setMsg(ResultCode.VALIDATE_FAILED.getMessage());
            result.setCode(ResultCode.VALIDATE_FAILED.getCode());
        }
        // 自己抛出的
        else if (e instanceof UnloginException ) {
            result.setMsg(ResultCode.UNAUTHORIZED.getMessage());
            result.setCode(ResultCode.UNAUTHORIZED.getCode());
        }
        else {
            result.setMsg(e.toString());
            result.setCode(ResultCode.FAILED.getCode());
        }
        return result;
    }
}
