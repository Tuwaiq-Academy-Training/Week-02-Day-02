package com.example.bank.Controllers;

import com.example.bank.Model.Customer;
import com.example.bank.Model.ResponseAPI;
import com.example.bank.Model.TransferMoney;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class CustomerController {

    private ArrayList<Customer> customers = new ArrayList<>();

    @GetMapping("customer")
    public ResponseEntity<ArrayList<Customer>> getCustomer() {
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("customer")
    public ResponseEntity<ResponseAPI> addCustomer(@RequestBody Customer customer) {
        customers.add(customer);
        return ResponseEntity.status(200).body(new ResponseAPI("User Added Successfully!"));
    }

    @PutMapping("customer/{index}")
    public ResponseEntity<ResponseAPI> updateCustomer(@PathVariable Integer index, @RequestBody Customer customer) {
        if(index > this.customers.size()- 1 || index < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("index is invalid!"));
        }
        this.customers.set(index,customer);
        return ResponseEntity.status(200).body(new ResponseAPI("User Updated Successfully!"));
    }

    @DeleteMapping("customer/{index}")
    public ResponseEntity<ResponseAPI> deleteCustomer(@PathVariable Integer index) {
        if(index > this.customers.size()- 1 || index < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("index is invalid!"));
        }
        this.customers.remove(this.customers.get(index));
        return ResponseEntity.status(200).body(new ResponseAPI("User Deleted Successfully!"));
    }

    @PostMapping("customer/{index}/deposit")
    public ResponseEntity<ResponseAPI> depositMoney(@PathVariable Integer index, @RequestBody double amount) {
        if(index > this.customers.size()- 1 || index < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("index is invalid!"));
        } else if (amount <= 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("amount deposited is invalid!"));
        }
        Customer customer = this.customers.get(index);
        customer.setBalance(customer.getBalance() + amount);
        this.customers.set(index, customer);
        return ResponseEntity.status(200).body(new ResponseAPI("User Deposited Money Successfully!"));
    }

    @PostMapping("customer/{index}/withdraw")
    public ResponseEntity<ResponseAPI> withdrawMoney(@PathVariable Integer index,@RequestBody double amount) {
        if(index > this.customers.size()- 1 || index < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("index is invalid!"));
        } else if (amount < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("Amount withdrawn is less than 0!"));
        }
        Customer customer = this.customers.get(index);
        if(amount > customer.getBalance()) {
            return ResponseEntity.status(400).body(new ResponseAPI("balance is less the the withdraw amount!"));
        }
        customer.setBalance(customer.getBalance() - amount);
        this.customers.set(index, customer);
        return ResponseEntity.status(200).body(new ResponseAPI("User Withdrawn Money Successfully!"));
    }

    @PutMapping("customer/transfer")
    public ResponseEntity<ResponseAPI> transferMoney(@RequestBody TransferMoney transferMoney) {
        if(transferMoney.getId1() > this.customers.size()- 1 || transferMoney.getId1() < 0 || transferMoney.getId2() > this.customers.size()- 1 || transferMoney.getId2() < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("index is invalid!"));
        }
        Customer c1 = this.customers.get(transferMoney.getId1());
        Customer c2 = this.customers.get(transferMoney.getId2());
        if(c1.getBalance() < transferMoney.getAmount()) {
            return ResponseEntity.status(400).body(new ResponseAPI("Balance is low!"));
        }
        c1.setBalance(c1.getBalance() + transferMoney.getAmount());
        c2.setBalance(c2.getBalance() - transferMoney.getAmount());
        return ResponseEntity.status(400).body(new ResponseAPI("Money Transferred Successfully!"));

    }

    @GetMapping("customer/{index}/balance")
    public ResponseEntity getCustomerBalance(@PathVariable Integer index) {
        if(index > this.customers.size()- 1 || index < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("index is invalid!"));
        }

        return ResponseEntity.status(200).body(this.customers.get(index));

    }

}
