package com.masterclass;

public class Result {
    private boolean success;
    private String message;
    boolean suppressResult;
    boolean suppressSuccess;

    public Result() {
        this(true);
    }
    public Result(boolean success) {
        this(success, "");
    }
    public Result(boolean success, String message) {
        this(success, "", true);
    }
    public Result(boolean success, String message, boolean suppressResult) {
        this(success, "", true, true);
    }
    public Result(boolean success, String message, boolean suppressResult, boolean suppressSuccess) {
        this.success = success;
        this.message = message;
        this.suppressResult  = suppressResult;
        this.suppressSuccess = suppressSuccess;
    }

    public void setFail(String message){
        setResult(false, message);
    }
    public void setSucceed(String message){
        setResult(true, message);
    }
    public void setResult(boolean success, String message){
        this.success = success;
        this.message = message;
    }
    public void setSuppress(boolean suppress){
        this.suppressResult = suppress;
    }
    public void reset() {
        this.success = true;
        this.message = "";
        this.suppressResult  = true;
        this.suppressSuccess = true;
    }

    public boolean isSuccess() {
        return success;
    }
    public boolean isSuppress() {
        return suppressResult;
    }
    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return (success ? (suppressSuccess ? "" : "Success. ") : "Error! ") + message;
    }
}
