package com.fourzhang.youddit.data;

public class ResultTool {

    public static Result<Integer> success() {
        return new Result<Integer>(ResultCode.SUCCESS);
    }
    
    public static <T> Result<T> success(T data) {
        return new Result<T>(data);
    }

    public static Result<Integer> fail() {
        return new Result<Integer>(ResultCode.COMMON_FAIL);
    }

    public static Result<Integer> fail(ResultCode resultEnum) {
        return new Result<Integer>(resultEnum);
    }
    
    public static <T> Result<T> dataFail(ResultCode resultEnum) {
    	T data = null;
        return new Result<T>(data);
    }
    
}
