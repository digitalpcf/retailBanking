Feature:  Deposit money in bank account

  Background: Mark is a customer of  the ABC bank and he has an account with balance 4000

  Scenario: Mark wants to deposit money

    Given Mark has provided the information as

      | Account Number | First name | Middle Name | Last Name | Amount | Currency |
      | Mark234DFC     | Mark       |             | Peter     | 3000   | INR      |

    Then  He should get a message as
      | message                                                                                              |
      | Hello Mark, your account Mark234DFC has been credited with INR 4000. Available balance is : INR 7000 |


    Given Mark has provided the information as

      | Account Number | First name | Middle Name | Last Name | Amount | Currency |
      | Mark234DFC     | Mark       |             | Peter     | 4000   | INR      |

    Then  Account should be deposited as

      | Account Number | First name | Middle Name | Last Name | Amount | Currency | Balance |
      | Mark234DFC     | Mark       |             | Peter     | 4000   | INR      | 7000    |