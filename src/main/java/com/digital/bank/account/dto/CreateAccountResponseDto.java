package com.digital.bank.account.dto;

public class CreateAccountResponseDto {

    private String message;
    private UserAccountDto userAccountDto;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public UserAccountDto getUserAccountDto() {
        return userAccountDto;
    }

    public void setUserAccountDto(UserAccountDto userAccountDto) {
        this.userAccountDto = userAccountDto;
    }
}
