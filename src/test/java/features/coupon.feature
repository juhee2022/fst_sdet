Feature: Coupons creation and updation
  I want to create, update and delete coupons

  Background: Verify the login to Admin dashboard and navigation to Coupons page
    Given User navigates to login page
    And Enter Username "admin" and Password "Admin@123"
    Then Admin dashboard is displayed
    When Click on Coupons in Marketing menu
    Then Coupon list is displayed

  Scenario: Add Coupon
    Given User clicks on Add New icon in Coupon list
    And Enter Coupon details and click on Save icon
    Then Verify newly created Coupon in Coupon list
