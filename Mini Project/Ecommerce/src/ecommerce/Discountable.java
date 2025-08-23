package ecommerce;

@FunctionalInterface
public interface Discountable {
	double applyDiscount(double price);
}
