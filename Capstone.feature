Feature: Verify iframe functionality

  Scenario: Verify iframe and image functionality
    Given User navigates to the website "http://webdriveruniversity.com/index.html"
    Then The page title is "http://webdriveruniversity.com/index.html"
    When User clicks on the "IFrame" link
    Then User switches to the new tab
    And User verifies that an image is present
    And User clicks on the right arrow button
    Then User verifies that the image has changed
