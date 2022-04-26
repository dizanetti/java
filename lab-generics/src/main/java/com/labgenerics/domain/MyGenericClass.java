package com.labgenerics.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MyGenericClass<T> {

    private T obj;
}
