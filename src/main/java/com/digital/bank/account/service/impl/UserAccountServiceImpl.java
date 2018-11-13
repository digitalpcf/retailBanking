package com.digital.bank.account.service.impl;

import com.digital.bank.account.dao.SavingAccountDao;
import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;
import com.digital.bank.account.entity.SavingAccount;
import com.digital.bank.account.service.UserAccountService;
import com.digital.bank.account.validator.UserAccountValidator;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserAccountServiceImpl implements UserAccountService {


    @Autowired
    SavingAccountDao savingAccountDao;

    @Autowired
    UserAccountValidator userAccountValidator;

    @Value(value = "${user_bank.message.success}")
    String messageSuccess;

    @Value(value = "${user_bank.message.fail}")
    String messageFail;

    @Value(value = "${user_bank.message.hello}")
    String hello;

    @Value(value = "${user_bank.message.str}")
    String comma;

    @Value(value = "${user_bank.message.emptySpace}")
    String emptySpace;

    @Override
    public CreateAccountResponseDto createUserAccount(UserAccountDto userAccountDto) {

        CreateAccountResponseDto createAccountResponseDto = new CreateAccountResponseDto();
        userAccountValidator.validateUserAccount(userAccountDto, createAccountResponseDto);

        if (StringUtils.isEmpty(createAccountResponseDto.getMessage())) {

            persistUserAccount(userAccountDto, createAccountResponseDto);
        }

        return createAccountResponseDto;
    }

    private void persistUserAccount(UserAccountDto userAccountDto, CreateAccountResponseDto createAccountResponseDto) {
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(userAccountDto, savingAccount);
        savingAccount.setAccountNumber(userAccountDto.getFirstName() + userAccountDto.getKycIdentificationNo());
        savingAccountDao.save(savingAccount);

        Optional<SavingAccount> optionalSavingAccountSaved = savingAccountDao.findByAccountNumber(savingAccount.getAccountNumber());
        if (optionalSavingAccountSaved.isPresent()) {


            UserAccountDto userAccountDtoPostSave = new UserAccountDto();
            savingAccount = optionalSavingAccountSaved.get();

            String message = buildMessage(savingAccount);

            createAccountResponseDto.setMessage(message);
            BeanUtils.copyProperties(savingAccount, userAccountDtoPostSave);
            createAccountResponseDto.setUserAccountDto(userAccountDtoPostSave);

        } else {

            String message = new StringBuilder(hello).append(savingAccount.getFirstName())
                    .append(comma).append(messageFail).toString();
            createAccountResponseDto.setMessage(message);

        }
    }

    private String buildMessage(SavingAccount savingAccount) {
        return new StringBuilder(hello).append(emptySpace).append(savingAccount.getFirstName()).append(comma)
                .append(emptySpace).append(messageSuccess).append(emptySpace)
                .append(savingAccount.getAccountNumber()).toString();
    }

    @Override
    public Optional<List<CreateAccountResponseDto>> fetchAllUserAccount() {

        List<SavingAccount> userAccountList = savingAccountDao.findAll();

        List<CreateAccountResponseDto> createAccountResponseDtoList = userAccountList.stream().map(userAccount -> {

            UserAccountDto userAccountDto = new UserAccountDto();
            BeanUtils.copyProperties(userAccount, userAccountDto);
            CreateAccountResponseDto createAccountResponseDto = new CreateAccountResponseDto();
            createAccountResponseDto.setUserAccountDto(userAccountDto);
            return createAccountResponseDto;
        }).collect(Collectors.toList());

        return Optional.of(createAccountResponseDtoList);

    }
}
