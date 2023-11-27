
Feature: As a data consumer, I want to know genre of books are being borrowed the most
  @db @dasha
  Scenario: verify the common book genre that’s being borrowed the most
    Given Establish the database connection
    When I execute query to find most popular book genre
    Then verify "Fantasy" is the most popular book genre.

  @db @yanji
  Scenario: verify the the common book genre that’s being borrowed. YO
    Given Establish the database connection
    When I execute query to find most popular book genre. YO
    Then verify "Fantasy" is the most popular book genre. YO
