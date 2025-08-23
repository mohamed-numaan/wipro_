package shop;
import com.shop.products.Product;
import com.shop.orders.Order;
import com.shop.users.User;

public class MainApp {
	public static void main(String[] args) {
		User user = new User("U101", "Alice");
		Product product = new Product("P201", "Laptop", 75000.00);

		Order order = new Order("O301", user, product);

		System.out.println("E-Commerce Order Details:");
		order.displayOrder();
	}
}
