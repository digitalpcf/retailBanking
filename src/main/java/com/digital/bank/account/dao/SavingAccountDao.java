package com.digital.bank.account.dao;

import com.digital.bank.account.entity.SavingAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SavingAccountDao extends JpaRepository<SavingAccount, Integer> {

    Optional<SavingAccount> findByAccountNumber(String accountNumber);

    @Query("update SavingAccount acc set acc.amount =:amount ")
    void updateAmount(@Param("amount") long amount);
}
