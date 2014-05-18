Design and sample implementation of simple point of sale

Assumptions:
* Sample implementation of PoS assumes that all input/output devices are registered/connected first. 
This is achieved by using not-default constructor in PoSImpl class
* Product dao stub contains product codes: 000001-000006
* Printer stub prints all lines to standard output with "Printer: " prefix
* Display stub displays all lines to standard output with "LCD Display: " prefix
* Bar code scanner provides product code from hardcoded list. This list contains following possibilities:
empty code, existing product code, non-existing product code, exit code

Running:
* to see how this solution works, please run tests in PoSFunctionalTest class. 
All info is printed on standard output.
