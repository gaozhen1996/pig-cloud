package com.gz.pigvideo.api;

/**
 * 
 * @author gaozhen
 */
public enum ResultCode {
    SUCCESS(2, "操作成功"),
    FAILED(5, "操作失败"),
    VALIDATE_FAILED(4, "参数检验失败"),
    UNAUTHORIZED(4, "暂未登录或token已经过期"),
    FORBIDDEN(4, "没有相关权限"),
	USERNOTEXISTS(4,"用户不存在"),
	PASSWORDERROR(4,"密码错误");
	
    private int code;
    
    private String message;

    private ResultCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
