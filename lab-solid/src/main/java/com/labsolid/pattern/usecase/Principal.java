package com.labsolid.pattern.usecase;

import com.labsolid.pattern.d.MainD;
import com.labsolid.pattern.i.MainI;
import com.labsolid.pattern.l.MainL;
import com.labsolid.pattern.o.MainO;
import com.labsolid.pattern.s.MainS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
public class Principal {

    @Autowired
    private MainS mainS;

    @Autowired
    private MainO mainO;

    @Autowired
    private MainL mainL;

    @Autowired
    private MainI mainI;

    @Autowired
    private MainD mainD;

    @PostConstruct
    public void start() {
        mainS.start();
        mainO.start();
        mainL.start();
        mainI.start();
        mainD.start();
    }
}
