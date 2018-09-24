package com.codeko.java9.diamondoperator;

public class MainApp {
    public static void main(String[] args) {

        MyHandler<Integer> intHandler = new MyHandler<>(1) {

            @Override
            public void handle() {
                System.out.println("handle > " + getContent());
            }
        };

        intHandler.handle();

        MyHandler<? extends Integer> intHandler1 = new MyHandler<>(10) {

            @Override
            void handle() {
                System.out.println("handle > " + getContent());
            }
        };

        intHandler1.handle();

        MyHandler<?> handler = new MyHandler<>("One hundred") {

            @Override
            void handle() {
                System.out.println("handle > " + getContent());
            }
        };

        handler.handle();
    }
}
