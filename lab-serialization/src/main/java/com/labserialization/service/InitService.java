package com.labserialization.service;

import com.labserialization.domain.Person;
import com.labserialization.domain.PersonWithOutSerializable;
import com.labserialization.domain.PersonWithTransient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Slf4j
@Service
public class InitService {

    private static final String SERIALIZE_PERSON = "Serialize Person={}";

    /**
     * Quando dizemos que um objeto é serializado, estamos afirmando que este objeto será transformado em bytes, e
     * poderá ser armazenado em disco ou transmitido por um stream.
     *
     * O stream é um objeto de transmissão de dados, onde um fluxo de dados serial é feito através de uma origem e de
     * um destino.
     */
    @PostConstruct
    public void init() {
        withSerialization(new Person("Jhon", 40, new BigDecimal(9000)));
        withTransient(new PersonWithTransient("Jhon", 40, new BigDecimal(9000)));
        withoutSerialization(new PersonWithOutSerializable("Jhon", 40, new BigDecimal(9000)));
    }

    private void withSerialization(Person person) {
        byte[] bytes = SerializeService.convertObjectToBytes(person);

        Person p = (Person) SerializeService.convertBytesToObject(bytes);

        log.info(SERIALIZE_PERSON, p.toString());
    }

    private void withoutSerialization(PersonWithOutSerializable person) {
        try {
            byte[] bytes = SerializeService.convertObjectToBytes(person);

            PersonWithOutSerializable p = (PersonWithOutSerializable) SerializeService.convertBytesToObject(bytes);

            log.info(SERIALIZE_PERSON, p.toString());
        } catch (Exception e) {
            log.info("Não foi possivel efetuar a serializar objeto. Não foi utilizado implements Serializable");
        }
    }

    private void withTransient(PersonWithTransient person) {
        log.info(SERIALIZE_PERSON, person.toString());

        byte[] bytes = SerializeService.convertObjectToBytes(person);

        PersonWithTransient p = (PersonWithTransient) SerializeService.convertBytesToObject(bytes);

        log.info(SERIALIZE_PERSON, p.toString());
    }
}
