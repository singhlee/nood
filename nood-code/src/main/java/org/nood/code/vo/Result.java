package org.nood.code.vo;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> implements Serializable {

    private T data;
    private String resp_code;
    private String resp_msg;

    public static <T> Result<T> succeed(String msg) {
        return succeedWith(null, ReturnCode.SUCCESS.getCode(),msg);
    }
    public static <T> Result<T> succeed(T data) {
        return succeedWith(data, ReturnCode.SUCCESS.getCode(),"");
    }

    public static <T> Result<T> succeed(T data, String msg) {
        return succeedWith(data, ReturnCode.SUCCESS.getCode(),msg);
    }

    public static <T> Result<T> succeedWith(T data, String code,String msg) {
        return new Result<T>(data, code, msg);
    }
    public static <T> Result<T> failed(T data, String msg) {
        return failedWith(data,  ReturnCode.FAILURE.getCode(), msg);
    }

    public static <T> Result<T> failedWith(T data, String code, String msg) {
        return new Result<T>( data, code, msg);
    }
    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getResp_code() {
        return resp_code;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
    }

    public String getResp_msg() {
        return resp_msg;
    }

    public void setResp_msg(String resp_msg) {
        this.resp_msg = resp_msg;
    }
    public static <T> Result<T> failed(String msg) {
        return failedWith(null, ReturnCode.FAILURE.getCode(), msg);
    }

   @Override
    public String toString() {
        return "Result(data=" + this.getData() + ", resp_code=" + this.getResp_code() + ", resp_msg=" + this.getResp_msg() + ")";
    }

}
