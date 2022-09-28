@regression
Feature: user should be able to login to the system

  Scenario: user  login with valid username and password

  Given user open browser
  And   user can navigate to login page
  When user enter valid username and password
  And user click on login button
  Then user login successfully
  And  user go to home page

  Scenario : user login with invalid username and password




