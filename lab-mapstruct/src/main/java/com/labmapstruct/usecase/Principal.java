package com.labmapstruct.usecase;

import com.labmapstruct.domain.Address;
import com.labmapstruct.domain.Person;
import com.labmapstruct.domain.PersonMapper;
import com.labmapstruct.dto.PersonDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class Principal {

    @PostConstruct
    public void init() {
        Person person = new Person(1L, "Diego", List.of("diego@test.com", "zanetti@test.com"), getAddressMap());

        PersonDto personDto = PersonMapper.MAPPER.personToPersonDto(person);

        log.info(personDto.toString());
    }

    private Map<String, Address> getAddressMap() {
        Map<String, Address> addressMap = new HashMap<>();

        Address homeAddress = new Address("Street Home", 111L, "1111-111");
        Address workAddress = new Address("Street Work", 999L, "9999-999");

        addressMap.put("Home", homeAddress);
        addressMap.put("Work", workAddress);

        return addressMap;
    }
}
