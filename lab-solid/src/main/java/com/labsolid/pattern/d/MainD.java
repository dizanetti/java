package com.labsolid.pattern.d;

import com.labsolid.pattern.d.gateway.ISpellChecker;
import com.labsolid.pattern.d.gateway.impl.GreekSpellChecker;
import com.labsolid.pattern.d.gateway.impl.SpellChecker;
import com.labsolid.pattern.d.usecase.Emailer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MainD {

    /**
     * DIP = Dependency Inversion Principle
     *
     * The DIP states that we should depend on abstractions (interfaces and abstract classes) instead of concrete implementations (classes).
     *
     */
    public void start() {
        ISpellChecker defaultChecker = new SpellChecker();
        ISpellChecker greekChecker = new GreekSpellChecker();

        new Emailer(defaultChecker).checkEmail();
        new Emailer(greekChecker).checkEmail();
    }
}
