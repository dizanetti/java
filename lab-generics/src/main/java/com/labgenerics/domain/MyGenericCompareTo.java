package com.labgenerics.domain;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyGenericCompareTo {

    public static <T extends Comparable<T>> int compareTo(T t1, T t2) {
        return t1.compareTo(t2);
    }
}
