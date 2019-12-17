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
		this.data = data;
	}

	public CommonResult(Throwable e) {
		super();
		this.msg = e.toString();
		this.code = ResultCode.FAILED.getCode();
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
