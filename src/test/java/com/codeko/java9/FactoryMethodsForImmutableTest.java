package com.codeko.java9;

import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.*;

public class FactoryMethodsForImmutableTest {

    /**
     * The reason for those new factory methods from java 9 is to get rid of tedious and verbose steps used by
     * java 8 and earlier versions, which use Collections.unmodifiableList()
     * */
    @Test(expected = UnsupportedOperationException.class)
    public void testModifyImmutableListCreatedByFactoryMethod() {
        List<Integer> list = List.of(1);
        assertEquals(1, list.size());
        list.add(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testInitializeImmutableSetCreatedWithDuplicateValuesByFactoryMethod() {
        Set.of(1, 1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCreateUnmodifiableMapByUsingUtilityMethodFromCollectionsClass() {
        Map<Integer, String> map = new HashMap<>();
        Map<Integer, String> unmodifiableMap = Collections.unmodifiableMap(map);
        unmodifiableMap.put(1, "One");
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testCreateUnmodifiableMapByUsingFactoryMethodFromMapInterfaceJava9() {
        Map<Integer, String> unmodifiableMap = Map.of(1, "One", 2,"Two");
        unmodifiableMap.put(1, "One");
    }

    /**
     * The reason why java 9 provides two utility methods to create unmodifiable map is Map.of() is not varargs method,
     * while Map.ofEntries() is it. if we want to create unmodifiable map with
     * */
    @Test(expected = UnsupportedOperationException.class)
    public void testCreateUnmodifiableMapByUsingFactoryMethodMapOfEntriesFromMapInterfaceJava9() {
        Map<Integer, String> unmodifiableMap = Map.ofEntries(Map.entry(1, "One"), Map.entry(2, "Two"));
        unmodifiableMap.put(3, "Three");
    }
}