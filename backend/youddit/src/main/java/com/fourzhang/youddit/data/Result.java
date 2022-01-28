package com.fourzhang.youddit.data;

import java.io.Serializable;

public class Result<T> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final Integer code;
    private final String msg;
    private T data;
    
	public Result(T data) {
		this.code = ResultCode.SUCCESS.getCode();
		this.msg = ResultCode.SUCCESS.getMessage();
		this.data = data;
	}
	public Result(ResultCode resultCode) {
		this.code = resultCode.getCode();
		this.msg = resultCode.getMessage();
		this.data = null;
	}
	
	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Integer getCode() {
		return code;
	}
	public String getMsg() {
		return msg;
	}
    
}
