package food.service;

import food.model.FoodOrder;
import food.utility.OrderUtility;

public class OrderService {

    public void displayOrders(FoodOrder[] orders) {

        for (FoodOrder order : orders) {

            if (order != null) {

                if (!OrderUtility.validateCustomerName(order.getCustomerName())) {
                    System.out.println("Invalid customer name for Order ID: "
                            + order.getOrderId());
                    continue;
                }

                if (!OrderUtility.validateAmount(order.getAmount())) {
                    System.out.println("Invalid amount for Order ID: "
                            + order.getOrderId());
                    continue;
                }

                OrderUtility.generateOrderSummary(order);
            }
        }
    }
}