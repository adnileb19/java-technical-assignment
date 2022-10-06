package kata.supermarket;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ByOneGetOneFree implements DiscountScheme {

	List<ItemByUnit> listOfItems;

	Map<ItemByUnit, Integer> unitItemInventory;

	ByOneGetOneFree(List<ItemByUnit> listOfItems) {
		this.listOfItems = listOfItems;
		this.unitItemInventory = new HashMap<>();
	}

	/**
	 * Take inventory on the number of each unique item in the list.
	 */
	public void takeInventory() {

		for (ItemByUnit item : listOfItems) {
			if (!this.unitItemInventory.containsKey(item)) {
				this.unitItemInventory.put(item, 1);
			} else {
				int currentStock = this.unitItemInventory.get(item);
				this.unitItemInventory.replace(item, currentStock + 1);
			}
		}
	}

	@Override
	public BigDecimal discountPrice() {
		// TODO Auto-generated method stub
		return null;
	}
}
