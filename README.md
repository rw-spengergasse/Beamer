# JUNIT

## *Keep the bar green to keep the code clean*

## What is a Unit Test

A unit test tests the smallest possible building blocks of a software, i.e.
usually individual methods and classes. Each method is tested separately.

All external interfaces, i.e. to other methods, to the database, etc., are tested using test doubles (dummies, fakes, stubs, mocks).


## F.I.R.S.T Principle
- **Fast**  
  Execute within seconds
  
- **Isolated**  
  Given, When, Then

- **Repeatable**  
  Deterministic with Test-Fixtures

- **Self-Validating**  
  No manual testing

- **Thorough**  
  Should cover all happy paths
  Should cover illegal arguments
  Should cover edge cases

## GWT / AAA
- **Given (Arrange)**  
  The given part describes the state of the world before you start the behaviour you are specifying in this scenario.
  
- **When (Act)**  
 The when section is the behaviour you specify.

- **Then (Assert)**  
The then section describes the changes you expect to occur as a result of the specified behaviour.

[Deep Dive: GivenWhenThen](https://martinfowler.com/bliki/GivenWhenThen.html)

## Test Fixtures
A known state against which a test is running  
A file containing sample data

##  Parameterized Tests
In a parameterised test, the same test is run several times with different arguments.  
[Deep Dive: Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## Equivalence classes tests (Äquivalenzklassen Tests)
High error coverage rate with low number of test cases.  
[Deep Dive: Durchführung von Äquivalenzklassentest und Grenzwertanalyse](https://blog.milsystems.de/2012/03/durchfuehrung-von-aequivalenzklassentest-und-grenzwertanalyse-nach-istqb-teil-1/)
