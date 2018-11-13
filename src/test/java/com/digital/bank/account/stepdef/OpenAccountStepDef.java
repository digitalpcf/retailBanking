package com.digital.bank.account.stepdef;


import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;
import com.digital.bank.account.pojo.UserAccountTestDto;
import com.digital.bank.account.service.UserAccountService;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
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

import static junit.framework.TestCase.assertTrue;

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class OpenAccountStepDef {

    @Autowired
    UserAccountService userAccountService;

    List<CreateAccountResponseDto> actualCreatedUserAccountList = new ArrayList<>();

    @Given("^Jonn has provided the information as$")
    public void jonn_has_provided_the_information_as(List<UserAccountTestDto> userAccountList) throws Throwable {


        userAccountList.forEach(userAccountTest -> {

            UserAccountDto userAccountDto = new UserAccountDto();
            BeanUtils.copyProperties(userAccountTest, userAccountDto);
            actualCreatedUserAccountList.add(userAccountService.createUserAccount(userAccountDto));
        });

    }

    @Then("^Account should be created and he should get a message as$")
    public void john_account_should_be_created_and_he_should_get_a_message_as(List<CreateAccountResponseDto> testAccountCreateResponseList) throws Throwable {

        actualCreatedUserAccountList.forEach(createAccountResponseDto -> {

            int count = 0;
            assertTrue(StringUtils.equals(createAccountResponseDto.getMessage(), testAccountCreateResponseList.get(count).getMessage()));
            count++;

        });
    }


    @Then("^Account will be created as|$")
    public void john_s_account_will_be_created_as(List<UserAccountTestDto> testAccountList) throws Throwable {

        actualCreatedUserAccountList.forEach(createAccountResponseDto -> {

            int count = 0;
            UserAccountDto userAccountDtoActual = createAccountResponseDto.getUserAccountDto();
            UserAccountTestDto userAccountDtoExpected = testAccountList.get(count);

            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getAccountNumber(), userAccountDtoExpected.getAccountNumber()));
            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getAddress(), userAccountDtoExpected.getAddress()));
            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getCurrency(), userAccountDtoExpected.getCurrency()));
            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getFirstName(), userAccountDtoExpected.getFirstName()));
            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getLastName(), userAccountDtoExpected.getLastName()));
            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getMiddleName(), userAccountDtoExpected.getMiddleName()));
            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getKycDocument(), userAccountDtoExpected.getKycDocument()));
            assertTrue(StringUtils.equalsIgnoreCase(userAccountDtoActual.getKycIdentificationNo(), userAccountDtoExpected.getKycIdentificationNo()));
            assertTrue(userAccountDtoActual.getAmount() == userAccountDtoExpected.getAmount());

            userAccountDtoActual = null;
            userAccountDtoExpected = null;

            count++;

        });


    }


    @Then("^John should get message as|$")
    public void john_should_get_message_as(List<CreateAccountResponseDto> testAccountCreateResponseList) throws Throwable {

        actualCreatedUserAccountList.forEach(createAccountResponseDto -> {

            int count = 0;
            assertTrue(StringUtils.equals(createAccountResponseDto.getMessage(), testAccountCreateResponseList.get(count).getMessage()));
            count++;

        });


    }
}
