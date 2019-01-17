package me.seungwoo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super(String.format("not found with id[%s]", id));
    }
}
