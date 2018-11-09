Feature:  Create bank account

  Background: John wants to open an account in the bank

  Scenario: Create account when all required information are provided

    Given Jonn has provided the information as

      | First name | Middle Name | Last Name | Address | kyc Document | kyc Identification No |
      | John       |             | Joseph    | EC City | PAN          | AHPS34FU              |

    Then John account should be created and he should get a message as
      | message                                                         |
      | Hello John, your account has been created successfully.Account number JohnAHPS34FU|