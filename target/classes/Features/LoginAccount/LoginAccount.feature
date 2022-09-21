Feature: Login Account

  @LA002 @LoginAccount @regression
  Scenario: Businessman can't login account with wrong password
    Given Businessman access website
    When Businessman open Login Account Page
    And Businessman fill password with invalid data
    Then Businessman can't login

  @LA001 @LoginAccount @regression
  Scenario: Businessman can login account
    Given Businessman access website
    When Businessman open Login Account Pages
    And Businessman fill Form Login Account
    Then Businessman on Dashboard Account

