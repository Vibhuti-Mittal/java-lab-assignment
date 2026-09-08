import java.util.ArrayList;
import java.util.Scanner;

class ApplicationException extends Exception {
    public ApplicationException(String message) {
        super(message);
    }
}

class ProductException extends ApplicationException {
    public ProductException(String message) {
        super(message);
    }
}

class ProductNotFoundException extends ProductException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}

class OutOfStockException extends ProductException {
    public OutOfStockException(String message) {
        super(message);
    }
}

class PaymentException extends ApplicationException {
    public PaymentException(String message) {
        super(message);
    }
}

class InvalidPaymentException extends PaymentException {
    public InvalidPaymentException(String message) {
        super(message);
    }
}

class InsufficientFundsException extends PaymentException {
    public InsufficientFundsException(String message) {
        super(message);
    }
}

class OrderException extends ApplicationException {
    public OrderException(String message) {
        super(message);
    }
}

class EmptyCartException extends OrderException {
    public EmptyCartException(String message) {
        super(message);
    }
}

class Product {
    int id;
    String name;
    double price;
    int stock;

    Product(int id, String name, double price, int stock) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.stock = stock;
    }

    public String toString() {
        return id + " - " + name + " - Rs." + price + " - Stock: " + stock;
    }
}

class ShoppingCart {

    ArrayList<Product> products = new ArrayList<>();

    Product searchProduct(Product[] inventory, int id)
            throws ProductNotFoundException {

        for (Product p : inventory) {
            if (p.id == id) {
                return p;
            }
        }

        throw new ProductNotFoundException(
            "Product with ID " + id + " not found."
        );
    }

    void addProduct(Product[] inventory, int id, int quantity)
            throws ProductException {

        if (quantity <= 0) {
            throw new ProductException("Quantity must be greater than zero.");
        }

        Product p = searchProduct(inventory, id);

        if (p.stock < quantity) {
            throw new OutOfStockException(
                "Only " + p.stock + " units of " + p.name + " are available."
            );
        }

        for (Product item : products) {
            if (item.id == id) {
                p.stock -= quantity;
                System.out.println("Product added to cart.");
                return;
            }
        }

        for (int i = 0; i < quantity; i++) {
            products.add(p);
        }

        p.stock -= quantity;

        System.out.println("Product added to cart.");
    }

    void removeProduct(int id) throws ProductNotFoundException {

        for (Product p : products) {
            if (p.id == id) {
                products.remove(p);
                p.stock++;
                System.out.println("Product removed from cart.");
                return;
            }
        }

        throw new ProductNotFoundException(
            "Product is not present in the cart."
        );
    }

    void viewCart() throws EmptyCartException {

        if (products.isEmpty()) {
            throw new EmptyCartException("Cart is empty.");
        }

        double total = 0;

        System.out.println("\n----- CART -----");

        for (Product p : products) {
            System.out.println(p.name + " - Rs." + p.price);
            total += p.price;
        }

        System.out.println("Total: Rs." + total);
    }

    double getTotal() throws EmptyCartException {

        if (products.isEmpty()) {
            throw new EmptyCartException("Cannot make payment. Cart is empty.");
        }

        double total = 0;

        for (Product p : products) {
            total += p.price;
        }

        return total;
    }

    void makePayment(double amount)
            throws PaymentException, EmptyCartException {

        double total = getTotal();

        if (amount <= 0) {
            throw new InvalidPaymentException(
                "Payment amount must be greater than zero."
            );
        }

        if (amount < total) {
            throw new InsufficientFundsException(
                "Insufficient funds. Required: Rs." + total
            );
        }

        double change = amount - total;

        products.clear();

        System.out.println("Payment successful!");
        System.out.println("Change: Rs." + change);
    }
}

public class q7 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Product[] inventory = {
            new Product(101, "Laptop", 50000, 5),
            new Product(102, "Mouse", 800, 10),
            new Product(103, "Keyboard", 1500, 3),
            new Product(104, "Headphones", 2000, 0)
        };

        ShoppingCart cart = new ShoppingCart();

        int choice = 0;

        while (choice != 6) {

            System.out.println("\n===== SHOPPING CART =====");
            System.out.println("1. Search Product");
            System.out.println("2. Add Product");
            System.out.println("3. Remove Product");
            System.out.println("4. View Cart");
            System.out.println("5. Make Payment");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();

            try {

                switch (choice) {

                    case 1:
                        System.out.print("Enter product ID: ");
                        int searchId = sc.nextInt();

                        Product p = cart.searchProduct(inventory, searchId);
                        System.out.println("Product found: " + p);
                        break;

                    case 2:
                        System.out.print("Enter product ID: ");
                        int addId = sc.nextInt();

                        System.out.print("Enter quantity: ");
                        int quantity = sc.nextInt();

                        cart.addProduct(inventory, addId, quantity);
                        break;

                    case 3:
                        System.out.print("Enter product ID: ");
                        int removeId = sc.nextInt();

                        cart.removeProduct(removeId);
                        break;

                    case 4:
                        cart.viewCart();
                        break;

                    case 5:
                        double total = cart.getTotal();

                        System.out.println("Total amount: Rs." + total);
                        System.out.print("Enter payment amount: ");
                        double payment = sc.nextDouble();

                        cart.makePayment(payment);
                        break;

                    case 6:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice.");
                }

            } catch (ProductNotFoundException e) {
                System.out.println("Product Error: " + e.getMessage());

            } catch (OutOfStockException e) {
                System.out.println("Stock Error: " + e.getMessage());

            } catch (InvalidPaymentException e) {
                System.out.println("Payment Error: " + e.getMessage());

            } catch (InsufficientFundsException e) {
                System.out.println("Payment Error: " + e.getMessage());

            } catch (EmptyCartException e) {
                System.out.println("Order Error: " + e.getMessage());

            } catch (ProductException e) {
                System.out.println("Product Error: " + e.getMessage());

            } catch (PaymentException e) {
                System.out.println("Payment Error: " + e.getMessage());

            } 
        }

        sc.close();
    }
}