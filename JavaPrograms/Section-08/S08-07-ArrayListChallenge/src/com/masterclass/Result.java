package com.masterclass;

public class Result {
    private boolean success;
    private String message;

    public Result() {
        this(true, "");
    }
    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public void setResult(boolean success, String message){
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getMessage() {
        return message;
    }
}
