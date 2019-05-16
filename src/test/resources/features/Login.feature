Feature: Login
  Login to Yahoo

  Scenario Outline: Login to Yahoo in Chrome
    Given I go to yahoo
    When enter "<username>" in test field

    Examples: 
      | username |
      | adi      |

  Scenario Outline: Login to Yahoo
    Given I go to yahoo
    When enter "<username>" in test field

    Examples: 
      | username |
      | adi      |
