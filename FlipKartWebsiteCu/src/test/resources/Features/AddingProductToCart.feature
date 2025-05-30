Feature: Cart Page in Flipkart

@AddingProductToTheCart
Scenario Outline: Search and add product to Cart

Given User launches the Flipkart website in respective "chrome" environment
When User searches for the "<item>" in the Search bar.
Then User select the "<productName>" from the search results.
And User switches the tab for the product detail page.
And User click on Add to Bag 
Then User verifies that "<productName>" displayed in the cart.


Examples:
|item|productName|
|redmi 13 5g|REDMI 13 5G (Black Diamond, 128 GB)|
|Samsung galaxy F05|SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)|



@AddingTwoDifferentProduct
Scenario Outline: Adding Two different products in the Cart
Given User launches the Flipkart website in respective "chrome" environment
When User searches for the "<item>" in the Search bar.
Then User select the "<productName>" from the search results.
And User switches the tab for the product detail page.
And User click on Add to Bag 
Then User verifies that "<productName>" displayed in the cart.
And User returns back and Searched for "<item2>" and added the product "<productName2>" in the cart.


Examples:
|item|item2|productName|productName2|
|iphone 16 pro max|Samsung galaxy F05|Apple iPhone 16 Pro Max (Desert Titanium, 256 GB)|SAMSUNG Galaxy F05 (Twilight Blue, 64 GB)|