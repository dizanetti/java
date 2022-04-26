package com.labsolid.pattern.d.violation_dip;

public class Emailer {

    /**
     * Here is the violation, instantiate the class and not the abstraction
    */
    private final SpellChecker spellChecker;

    public Emailer(SpellChecker sc) {
        this.spellChecker = sc;
    }

    public void checkEmail() {
        this.spellChecker.check();
    }
}
