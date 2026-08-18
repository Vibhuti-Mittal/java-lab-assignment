package food.utility;

import food.model.FoodOrder;
import food.model.Discountable;

public class OrderUtility {

    public static boolean validateAmount(double amount) {
        return amount > 0;
    }

    public static boolean validateCustomerName(String name) {
        return name != null && !name.trim().isEmpty();
    }

    public static void generateOrderSummary(FoodOrder order) {

        if (order == null) {
            System.out.println("Invalid order!");
            return;
        }

        double amount = order.getAmount();
        double discount = ((Discountable) order).applyDiscount();
        double deliveryCharge = order.calculateDeliveryCharge();
        double finalAmount = amount - discount + deliveryCharge;

        System.out.println("----------------------------------------");
        System.out.println("Restaurant      : " + FoodOrder.getRestaurantName());
        System.out.println("Order ID        : " + order.getOrderId());
        System.out.println("Customer Name   : " + order.getCustomerName());
        System.out.println("Food Bill       : Rs. " + amount);
        System.out.println("Discount        : Rs. " + discount);
        System.out.println("Delivery Charge : Rs. " + deliveryCharge);
        System.out.println("Final Payable   : Rs. " + finalAmount);
        System.out.println("----------------------------------------");
    }
}