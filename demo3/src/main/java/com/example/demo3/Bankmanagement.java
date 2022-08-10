package com.example.demo3;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Bankmanagement {

    private ArrayList<Customers> customers = new ArrayList<>();

    @GetMapping("customer")
    public ResponseEntity getCustomers(){
        return ResponseEntity.status(200).body(customers);
    }

    @PostMapping("customer")
    public ResponseEntity addCustomer(@RequestBody Customers customer){
        customers.add(customer);
        return ResponseEntity.status(201).body(customer);
    }


    @PutMapping("customer/{index}")
    public ResponseEntity putUser(@PathVariable int index, @RequestBody Customers customer){
        if( index > customers.size()-1 ){
            return ResponseEntity.status(400).body("customer invalid");
        }else
        customers.set(index,customer);
        return ResponseEntity.status(200).body( " Customer " + customers.get(index).getUsername() + " is Update");
    }

    @PutMapping ("customer/{id}/Depositmoney")
    public ResponseEntity putUserDeposit(@PathVariable int id, @RequestBody int amount) {
        if ( id > customers.size()-1 ) {
            return ResponseEntity.status(400).body("customer invalid");
        } else if(amount < 0){
            return ResponseEntity.status(400).body("amount is  invalid");
        }
            customers.get(id).setBalance(customers.get(id).getBalance()+amount);
           return ResponseEntity.status(200).body("update Amount");
    }


        @PutMapping("customer/{id}/Withdrawmoney")
        public ResponseEntity putUserWithdraw ( @PathVariable int id, @RequestBody int amount){
            if ( id > customers.size()-1  ) {
                return ResponseEntity.status(400).body("customer invalid");
            } else if(amount < 0){
                return ResponseEntity.status(400).body("amount is  invalid");
            }else if (amount > customers.get(id).getBalance()){
                return ResponseEntity.status(400).body("amount is  greater than balance");
            }
                customers.get(id).setBalance(customers.get(id).getBalance()-amount);
            return ResponseEntity.status(200).body("update amount");
        }

          @PutMapping("customer/{id}/{id1}/Transfermoney")
          public ResponseEntity putUserTransfer ( @PathVariable int id,@PathVariable int id1 ,@RequestBody int amount) {
              if ( id > customers.size() - 1 ) {
                  return ResponseEntity.status(400).body("customer invalid");
              } else if (amount < 0) {
                  return ResponseEntity.status(400).body("amount is  invalid");
              } else if (amount > customers.get(id).getBalance()) {
                  return ResponseEntity.status(400).body("amount is  greater than balance");
              }else if ( id1 > customers.size() - 1 ){
                  return ResponseEntity.status(400).body("other customer is invalid");
              }
              customers.get(id).setBalance(customers.get(id).getBalance()-amount);
              customers.get(id1).setBalance(customers.get(id1).getBalance()+amount);
              return ResponseEntity.status(200).body("Transfer success!");
          }

        @DeleteMapping("customer/{id}")
        public ResponseEntity deletUser ( @PathVariable int id){
            if ( id > customers.size() - 1 ) {
                return ResponseEntity.status(200).body("there are no user");
            }
            customers.remove(id);
            return ResponseEntity.status(200).body("user withe index" + customers.get(id).getUsername() + "deleted");
        }

    }
