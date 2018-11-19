package com.digital.bank.account.dto;

public class UserAccountDepositResponseDto {

    String message;
    UserAccountDepositDto userAccountDepositDto;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccountDepositDto getUserAccountDepositDto() {
        return userAccountDepositDto;
    }

    public void setUserAccountDepositDto(UserAccountDepositDto userAccountDepositDto) {
        this.userAccountDepositDto = userAccountDepositDto;
    }
}
