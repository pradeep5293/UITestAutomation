Feature: Payement functionality 

#@Smoke @Reg
Scenario: Payment  with card 
	And user navigates to the payment page 
	When user enters valid payment details 
	And user clicks the "Pay Now" button 
	Then user should see a payment confirmation message 
	And payment should be processed successfully