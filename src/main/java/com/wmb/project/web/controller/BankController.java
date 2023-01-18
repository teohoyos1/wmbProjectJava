package com.wmb.project.web.controller;

import com.wmb.project.domain.BankD;
import com.wmb.project.domain.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping("/all")
    public ResponseEntity<List<BankD>> getAll() {
        return new ResponseEntity<>(bankService.getAllBanks(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BankD> getBank(@PathVariable("id") Integer bankId){
        return this.bankService.getBank(bankId)
                .map(bankD -> new ResponseEntity<>(bankD, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public BankD save(@RequestBody BankD bankD){
        return bankService.save(bankD);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<List<BankD>> delete(@PathVariable("id") int bankId){
        if (!bankService.delete(bankId)){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<BankD> update(@RequestBody BankD bankD){
        //No viene ningún id en el update
        if (bankD == null || bankD.getBankId() == 0){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(bankService.update(bankD), HttpStatus.OK);

    }
}
