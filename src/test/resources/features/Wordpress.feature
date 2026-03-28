Feature: WordPress Photo Directory Search

Scenario: Verify WordPress navigation and photo search
Given user launches the browser
When user navigates to WordPress homepage
Then page title should be "Blog Tool, Publishing Platform, and CMS – WordPress.org"

When user hovers on "Download and Extend"
Then user should see "Get WordPress" text

When user clicks on Community menu
And user clicks on Photo Directory
And user searches photos with keyword "nature"

Then photos should be displayed