Feature: Login functionality

@Login @Reg
Scenario: varify login feature with valid details
#Given user launch site url
When user enter username and password
Then validate succesfully


#@Reg
#Scenario: varify login feature with invalid details
#
#Given user launch site url
#When varify login feature with valid details
#And user click on button
#Then validate error message