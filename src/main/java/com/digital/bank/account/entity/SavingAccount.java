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
    String firstName;
    String middleName;
    String lastName;
    String address;
    String kycDocument;
    String kycIdentificationNo;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        SavingAccount that = (SavingAccount) o;

        return new EqualsBuilder()
                .append(id, that.id)
                .append(accountNumber, that.accountNumber)
                .append(firstName, that.firstName)
                .append(middleName, that.middleName)
                .append(lastName, that.lastName)
                .append(address, that.address)
                .append(kycDocument, that.kycDocument)
                .append(kycIdentificationNo, that.kycIdentificationNo)
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
                .toHashCode();
    }
}
