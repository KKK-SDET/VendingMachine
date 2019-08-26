

This is a Vending Machine Software Development Project.

As I can see that VendingMachine class has no specific/separate method to test if the Inventory of the vending machine is loaded with Items, as supposed to, when I initialize VendingMachine class.
I would create a ticket at least, since this could be useful for testing purposes.
__________________________________________________

In pom.xml file I've used following dependencies and plugins.
Dependencies in pom.xml:	
	1. io.cucumber dependecies. Version 4.2.0 - to use BDD approach in testing.
	2. JUnit dependency. Version 4.11 - came with Maven as a build tool. used for unit testing 

Plugins in pom.xml:
		a. maven-surefire plugin to generate testing report in .txt format. White box test report link: target/surefire-reports/VendingMachineTest.txt
		b. maven-cucumber-reporting plugin to generate a cucumber-JVM reports. Black box test report will have separate reports on failures, features, steps, tags. Black box testnreport link: target/cucumber-JVM-reports/cucumber-html-reports
__________________________________________________

How to run tests:

For White box testing approach - please run VendingMachineTest class, where all VendingMachine methods were tested. I also created domain and services packages in main.java directory:
	a. domain package has Bucket, Coin, CoinEnum, Item, ItemEnum classes inside.
	b. services package has Inventory and VendingMachine classes inside.

For Black box testing approach - I've created several packages, files and classes:
	a. features package in test directory with vendingMachineTest.feature file with scenarios (test cases).
	b. stepDefs package and StepDefsVM class with scenarios written on Java language.
	b. runners package with VMRunner class where I used plugins to generate Cucumber reports in XML, HTML, JSON languages.

To run both White and Black box tests please use command mvn clean install.
__________________________________________________






