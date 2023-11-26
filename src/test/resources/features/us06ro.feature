Feature: Books module
  As a librarian, I should be able to add new book into library


  @rash @db @ui
  Scenario Outline: Verify added book is matching with DB
    Given the "librarian" on the home page RO
    And the user navigates to "Books" page RO
    When the librarian click to add book RO
    And the librarian enter book name "<Book Name>" RO
    When the librarian enter ISBN "<ISBN>" RO
    And the librarian enter year "<Year>" RO
    When the librarian enter author "<Author>" RO
    And the librarian choose the book category "<Book Category>" RO
    And the librarian click to save changes RO
    Then verify "The book has been created." message is displayed RO
    And verify "<Book Name>" information must match with DB RO
    Examples:
      | Book Name             | ISBN     | Year | Author          | Book Category        |
      | Head First Java       | 10112021 | 2021 | Kathy Sierra    | Action and Adventure |
      | The Scrum Field Guide | 11112021 | 2006 | Mitch Lacey     | Short Story          |
