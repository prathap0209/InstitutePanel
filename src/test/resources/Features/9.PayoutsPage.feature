Feature: Institute Payouts

@payout @positive
Scenario: Payouts page shows the payout details
Given I am logged in as an institute
When I navigate to the Payouts page
Then I verify the text "<text>" is displayed




