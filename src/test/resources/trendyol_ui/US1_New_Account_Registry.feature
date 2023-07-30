Feature: US1_Registry
  Background:
    Given User goes to the <"https://www.trendyol.com/">
    And User clicks to <"Giriş Yap">
    And User clicks to <"Üye Ol">
  Scenario: HappyPath
    And User enters fakeMail<"mail">
    Then User enters fakeMail<"password">
    Then User clicks to <"campaignAcknowlegmentConfimationCheck">
    Then User clicks to <"personalDataSavedCheck">
    Then User clicks to <"captchaHome">
    Then User clicks to <"Üye Ol Submit">

