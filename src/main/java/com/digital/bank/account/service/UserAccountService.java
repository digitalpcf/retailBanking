package com.digital.bank.account.service;

import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;

import java.util.List;
import java.util.Optional;

public interface UserAccountService {

     CreateAccountResponseDto createUserAccount(UserAccountDto userAccountDto);
     Optional<List<CreateAccountResponseDto>> fetchAllUserAccount();

}
