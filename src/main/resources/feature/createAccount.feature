Feature:  Create bank account

  Background: John as a front officer, provides information to the application to create new customer account in the ABC bank.

  Scenario: Create account when all required information are provided

    Given Jonn has provided the information as

      | First name | Middle Name | Last Name | Address | kyc Document | kyc Identification No | Amount | Currency |
      | Ashok      |             | Joseph    | EC City | PAN          | AHPS34FU              | 5000   | INR      |

    Then  Account should be created and he should get a message as
      | message                                                                              |
      | Hello Ashok, your account has been created successfully.Account number AshokAHPS34FU |


  Scenario: New account should be created with account opening information

    Given Jonn has provided the information as

      | First name | Middle Name | Last Name | Address | kyc Document | kyc Identification No | Amount | Currency |
      | Ashok      |             | Joseph    | EC City | PAN          | AHPS34FK              | 5000   | INR      |

    Then Account will be created as|
      | First name | Middle Name | Last Name | Address | kyc Document | kyc Identification No | Amount | Currency | Account Number |
      | Ashok      |             | Joseph    | EC City | PAN          | AHPS34FK              | 5000   | INR      | AshokAHPS34FK |


  Scenario: Opening amount must be greater than or equal 5000

    Given Jonn has provided the information as

      | First name | Middle Name | Last Name | Address | kyc Document | kyc Identification No | Amount | Currency |
      | Ashok      |             | Joseph    | EC City | PAN          | AHPS34FL              | 5000   | INR      |
      | Ravi       |             | Joseph    | EC City | PAN          | AHPS34FM              | 6000   | INR      |
      | Smita      |             | Joseph    | EC City | PAN          | AHPS34FO              | 4500   | INR      |

    Then John should get message as |
      | message                                                                              |
      | Hello Ashok, your account has been created successfully.Account number AshokAHPS34FL |
      | Hello Ravi, your account has been created successfully.Account number RaviAHPS34FM |
      | Hello Smita, Account balance is low, minimum deposit is 5000|