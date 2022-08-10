package com.example.ExerciseD2.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class BankSystem {

    ArrayList<Customers> array = new ArrayList();


    // GET
    @GetMapping("bank")
    public ArrayList<Customers> bankGet() {
        return array;
    }

    // ADD
    @PostMapping("bank")
    public ResponseEntity bankAdd(@RequestBody Customers customersAdd) {
        array.add(customersAdd);
        return ResponseEntity.status(200).body((new ResponseAPI("Added Successfully")));
    }

    // UPDATE
    @PutMapping("bank/{index}")
    public ResponseEntity bankUpdate(@PathVariable int index, @RequestBody Customers customersUpdate) {
        if (index > array.size() - 1) {
            return ResponseEntity.status(400).body(new ResponseAPI("Bad request!"));
        }
        array.set(index, customersUpdate);
        return ResponseEntity.status(200).body(new ResponseAPI("Updated Successfully!"));
    }

    // DELETE
    @DeleteMapping("bank/{index}")
    public ResponseEntity bankDelete(@PathVariable int index) {
        if (index > array.size() - 1) {
            return ResponseEntity.status(400).body(new ResponseAPI("Bad request!"));
        }
        array.remove(index);
        return ResponseEntity.status(200).body(new ResponseAPI("Deleted Successfully!"));
    }


    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////
    /*
             Bank Transfer
    */
    ///////////////////////////////////
    ///////////////////////////////////
    ///////////////////////////////////

    // Get balance
    @GetMapping("bank/{index}")
    public ResponseEntity customerGet(@PathVariable int index) {
        if (index > array.size() - 1) {
            return ResponseEntity.status(400).body(new ResponseAPI("Bad request!"));
        }
        Customers balance = array.get(index);
        return ResponseEntity.status(200).body(new ResponseAPI("the balance is " + array.get(index).getBALANCE()));

    }

    // Deposit Money $_$
    @PutMapping("deposit/{index}")
    public ResponseEntity customerDepo(@PathVariable int index,@RequestBody int BALANCE){

        if (index > array.size() - 1 || index < 0) {
            return ResponseEntity.status(400).body(new ResponseAPI("Bad request!"));
        }
        Customers bal = array.get(index);
        int i= array.get(index).getBALANCE()+BALANCE;
        array.set(index, bal).setBALANCE(i);
        return ResponseEntity.status(200).body(new ResponseAPI("Deposit Successfully!"));
        }

        // withdraw
    @PutMapping("withdraw/{index}")
    public ResponseEntity customerWithdraw(@PathVariable int index, @RequestBody int BALANCE){
        if (index > array.size() - 1 || index < array.get(index).getBALANCE()) {
            return ResponseEntity.status(400).body(new ResponseAPI("Bad request!"));
        }
        Customers c1 = array.get(index);
        int with1 = array.get(index).getBALANCE()-BALANCE;
        array.set(index, c1).setBALANCE(with1);
            return ResponseEntity.status(200).body(new ResponseAPI("Withdraw Successfully!"));
        }

        // Transfer << i hate it, took me long time nad never worked
        @PutMapping("trans")
    public ResponseEntity transfer(@PathVariable transfer trans){
                for(int x=0;x<array.size();x++){
                    if (trans.getID1()==array.get(x).getID()){
                        if(trans.getMONEY()>array.get(x).getBALANCE()){
                            return ResponseEntity.status(400).body(new ResponseAPI("Money is less than balance!"));
                        }
                        else{ Customers u2=array.get(x);
                            int i2= array.get(x).getBALANCE()-trans.getMONEY();
                            array.set(x, u2).setBALANCE(i2);}
                    }
                    if (trans.getID2()==array.get(x).getID()){
                        Customers u2=array.get(x);
                        int i2= array.get(x).getBALANCE()+trans.getMONEY();
                        array.set(x, u2).setBALANCE(i2);
                    }
                }
            return ResponseEntity.status(200).body(new ResponseAPI("Transfer Successfully!"));}


        }








