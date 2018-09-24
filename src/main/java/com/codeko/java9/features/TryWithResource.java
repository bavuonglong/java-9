package com.codeko.java9.features;
/**
 * try with resource comes from java 7, but it has one tiny bug, it's we can not use any resource which is declared outside
 * of try statement, to overcome that thing, we have to create another local variable refer to that resource.
 *
 * Java 9 resolves that issue
 *
 * Extra noted:
 *  + with normal try catch, if exception throws from both try block and finally block, the method returns the exception thrown in finally block
 *  + with try with resource, if exception throws from both try block and try-with-resource statement, then method returns the exception thrown in try block
 * */
public class TryWithResource {
    public static void main(String[] args) throws Exception {
        try {
            tryWithResourceException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            normalTryException();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void normalTryException() throws Exception {
        MyResource mr = null;
        try {
            mr = new MyResource();
            System.out.println("MyResource created in try block");
            if (true)
                throw new Exception("Exception in try");
        } finally {
            if (mr != null)
                mr.close();
        }

    }

    private static void tryWithResourceException() throws Exception {
        MyResource mr = new MyResource();
        try (mr) {
            System.out.println("MyResource created in try-with-resources");
            if (true)
                throw new Exception("Exception in try");
        }
    }

    static class MyResource implements AutoCloseable {

        @Override
        public void close() throws Exception {
            System.out.println("Closing MyResource");
            throw new Exception("Exception in Closing");
        }

    }
}
