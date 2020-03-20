package com.springInitialzr.demo.BankRestAPI.controller;

import com.springInitialzr.demo.BankRestAPI.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springInitialzr.demo.BankRestAPI.model.Bank;

import javax.xml.ws.Response;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class BankDetailsController {

    @Autowired
    private BankService bankService;

    /* Method to get all the Bank details
     * in postman:
     * GET: http://localhost:8080/bankDetails/
    */
    @RequestMapping(value="/bankDetails")
    public ResponseEntity<Collection<Bank>> getBankDetails() {
        List bankDetailsRepo = bankService.getBankDetails();
        return new ResponseEntity<>(bankDetailsRepo, HttpStatus.OK);
    }


    /* Method to get a particular bank data
    * in postman:
    * GET: http://localhost:8080/bankDetails/HDFC
    * returns HDFC bank details
    * */
    @RequestMapping(value="/bankDetails/{id}")
    public ResponseEntity<Bank> getBank(@PathVariable String id){
        Bank bank = bankService.getBank(id);
        return new ResponseEntity<>(bank, HttpStatus.OK);
    }

    /* Method to add a new bank data
     * in postman:
     * Post: http://localhost:8080/bankDetails/
     * Body:
     * {
            "bankName": "SBI",
            "branch": "Gachibowli Branch",
            "ifscCode": "SBIN001234",
            "address": "Gachibowli, Hyderabad"
        }
     * Headers:
     *  Key: Content-Type, Value: application/json
     * returns Bank Details Added Successfully
     *
     * If we run GET request now we will get response newly added bank along with previouse bank details
     * */
    @RequestMapping(method= RequestMethod.POST, value="/bankDetails")
    public ResponseEntity<String> addBank(@RequestBody Bank bank){
        bankService.addBank(bank);
        return new ResponseEntity<>("Bank Details Added Successfully", HttpStatus.OK);
    }

    /* Method to update a particular bank details
     * in postman:
     * PUT: http://localhost:8080/bankDetails/SBI
     * Body:
     * {
            "bankName": "SBI",
            "branch": "Gachibowli Branch",
            "ifscCode": "SBIN001234",
            "address": "Waverock, Gachibowli, Hyderabad"
        }
     * Headers:
     *  Key: Content-Type, Value: application/json
     * returns Bank Details Added Successfully
     *
     * If we run GET request now we will get response updated bank details along with existing bank details.
     * */
    @RequestMapping(method= RequestMethod.PUT, value="/bankDetails/{id}")
    public ResponseEntity<String> updateBank(@RequestBody Bank bank, @PathVariable String id ){
        bankService.updateBank(bank, id);
        return new ResponseEntity<>("Bank Details Updated Successfully", HttpStatus.OK);
    }

    /* Method to delete a particular bank details
     * in postman:
     * DELETE: http://localhost:8080/bankDetails/SBI

     * returns Bank Details Deleted Successfully
     *
     * If we run GET request now we will get response only with existing bank details.
     * */
    @RequestMapping(method= RequestMethod.DELETE, value="/bankDetails/{id}")
    public ResponseEntity<String> deleteBank(@PathVariable String id ){
        bankService.deleteBank(id);
        return new ResponseEntity<>("Bank Details Deleted Successfully", HttpStatus.OK);
    }
}
