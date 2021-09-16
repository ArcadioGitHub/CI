# Author: Arcadio Buelvas

@Envs
Feature: WebFramework

  @SignUp
  Scenario:The user wants to register in the app.
    Given the user goes to the page and gets registered
    Then the user should see a successful signup message

  @SignIn
  Scenario:The user wants to log in the app.
    Given the user goes to the page and types his credentials
    Then the user should see a successful signup message






