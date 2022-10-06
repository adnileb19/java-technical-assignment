# Notes

Hello!
I've not used gradle before. So running and building this project at this point isn't going so successfully!

Update: I downloaded gradle and built the project. It failed on the BasketTest with my addition of a second unit of digestives, so I've taken that back out- I'm not sure how to update the expectedAmount field. I've also not used jupiter before and all the annotations can't be resolved. I've spent my hour on this now, so I'll investigate further in my own time, but I would have liked to test that the addition of the discount in the basket affected the total as expected.

As for my ByOneGetOneFreeTest, it passes using JUnit4 on Eclipse.

Improvement wise, a method to calculate all discounts from the discountSchemes would be better than what I have here. At the moment, you'd have to declare each discount scheme (similar to what I have done on line 57) and then calculate a total of all the discounts. That definitely feels like it could be tidier.

Also, I am wondering if another field could be added to the products which says which discount scheme the product is eligible for. I worry that some may be applicable for more than one discount and so the basket could end up discounting the customer more than once. If the product is eligible for more than one discount, a new method would be needed to see which one to apply.

For weight specific discounts, Basket would need a obtainWeighedItemsFromBasket() method, similar to obtainUnitItemsFromBasket().

