package com.digital.bank.account.validator;

import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class UserAccountValidator {

    @Value(value = "${user_bank.message.lessAmount}")
    String messageFail;

    @Value(value = "${user_bank.message.hello}")
    String hello;

    @Value(value = "${user_bank.message.str}")
    String comma;

    @Value(value = "${user_bank.message.emptySpace}")
    String emptySpace;

    @Value(value = "${user_bank.minumumBalance}")
    long minBalance;



    public CreateAccountResponseDto validateUserAccount (UserAccountDto userAccountDto, CreateAccountResponseDto createAccountResponseDto){

        if(userAccountDto.getAmount() < minBalance){

            createAccountResponseDto.setMessage(new StringBuilder(hello).append(emptySpace)
                    .append(userAccountDto.getFirstName()).append(comma).append(emptySpace).append(messageFail).toString());
        }

        return createAccountResponseDto;

    }

}
