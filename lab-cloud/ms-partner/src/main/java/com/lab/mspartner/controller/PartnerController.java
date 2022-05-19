package com.lab.mspartner.controller;

import com.lab.mspartner.entity.PartnerEntity;
import com.lab.mspartner.usecase.PartnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/partner")
public class PartnerController {

    @Autowired
    private PartnerService partnerService;

    @GetMapping
    public ResponseEntity<List<PartnerEntity>> getAllPartners() {

        return new ResponseEntity<>(partnerService.getAllPartners(), HttpStatus.OK);
    }
}
