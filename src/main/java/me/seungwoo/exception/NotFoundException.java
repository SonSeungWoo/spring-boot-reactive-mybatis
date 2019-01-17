package me.seungwoo.exception;

public class NotFoundException extends RuntimeException {

    public NotFoundException(int id) {
        super("not found with id " + id);
    }
}
