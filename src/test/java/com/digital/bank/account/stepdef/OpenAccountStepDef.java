package com.digital.bank.account.stepdef;


import com.digital.bank.account.dto.CreateAccountResponseDto;
import com.digital.bank.account.dto.UserAccountDto;
import com.digital.bank.account.pojo.UserAccountTestDto;
import com.digital.bank.account.service.UserAccountService;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class OpenAccountStepDef {

    @Autowired
    UserAccountService userAccountService;
    private List<CreateAccountResponseDto> actualCreatedUserAccountList = new ArrayList<>();
    private int count = 0;



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

            assertThat(createAccountResponseDto.getMessage(), is(testAccountCreateResponseList.get(count).getMessage()));
            count++;

        });
    }


    @Then("^Account will be created as|$")
    public void john_s_account_will_be_created_as(List<UserAccountTestDto> testAccountList) throws Throwable {

        actualCreatedUserAccountList.forEach(createAccountResponseDto -> {

            UserAccountDto userAccountDtoActual = createAccountResponseDto.getUserAccountDto();
            UserAccountTestDto userAccountDtoExpected = testAccountList.get(count);

            assertThat(userAccountDtoActual.getAccountNumber(), is(userAccountDtoExpected.getAccountNumber()));
            assertThat(userAccountDtoActual.getAddress(), is(userAccountDtoExpected.getAddress()));
            assertThat(userAccountDtoActual.getCurrency(), is(userAccountDtoExpected.getCurrency()));
            assertThat(userAccountDtoActual.getFirstName(), is(userAccountDtoExpected.getFirstName()));
            assertThat(userAccountDtoActual.getLastName(), is(userAccountDtoExpected.getLastName()));
            assertThat(userAccountDtoActual.getMiddleName(), is(userAccountDtoExpected.getMiddleName()));
            assertThat(userAccountDtoActual.getKycDocument(), is(userAccountDtoExpected.getKycDocument()));
            assertThat(userAccountDtoActual.getKycIdentificationNo(), is(userAccountDtoExpected.getKycIdentificationNo()));
            assertThat(userAccountDtoActual.getAmount() , is(userAccountDtoExpected.getAmount()));

            userAccountDtoActual = null;
            userAccountDtoExpected = null;

            count++;

        });


    }


    @Then("^John should get message as|$")
    public void john_should_get_message_as(List<CreateAccountResponseDto> testAccountCreateResponseList) throws Throwable {

        actualCreatedUserAccountList.forEach(createAccountResponseDto -> {
            assertThat(createAccountResponseDto.getMessage(), is(testAccountCreateResponseList.get(count).getMessage()));
            count++;

        });


    }
}
