package com.xhg.eureka.vo;


@SuppressWarnings("all")
public class RestResponse <T> {
	


    private static final Integer DEFAULT_SUCCESS_CODE = 0;
    private static final Integer DEFAULT_FAIL_CODE = 1;

    /**
     * 状态码，0：成功；1：失败；其他：失败；其他错误码待定
     */
    private Integer code = DEFAULT_SUCCESS_CODE;

    private Boolean success;

    /**
     * 提示语句
     */
    private String msg;

    /**
     * 返回结果集
     */
    private T result = null;

    private RestResponse(Integer code, String msg, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    private RestResponse(String msg, T result, Boolean success) {
        this.msg = msg;
        this.result = result;
        this.success = success;
    }

    private RestResponse(String msg, Boolean success) {
        this.msg = msg;
        this.success = success;
    }

    private RestResponse(T result, Boolean success) {
        this.result = result;
        this.success = success;
    }

    /**
     * 成功，没有返回值，只有信息提示，code为默认值0
     *
     * @param msg
     * @return
     */
    public static RestResponse success(String msg) {
        return new RestResponse(msg, Boolean.TRUE);
    }

    /**
     * 成功，没有信息提示，只有返回值，code为默认值0
     *
     * @return
     */
    public static RestResponse success(Object result) {
        return new RestResponse(result, Boolean.TRUE);
    }

    public static RestResponse success(String msg, Object result) {
        return new RestResponse(msg, result, Boolean.TRUE);
    }

    /**
     * 失败，只有信息提示，没有返回值，code默认为1，其他状态码待定
     *
     * @return
     */
    public static RestResponse fail(String msg) {
        return new RestResponse(DEFAULT_FAIL_CODE, msg, Boolean.FALSE);
    }

    public static RestResponse fail(String msg, Integer code) {
        return new RestResponse(code, msg, Boolean.FALSE);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
	public String toString() {
		return "RestResponse [code=" + code + ", success=" + success + ", msg=" + msg + ", result=" + result + "]";
	}

	
}
