Feature: Apply for job

  Scenario Outline: User submits a job application
    Given user is on login page
    When user logs in with email "<email>" and password "<password>"
    Then user should be on the search page
    When user searches for "<jobTitle>"
    And user selects a job from results
    #And user clicks apply
    #Then application form should open

    Examples: 
      | email                  | password  | jobTitle      |
      | zaliva2010@hotmail.com | Gdit_1234 | Test Engineer |
