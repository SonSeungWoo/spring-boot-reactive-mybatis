package me.seungwoo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException() {
        //super(String.format("not found with id[%s]", id));
        super("not found");
    }
}
