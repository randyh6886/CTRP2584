Feature: Select and search for organization
  Scenario:  Selecting Organization
    Given I click on Organizations menu option
    When I type OH029 into CTEP ID
    Then I select Healthcare Facility from Organization Type
    Then I click on Search
    Then I Assert Case Western Reserve University matches
    Then I click on Logout