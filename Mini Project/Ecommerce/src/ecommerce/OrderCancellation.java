package ecommerce;

public class OrderCancellation {
	
	public void cancel(Order order) {
		if(order==null) {
			System.out.println("Invalid Order");
			return;
		}
		if(order.isCancelled) {
			System.out.println("order is already cancelled");
		}else {
			order.setCancelled(true);
			System.out.println("Order cancelled successfully");
		}
	}
}

