package dao;

import database.DBConnection;
import model.Product;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;

public class ProductDAO {

    // Add product
    public void addProduct(Product product) {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "INSERT INTO product(name, quantity, price) VALUES (?, ?, ?)";

            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getQuantity());
            stmt.setDouble(3, product.getPrice());

            stmt.executeUpdate();

            System.out.println("Product Added Successfully!");

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    // View products
    public void viewProducts() {

        try {

            Connection conn = DBConnection.getConnection();

            String sql = "SELECT * FROM product";

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);

            System.out.println("ID | Name | Quantity | Price");

            while (rs.next()) {

                System.out.println(
                    rs.getInt("id") + " | " +
                    rs.getString("name") + " | " +
                    rs.getInt("quantity") + " | " +
                    rs.getDouble("price")
                );

            }

        } catch (Exception e) {

            e.printStackTrace();

        }
    }

    // Delete product
public void deleteProduct(int id) {

    try {

        Connection conn = DBConnection.getConnection();

        String sql = "DELETE FROM product WHERE id = ?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, id);

        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Product Deleted Successfully!");
        } else {
            System.out.println("Product Not Found!");
        }

    } catch (Exception e) {

        e.printStackTrace();

    }
}

// Update product
public void updateProduct(int id, int quantity, double price) {

    try {

        Connection conn = DBConnection.getConnection();

        String sql = "UPDATE product SET quantity=?, price=? WHERE id=?";

        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setInt(1, quantity);
        stmt.setDouble(2, price);
        stmt.setInt(3, id);

        int rows = stmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Product Updated Successfully!");
        } else {
            System.out.println("Product Not Found!");
        }

    } catch (Exception e) {

        e.printStackTrace();

    }
}
}