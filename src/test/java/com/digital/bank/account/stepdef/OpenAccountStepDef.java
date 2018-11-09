package com.digital.bank.account.stepdef;


import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;
import com.digital.bank.account.pojo.UserAccountTestDto;
import com.digital.bank.account.service.UserAccountService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class OpenAccountStepDef {

    @Autowired
    UserAccountService userAccountService;

    List<CreateAccountResponseDto> createdUserAccountList = new ArrayList<>();

    @Given("^Jonn has provided the information as$")
    public void jonn_has_provided_the_information_as(List<UserAccountTestDto> userAccountList) throws Throwable {


        userAccountList.forEach(userAccountTest ->{

            UserAccountDto userAccountDto = new UserAccountDto();
            BeanUtils.copyProperties(userAccountTest,userAccountDto);
            createdUserAccountList.add(userAccountService.createUserAccount(userAccountDto));
        });

    }

    @Then("^John account should be created and he should get a message as$")
    public void john_account_should_be_created_and_he_should_get_a_message_as(List<CreateAccountResponseDto> accountCreateResponseList) throws Throwable {

        createdUserAccountList.forEach(createAccountResponseDto ->{

            int count = 0;
            assertThat(StringUtils.endsWithIgnoreCase(createAccountResponseDto.getMessage(),accountCreateResponseList.get(count).getMessage()));
            count++;

        });
    }

}
