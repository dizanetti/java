package com.labsolid.pattern.d.usecase;

import com.labsolid.pattern.d.gateway.ISpellChecker;

public class Emailer {
    private final ISpellChecker spellChecker;

    public Emailer(ISpellChecker sc) {
        this.spellChecker = sc;
    }

    public void checkEmail() {
        this.spellChecker.check();
    }
}
