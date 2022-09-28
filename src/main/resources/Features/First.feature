@regression
Feature: user should be able to login to the system
  Background: user open browser and open login page
    Given user open browser
    And   user can navigate to login page


  Scenario: user  login with valid username and password
    //When user enter "tomsmith" and "SuperSecretPassword!"
    When user enter valid username and password
  And user click on login button
  Then user login successfully
  And  user go to home page


  Scenario: user login with invalid username and password
   // When user enter "tom" and "super"
    When user enter invalid username and password
    And user click on login button
    Then user Not login