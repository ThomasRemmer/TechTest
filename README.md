Market Price Handler Test Exercise

Test has been completed using the Observer Design pattern. The subscriber takes each of the market prices, removes any outdated prices and then displays prices in the console.

Testing:

Backend JUnit testing:

JUnit has been used to test the backend logic for the following:

-Tested to ensure data recieved though the onMessage() function is stored as a market price object.

-Tested to ensure that commission is added to each market price.

-Tested to ensure outdated prices are removed.

-Tested to ensure an exception is thrown if the ask price is larger than the bid price.


Summary of possible end-end testing:

Cypress can be used as the tool for end to end testing. 

The following tests can be written to ensure that the whole application is working:

-A test which checks that all market prices are being fetched from the back end and displayed on the front end.

-A test which checks to see if outdated prices are replaced with new ones.

-A test to check that the correct commission price has been applied to each market price.
