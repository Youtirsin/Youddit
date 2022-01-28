package com.fourzhang.youddit.data;

public enum ResultCode {
	SUCCESS(200, "success"),
	COMMON_FAIL(999, "failed"),
	
	USER_NOT_LOGIN(2001, "user did not login"),
	USER_ACCOUNT_ALREADY_EXIST(2002, "user already exist"),
	USER_CREDENTIALS_ERROR(2003, "wrong password"), 
	USER_ACCOUNT_NOT_EXIST(2004, "no such user"),
	USER_RESET_VERIFIY_FAIL(2005, "user verification failed");
	
	private Integer code;
    private String msg;
	private ResultCode(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return msg;
	}
	public void setMessage(String msg) {
		this.msg = msg;
	}
    
	public static String getMessageByCode(Integer code) {
        for (ResultCode e : values()) {
            if (e.getCode().equals(code)) {
                return e.getMessage();
            }
        }
        return null;
    }
}
