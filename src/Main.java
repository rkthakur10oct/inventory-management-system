import dao.ProductDAO;
import model.Product;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ProductDAO dao = new ProductDAO();

        int choice;

        do {

            System.out.println("\n===== Inventory Management System =====");
            System.out.println("1. Add Product");
            System.out.println("2. View Products");
            System.out.println("3. Update Product");
            System.out.println("4. Delete Product");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:

                    sc.nextLine();

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter quantity: ");
                    int qty = sc.nextInt();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    Product p = new Product(name, qty, price);

                    dao.addProduct(p);

                    break;

                case 2:

                    dao.viewProducts();

                    break;

                case 3:

                    System.out.print("Enter product ID: ");
                    int id = sc.nextInt();

                    System.out.print("Enter new quantity: ");
                    int newQty = sc.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    dao.updateProduct(id, newQty, newPrice);

                    break;

                case 4:

                    System.out.print("Enter product ID to delete: ");
                    int delId = sc.nextInt();

                    dao.deleteProduct(delId);

                    break;

                case 5:

                    System.out.println("Exiting system...");

                    break;

                default:

                    System.out.println("Invalid choice!");

            }

        } while (choice != 5);

        sc.close();
    }
}