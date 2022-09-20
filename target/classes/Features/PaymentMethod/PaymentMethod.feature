Feature: Payment Method

  @LA001 @PaymentMethod @regression
  Scenario: Buyer can payment with debit/credit card method
    Given Buyer access website
    When Buyer checkout a pillow midtrans
    And Buyer choose method payment credit/debit card
    And Buyer fill in credential card with the selected promo
    And Buyer fill OTP Bank
    Then Payment is successfull

  @LA002 @PaymentMethod @regression
  Scenario: Buyer can payment with debit/credit card method with wrong OTP
    Given Buyer access website
    When Buyer checkout a pillow midtrans
    And Buyer choose method payment credit/debit card
    And Buyer fill in credential card with the selected promo
    And Buyer fill OTP Bank with invalid data
    Then Payment Failed