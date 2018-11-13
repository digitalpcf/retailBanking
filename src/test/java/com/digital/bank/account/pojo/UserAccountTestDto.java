package com.digital.bank.account.pojo;

public class UserAccountTestDto {

    private String accountNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String kycDocument;
    private String kycIdentificationNo;
    private String currency;
    private long amount;

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getKycDocument() {
        return kycDocument;
    }

    public void setKycDocument(String kycDocument) {
        this.kycDocument = kycDocument;
    }

    public String getKycIdentificationNo() {
        return kycIdentificationNo;
    }

    public void setKycIdentificationNo(String kycIdentificationNo) {
        this.kycIdentificationNo = kycIdentificationNo;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }



}
