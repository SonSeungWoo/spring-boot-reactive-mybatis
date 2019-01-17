package me.seungwoo;

public enum MessageCode {
    SUCCESS(200, "성공."),
    ERROR(500, " 서버 에러");


    private final int code;
    private final String message;


    private MessageCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public int getCode() {
        return this.code;
    }
}
