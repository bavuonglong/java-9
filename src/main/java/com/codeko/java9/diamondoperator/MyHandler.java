package com.codeko.java9.diamondoperator;

public abstract class MyHandler<T> {
    private T content;

    public MyHandler(T content) {
        this.content = content;
        System.out.println("constructor for MyHandler with content: " + content.toString());
    }

    public T getContent() {
        return content;
    }

    public void setContent(T content) {
        this.content = content;
    }

    abstract void handle();
}
