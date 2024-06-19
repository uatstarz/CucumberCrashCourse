Feature: Login Functionality for Opencart website

  As a user I want to be able to login and use website

  Background:
    Given I am on OpenCart login page

    Scenario: Successful login with valid credentials
      Given I have entered a valid username and password
      When I click on the login button
      Then I should be logged in successfully

    Scenario Outline: Unsuccessful login with invalid or empty credentials
      Given I have entered invalid "<username>" and "<password>"
      When I click on the login button
      Then I should see an error message indicating "<error_message>"

      Examples:
      |username          | password     | error_message                        |
      |invalid@gmail.com | invalidtest  | Warning: Wrong username and password |
      |                  | test         | Warning: empty username or password  |

    Scenario: Navigating to forgotten password page
      When I click on "<Forgotten Password>" link
      Then I should be redirected to the password page
