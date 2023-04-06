package com.demo.controller;

import com.demo.model.Customer;
import com.demo.service.CustomerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/")
public class CustomerController {

    @Autowired
    CustomerServiceImpl customerServiceImpl;

    @PostMapping("/saveData")
    public ResponseEntity<Customer> saveData(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerServiceImpl.saveData(customer));
    }

    @GetMapping("/getDataById/{custId}")
    public ResponseEntity<Optional<Customer>> getDataById(@PathVariable int custId) {
        return ResponseEntity.ok(customerServiceImpl.getDataById(custId));
    }

    @GetMapping("/getAllData")
    public ResponseEntity<List<Customer>> getAllData() {
        return ResponseEntity.ok(customerServiceImpl.getAllData());
    }

    @PutMapping("/updateData")
    public ResponseEntity<Customer> updateData(@RequestBody Customer customer) {
        return ResponseEntity.ok(customerServiceImpl.updateData(customer));
    }

    @DeleteMapping("/deleteDataById/{custId}")
    public ResponseEntity<String> deleteDataById(@PathVariable int custId) {
        customerServiceImpl.deleteDataById(custId);
        return ResponseEntity.ok("Data Deleted");
    }
}
