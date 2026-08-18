package food.main;

import food.model.FoodOrder;
import food.model.RegularOrder;
import food.model.PremiumOrder;
import food.service.OrderService;

public class Main {

    public static void main(String[] args) {

        FoodOrder order1 =
                new RegularOrder(101, "Vibhuti", 500);

        FoodOrder order2 =
                new PremiumOrder(102, "Rahul", 1000);

        FoodOrder order3 =
                new RegularOrder(103, "Ananya", 750);

        FoodOrder order4 =
                new PremiumOrder(104, "Karan", 1500);

        FoodOrder order5 =
                new RegularOrder(105, "Simran", 1200);

        FoodOrder order6 =
                new PremiumOrder(106, "Riya", 2000);

        FoodOrder[] orders = {
            order1,
            order2,
            order3,
            order4,
            order5,
            order6
        };

        OrderService service = new OrderService();

        service.displayOrders(orders);

        FoodOrder.displayTotalOrders();
    }
}