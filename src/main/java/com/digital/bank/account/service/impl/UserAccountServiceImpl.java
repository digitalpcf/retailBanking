package com.digital.bank.account.service.impl;

import com.digital.bank.account.dao.SavingAccountDao;
import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;
import com.digital.bank.account.entity.SavingAccount;
import com.digital.bank.account.service.UserAccountService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {

    public static final String STR = ",";

    @Autowired
    SavingAccountDao savingAccountDao;

    @Value(value = "${user_bank.message.success}")
    String messageSuccess;

    @Value(value = "${user_bank.message.fail}")
    String messageFail;

    @Value(value = "${user_bank.message.hello}")
    String hello;

    @Override
    public CreateAccountResponseDto createUserAccount(UserAccountDto userAccountDto) {

        SavingAccount savingAccount = new SavingAccount();
        CreateAccountResponseDto createAccountResponseDto = new CreateAccountResponseDto();

        BeanUtils.copyProperties(userAccountDto,savingAccount);
        savingAccount.setAccountNumber(userAccountDto.getFirstName()+userAccountDto.getKycIdentificationNo());
        savingAccountDao.save(savingAccount);

        Optional<SavingAccount> optionalSavingAccountSaved = savingAccountDao.findByAccountNumber(savingAccount.getAccountNumber());
        if(optionalSavingAccountSaved.isPresent()){

            savingAccount = optionalSavingAccountSaved.get();

            createAccountResponseDto.setAccountNumber(savingAccount.getAccountNumber());
            String message = new StringBuilder(hello).append(savingAccount.getFirstName()).append(STR).append(messageSuccess).toString();
            createAccountResponseDto.setMessage(message);

        }else{

            String message = new StringBuilder(hello).append(savingAccount.getFirstName()).append(STR).append(messageFail).toString();
            createAccountResponseDto.setMessage(message);

        }

        return createAccountResponseDto;
    }

    @Override
    public Optional<List<CreateAccountResponseDto>> fetchAllUserAccount() {

        List<SavingAccount> userAccountList = savingAccountDao.findAll();

        List<CreateAccountResponseDto> createAccountResponseDtoList = userAccountList.stream().map(userAccount -> {

            CreateAccountResponseDto createAccountResponseDto = new CreateAccountResponseDto();
            createAccountResponseDto.setAccountNumber(userAccount.getAccountNumber());
            return createAccountResponseDto;
        }).collect(Collectors.toList());

        return Optional.of(createAccountResponseDtoList);

    }
}
