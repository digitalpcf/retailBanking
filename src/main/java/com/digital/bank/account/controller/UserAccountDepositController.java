package com.digital.bank.account.controller;


import com.digital.bank.account.dto.UserAccountDepositDto;
import com.digital.bank.account.dto.UserAccountDepositResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/retailbanking")
public class UserAccountDepositController {

    @PostMapping(path = "/deposit")
    public ResponseEntity<UserAccountDepositResponseDto> createUserAccount(@RequestBody UserAccountDepositDto userAccountDepositDto) {

        UserAccountDepositResponseDto userAccountDepositResponseDto = new UserAccountDepositResponseDto();
        return ResponseEntity.status(HttpStatus.OK).body(userAccountDepositResponseDto);

    }

}
