package com.codeko.java9.features;

public class Java9InterfaceImpl {

    public static void main(String[] args) {
        Java9Interface java9Interface = () -> {
            System.out.println("Override abstractMethod");
            return 93;
        };
        System.out.println(java9Interface.defaultMethod1());
        System.out.println(java9Interface.defaultMethod2());
        System.out.println(Java9Interface.staticMethod());
    }
}
