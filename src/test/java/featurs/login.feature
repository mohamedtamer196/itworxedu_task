Feature: Create Course Scenarios

  Scenario: Create a new course
    Given I am logged in as "testregister@aaa.com" with password "Wakram_123"
    When I create a new course with title "<course_title>", description "<course_description>", and price "<course_price>"
    Then I should see the course title "<course_title>" displayed in the courses list

