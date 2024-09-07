Feature: Example Scenario
  Scenario Outline: go to web site and login test
    Given  go to login page
    And type username as "<username>"
    And type password as "<password>"
    When click button
    Then assert to success message
    Examples:
       |username|password|
       |student|Password123|
       |aykut|aykut123|
       |tayfur|tayfur123|

