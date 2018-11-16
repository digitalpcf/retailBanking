package com.digital.bank.account.controller;


import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;
import com.digital.bank.account.service.UserAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/retailbanking")
public class UserAccountController {

    @Autowired
    UserAccountService userAccountService;


    @PostMapping(path = "/createUserAccount")
    public ResponseEntity<CreateAccountResponseDto> createUserAccount(@RequestBody UserAccountDto userAccountDto){

        CreateAccountResponseDto createAccountResponseDto = userAccountService.createUserAccount(userAccountDto);
        if(null != createAccountResponseDto.getUserAccountDto()){
            return ResponseEntity.status(HttpStatus.OK).body(createAccountResponseDto);
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(createAccountResponseDto);
        }

    }


    @GetMapping("/findAllAccount")
    public ResponseEntity<List<CreateAccountResponseDto>> getAllUserAccount(){

        Optional<List<CreateAccountResponseDto>> createAccountResponseDtoList = userAccountService.fetchAllUserAccount();
        if(createAccountResponseDtoList.isPresent()){
            return ResponseEntity.status(HttpStatus.OK).body(createAccountResponseDtoList.get());
        }else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }

    }
}
