import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.ArrayList;

public class UserDB {
    public static void add(List<User> users){
        var sql = "INSERT INTO users(fullname, password, role)"
                + "VALUES(?,?)";

        try (var conn =  DB.connect();
             var pstmt = conn.prepareStatement(sql)) {
            for (var user : users) {
                pstmt.setString(1, user.getFullname());
                pstmt.setString(2, user.getPassword());
                pstmt.setString(3, user.getRole());

                pstmt.addBatch();
            }
            pstmt.executeBatch();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static int add(User user) {
        var sql = "INSERT INTO users(fullname, password, role) "
                + "VALUES(?,?)";

        try (var conn =  DB.connect();
             var stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

            stmt.setString(1, user.getFullname());
            stmt.setString(2, user.getPassword());
            stmt.setString(3, user.getRole());

            int insertedRow = stmt.executeUpdate();
            if (insertedRow > 0) {
                var rs = stmt.getGeneratedKeys();
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
    public static List<User> findAll() {
        var products = new ArrayList<User>();

        var sql = "SELECT * FROM users";

        try (var conn =  DB.connect();
             var stmt = conn.createStatement()) {

            var rs = stmt.executeQuery(sql);

            while (rs.next()) {
                var product = new User(
                        rs.getString("role"),
                        rs.getString("fullname"),
                        rs.getInt("id"),
                        rs.getString("password"));
                products.add(product);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return products;
    }
//    public static int update(int id, String name, double price) {
//        var sql  = "UPDATE products "
//                + "SET name = ?, price= ? "
//                + "WHERE id = ?";
//
//        int affectedRows = 0;
//
//        try (var conn  = DB.connect();
//             var pstmt = conn.prepareStatement(sql)) {
//
//            pstmt.setString(1, name);
//            pstmt.setDouble(2, price);
//            pstmt.setInt(3, id);
//
//            affectedRows = pstmt.executeUpdate();
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return affectedRows;
//    }
}