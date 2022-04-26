package com.labsolid.pattern.d.gateway.impl;

import com.labsolid.pattern.d.gateway.ISpellChecker;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpellChecker implements ISpellChecker {

    @Override
    public void check() {
        log.info("SpellChecker");
    }
}
