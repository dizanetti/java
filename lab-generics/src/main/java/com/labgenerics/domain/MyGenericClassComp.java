package com.labgenerics.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MyGenericClassComp<K, V> {

    private K key;
    private V value;

    public void print() {
        log.info("Key: " + key);
        log.info("Value :" + value);
    }
}
