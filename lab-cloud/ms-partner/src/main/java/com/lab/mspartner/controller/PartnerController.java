package com.lab.mspartner.controller;

import com.lab.mspartner.entity.PartnerEntity;
import com.lab.mspartner.model.PartnerRequest;
import com.lab.mspartner.usecase.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @PostMapping
    public ResponseEntity<PartnerEntity> insert(@RequestBody @Valid PartnerRequest request) {
        return new ResponseEntity<>(partnerService.insert(request), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<PartnerEntity>> getAllPartners() {
        return new ResponseEntity<>(partnerService.getAllPartners(), HttpStatus.OK);
    }

    @GetMapping("/find/{cnpjCpf}")
    public ResponseEntity<PartnerEntity> getPartner(@PathVariable Long cnpjCpf) {
        return new ResponseEntity<>(partnerService.getPartner(cnpjCpf), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{cnpjCpf}")
    public ResponseEntity<Long> deletePartner(@PathVariable Long cnpjCpf) {
        return new ResponseEntity<>(partnerService.deletePartner(cnpjCpf), HttpStatus.OK);
    }

    @PatchMapping
    public ResponseEntity<Long> updatePartner(@RequestBody @Valid PartnerRequest request) {
        return new ResponseEntity<>(partnerService.updatePartner(request), HttpStatus.OK);
    }
}
