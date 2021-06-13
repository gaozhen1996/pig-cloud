package com.gz.pigcloud.exceptions;

import com.gz.pigcloud.api.CommonResult;
import com.gz.pigcloud.api.ResultCode;

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
        else if (e instanceof UserNotExistsException ) {
            result.setMsg(ResultCode.USERNOTEXISTS.getMessage());
            result.setCode(ResultCode.USERNOTEXISTS.getCode());
        } 
        else if (e instanceof PasswordErrorException ) {
            result.setMsg(ResultCode.PASSWORDERROR.getMessage());
            result.setCode(ResultCode.PASSWORDERROR.getCode());
        }          
        else {
            result.setMsg(e.toString());
            result.setCode(ResultCode.FAILED.getCode());
        }
        return result;
    }
}
