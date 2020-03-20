package com.springInitialzr.demo.BankRestAPI.service;

import com.springInitialzr.demo.BankRestAPI.model.Bank;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class BankService {

    private List<Bank> bankDetails = new ArrayList<>(Arrays.asList(
            new Bank("ICICI Bank","Madhapur Branch","ICIC001234", "Madhapur, Hyderabad"),
            new Bank("HDFC","HiTech City Branch","HDFC001234", "HiTech City, Hyderabad"),
            new Bank("Kotak Mahindra Bank","Kondapur Branch","KTKM001234", "Kondapur, Hyderabad")
    ));

    public List<Bank> getBankDetails() {
        return bankDetails;
    }

    public Bank getBank(String id){
        return bankDetails.stream().filter(b -> b.getBankName().equals(id)).findFirst().get();
    }

    public void addBank(Bank bank){
        bankDetails.add(bank);
    }

    public void updateBank(Bank bank, String id) {
        for(int i=0; i<bankDetails.size(); i++){
            Bank b = bankDetails.get(i);
            if(b.getBankName().equals(id)){
                bankDetails.set(i, bank);
                return ;
            }
        }
    }


    public void deleteBank(String id) {
        bankDetails.removeIf(t -> t.getBankName().equals(id));
    }
}


