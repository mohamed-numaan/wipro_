Feature: Product Search 
Scenario: Search multiple products 
Given User is on Search Page
When User searches for
| Laptop   | 
| Mobile   |
| Headset  |
Then Products should be displayed