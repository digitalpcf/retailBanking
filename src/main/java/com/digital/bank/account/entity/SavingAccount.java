package com.digital.bank.account.entity;


import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import javax.persistence.*;

@Entity
@Table(name = "t_saving_Account")
public class SavingAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String accountNumber;
    private String firstName;
    private String middleName;
    private String lastName;
    private String address;
    private String kycDocument;
    private String kycIdentificationNo;
    private String currency;
    private long amount;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SavingAccount that = (SavingAccount) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(amount, that.amount)
                .append(accountNumber, that.accountNumber)
                .append(firstName, that.firstName)
                .append(middleName, that.middleName)
                .append(lastName, that.lastName)
                .append(address, that.address)
                .append(kycDocument, that.kycDocument)
                .append(kycIdentificationNo, that.kycIdentificationNo)
                .append(currency, that.currency)
                .isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37)
                .append(id)
                .append(accountNumber)
                .append(firstName)
                .append(middleName)
                .append(lastName)
                .append(address)
                .append(kycDocument)
                .append(kycIdentificationNo)
                .append(currency)
                .append(amount)
                .toHashCode();
    }
}
