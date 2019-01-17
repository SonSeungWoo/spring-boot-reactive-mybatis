package me.seungwoo;

import java.util.Collection;

public class ExResponse<T> {
    private int statusCode;
    private String message;
    private Collection<T> data;
    private T datum;

    private ExResponse(ExResponse.Builder<T> builder) {
        this.statusCode = builder.statusCode;
        this.message = builder.message;
        this.data = builder.data;
        this.datum = builder.datum;
    }

    public int getStatusCode() {
        return this.statusCode;
    }

    public String getMessage() {
        return this.message;
    }

    public Collection<T> getData() {
        return this.data;
    }

    public T getDatum() {
        return this.datum;
    }

    public static class Builder<T> {
        private int statusCode;
        private String message;
        private Collection<T> data;
        private T datum;

        public Builder(Collection<T> data) {
            this.data = data;
        }

        public Builder(T datum) {
            this.datum = datum;
        }

        public ExResponse.Builder message(MessageCode code) {
            this.statusCode = code.getCode();
            this.message = code.getMessage();
            return this;
        }

        public ExResponse build() {
            return new ExResponse<>(this);
        }
    }
}
