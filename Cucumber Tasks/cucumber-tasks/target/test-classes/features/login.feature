Feature: Login Test
Scenario Outline: Multiple login checks
  Given User
  When User enters username "<username>" and password "<password>"
  Then Login should be "<status>"

Examples:
  | username | password    | status  |
  | student  | Password123 | success |
  | admin    | admin123    | failure |
  | wrong    | test123     | failure |
