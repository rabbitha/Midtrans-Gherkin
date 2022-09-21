Feature: Registration Account

  @RA002 @RegistrationAccount @regression
  Scenario: Businessman can't create account with blank data
    Given Businessman access website
    When Businessman open Regisration Pages
    And Businessman click button Register without fill form registration
    Then Businessman can't create new account

  @RA001 @RegistrationAccount @regression
  Scenario: Businessman can create account
    Given Businessman access website
    When Businessman open Regisration Page
    And Businessman fill Form Registration
    Then Businessman success create account