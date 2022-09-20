Feature: Registration Account

  @RA001 @RegistrationAccount @regression
  Scenario: Businessman can create account
    Given Businessman access website
    When Businessman open Regisration Page
    And Businessman fill Form Registration
    Then Businessman have acount

  @RA002 @RegistrationAccount @regression
  Scenario: Businessman can't create account with blank data
    Given Businessman access website
    When Businessman open Regisration Page
    And Businessman click button "Register" without fill form registration
    Then Businessman can't create new account