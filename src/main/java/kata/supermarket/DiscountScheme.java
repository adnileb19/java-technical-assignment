package kata.supermarket;

import java.math.BigDecimal;

/**
 * Interface representing discount schemes applicable to items at the shop.
 *
 */
public interface DiscountScheme {

	/**
	 * Get the discount price.
	 */
	public BigDecimal discountPrice();
}
