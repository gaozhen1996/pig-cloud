package com.gz.pigvideo.api;

import java.io.Serializable;

public class CommonResult<T> implements Serializable{
	private static final long serialVersionUID = 1L;

	private String msg;

	private int code;

	private T data;

	public CommonResult() {
		super();
	}

	public CommonResult(T data) {
		super();
		this.code = ResultCode.SUCCESS.getCode();
		this.data = data;
	}

	public CommonResult(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = ResultCode.FAILED.getCode();
	}

	public CommonResult(int code, String msg,T data) {
		super();
		this.msg = msg;
		this.code = code;
		this.data = data;
	}


	public static <T> CommonResult<T> success() {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), null);
    }

	public static <T> CommonResult<T> success(T data) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), ResultCode.SUCCESS.getMessage(), data);
    }
    
	public static <T> CommonResult<T> success(T data, String message) {
        return new CommonResult<T>(ResultCode.SUCCESS.getCode(), message, data);
    }
 
    public static <T> CommonResult<T> failed() {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), ResultCode.FAILED.name(), null);
    }
	
    public static <T> CommonResult<T> failed(String message) {
        return new CommonResult<T>(ResultCode.FAILED.getCode(), message, null);
    }

    public static <T> CommonResult<T> failed(ResultCode errorCode) {
        return new CommonResult<T>(errorCode.getCode(), errorCode.getMessage(), null);
    }
    
	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
	
	
}
