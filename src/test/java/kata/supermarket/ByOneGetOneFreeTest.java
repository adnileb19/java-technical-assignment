package kata.supermarket;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

/**
 * Ensure 'ByOneGetOneFree' discount scheme works as expected.
 *
 */
public class ByOneGetOneFreeTest {

	/**
	 * Test correct discount is applied to list of unit items.
	 */
	@Test
	public void correctDiscountIsApplied() {
		DiscountScheme byOneGetOneFree = new ByOneGetOneFree(generateListOfUnitItems());
		BigDecimal discount = byOneGetOneFree.discountPrice();
		Assert.assertEquals(expectedDiscount, discount);
	}

	/**
	 * Generate a list of unit items.
	 * 
	 * @return List of unit items.
	 */
	public List<ItemByUnit> generateListOfUnitItems() {
		List<ItemByUnit> listOfItems = new ArrayList<>();
		ItemByUnit packOfCrisps = new ItemByUnit(new Product(new BigDecimal(1.00)));
		ItemByUnit boxOfCereal = new ItemByUnit(new Product(new BigDecimal(2.35)));
		listOfItems.add(packOfCrisps);
		listOfItems.add(boxOfCereal);
		listOfItems.add(packOfCrisps);

		return listOfItems;
	}
}
