package kata.supermarket;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ByOneGetOneFree implements DiscountScheme {

	private final List<ItemByUnit> listOfItems;

	private final Map<ItemByUnit, Integer> unitItemInventory;

	ByOneGetOneFree(List<ItemByUnit> listOfItems) {
		this.listOfItems = listOfItems;
		this.unitItemInventory = new HashMap<>();
	}

	/**
	 * Take inventory on the number of each unique item in the list.
	 */
	public void takeInventory() {

		for (ItemByUnit item : this.listOfItems) {
			if (!this.unitItemInventory.containsKey(item)) {
				this.unitItemInventory.put(item, 1);
			} else {
				int currentStock = this.unitItemInventory.get(item);
				this.unitItemInventory.replace(item, currentStock + 1);
			}
		}
	}

	/**
	 * Create unmodifiable inventory.
	 * 
	 * @return Final inventory.
	 */
	Map<ItemByUnit, Integer> inventory() {
		takeInventory();
		return Collections.unmodifiableMap(this.unitItemInventory);
	}

	/**
	 * Calculate the total discount applied on the inventory.
	 *
	 */
	private class DiscountCalculator {
		private final Map<ItemByUnit, Integer> inventory;

		DiscountCalculator() {
			this.inventory = inventory();
		}

		private BigDecimal discount() {
			BigDecimal totalDiscountPrice = BigDecimal.ZERO;
			for (ItemByUnit item : this.inventory.keySet()) {
				int stock = this.inventory.get(item);
				if (stock > 1) {
					int noOfRefundedItems = (int) Math.floor(stock / 2);
					BigDecimal refundPrice = item.price().multiply(new BigDecimal(noOfRefundedItems));
					totalDiscountPrice = totalDiscountPrice.add(refundPrice);
				}
			}
			return totalDiscountPrice;
		}
	}

	@Override
	public BigDecimal discountPrice() {
		DiscountCalculator discountCalculator = new DiscountCalculator();
		return discountCalculator.discount();
	}
}
