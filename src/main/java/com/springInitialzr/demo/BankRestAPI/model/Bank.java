package com.springInitialzr.demo.BankRestAPI.model;

import java.util.Objects;

public class Bank {

    private String bankName;
    private String branch;
    private String ifscCode;
    private String address;

    public Bank() {

    }

    public Bank(String bankName, String branch, String ifscCode, String address) {
        super();
        this.bankName = bankName;
        this.branch = branch;
        this.ifscCode = ifscCode;
        this.address = address;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public void setIfscCode(String ifscCode) {
        this.ifscCode = ifscCode;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bank)) return false;
        Bank bank = (Bank) o;
        return getBankName().equals(bank.getBankName()) &&
                getBranch().equals(bank.getBranch()) &&
                getIfscCode().equals(bank.getIfscCode()) &&
                Objects.equals(getAddress(), bank.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBankName(), getBranch(), getIfscCode(), getAddress());
    }

    @Override
    public String toString() {
        return "Bank{" +
                "bankName='" + bankName + '\'' +
                ", branch='" + branch + '\'' +
                ", ifscCode='" + ifscCode + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
