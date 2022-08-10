package com.example.bank.controller;

import com.example.bank.model.Api;
import com.example.bank.model.Bank;
import com.example.bank.model.Customer;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BankController {

    ArrayList <Customer> customerList=new ArrayList();

    @GetMapping("/customer")
    public ArrayList<Customer> getCustomers(){
        return customerList;
    }

    @PostMapping("/customer")
    public Api addCustomer(@RequestBody Customer customer){
        customerList.add(customer);
        return new Api("Customer Added !");
    }

    @PutMapping("/customer/{index}")
    public Api updateCustomer(@RequestBody Customer customer, @PathVariable int index){
        customerList.set(index,customer);
        return new Api("Customer updated !");
    }

    @DeleteMapping("/customer/{index}")
    public Api deleteCustomer( @PathVariable int index){
        customerList.remove(index);
        return new Api("Customer deleted !");
    }

    @PostMapping("/customer/deposit")
    public Api deposit(@RequestParam int id,@RequestParam int balance){
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getId()==id){
                int oldBalance=customerList.get(i).getBalance();
                customerList.get(i).setBalance(oldBalance+balance);
                return new Api("Deposit went ok");
            }
        }
        return new Api("Wrong id");
    }

    @PostMapping("/customer/withdraw")
    public Api withdraw(@RequestBody Bank bank){
        for (int i = 0; i < customerList.size(); i++) {
            if(customerList.get(i).getId()==bank.getId()){
                int oldBalance=customerList.get(i).getBalance();
                customerList.get(i).setBalance(oldBalance-bank.getBalance());
                return new Api("Withdraw went ok");
            }
        }
        return new Api("Wrong id");
    }
}
