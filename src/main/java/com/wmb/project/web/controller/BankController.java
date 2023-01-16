package com.wmb.project.web.controller;

import com.wmb.project.domain.BankD;
import com.wmb.project.domain.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping("/all")
    public List<BankD> getAll() {
        return bankService.getAllBanks();
    }
}
