package com.codeko.java9.features;

import java.util.Date;

/**
 * From Java 7, interface has constant variables and abstract methods only, we have to use abstract class to have non-abstract method,
 * but in java, we can extends only one abstract or concrete class, when we can implement multi interface.
 *
 * From Java 8, we can write default and static methods in interface, it is because of backward compatibility with old implementation of
 * interfaces which is enhanced with lambda expression in java 8 release. By adding default and static methods, it doesn't break the main intent of
 * java interface which is specify a contract that any class can implement without having to alter its position in class hierarchy
 * @see <a href="https://stackoverflow.com/questions/29997052/reason-for-adding-default-and-static-methods-in-interfaces>Stack Overflow</a>
 *
 * Since Java 9, private method comes to the game to solve shortcoming from previous java version
 *
 * Extra noted: Functional Interface is an interface has only one abstract class, and as many as default or static methods as we want
 * We can annotate funcational interface with @FunctionalInterface annotation, but it's not require for functional interface definition,
 * only benefit when we add that annotation is to make it clear at the first seen and avoid breaking the rule when adding
 * other abstract methods to an existing functional interface
 * */
@FunctionalInterface
interface Java9Interface {
    int abstractMethod();

    default String defaultMethod1() {
        return "This message comes from default method 1, with date is " + currentDate();
    }

    default String defaultMethod2() {
        return "This message comes from default method 2, with date is " + currentDate();
    }

    static String staticMethod() {
        return "return from static method with date is " + currentDateStatic();
    }

    private Date currentDate() {
        System.err.println("Value return from abstractMethod() is: " + abstractMethod());
        return new Date();
    }

    private static Date currentDateStatic() {
        return new Date();
    }
}
