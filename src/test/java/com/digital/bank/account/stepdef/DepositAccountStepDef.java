package com.digital.bank.account.stepdef;


import com.digital.bank.account.dto.UserAccountDepositDto;
import com.digital.bank.account.dto.UserAccountDto;
import com.digital.bank.account.pojo.UserAccountDepositTestDto;
import com.digital.bank.account.service.UserAccountService;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;

@ContextConfiguration
@SpringBootTest
@ActiveProfiles("test")
public class DepositAccountStepDef {

    @Autowired
    UserAccountService userAccountService;

    @Before
    public void loadUserAccount() {

        UserAccountDto userAccountDto = new UserAccountDto();
        userAccountDto.setAccountNumber("Mark234DFC");
        userAccountDto.setFirstName("Mark");
        userAccountDto.setLastName("Peter");
        userAccountDto.setAddress("EC4");
        userAccountDto.setKycDocument("PAN");
        userAccountDto.setKycIdentificationNo("234DFC");
        userAccountDto.setAmount(4000);
        userAccountDto.setCurrency("INR");

        userAccountService.createUserAccount(userAccountDto);

    }

    @Given("^Mark has provided the information as$")
    public void mark_has_provided_the_information_as(List<UserAccountDepositTestDto> userAccountDepositTestDto)
            throws Throwable {

        UserAccountDepositDto userAccountDepositDto = new UserAccountDepositDto();
        BeanUtils.copyProperties(userAccountDepositTestDto,userAccountDepositDto);
        userAccountService.depositAmount(userAccountDepositDto);

    }

    @Then("^He should get a message as$")
    public void he_should_get_a_message_as(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

    @Then("^Account should be deposited as$")
    public void account_should_be_deposited_as(DataTable arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        throw new PendingException();
    }

}
