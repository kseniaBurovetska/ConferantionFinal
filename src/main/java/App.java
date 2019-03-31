import model.dao.mapper.UserMapper;

import java.sql.*;

public class App {

    public static void main(String[] args) throws SQLException {
        System.out.println("Assist".hashCode());

        System.out.println("Hello!");
        Connection connection =
                DriverManager.
                        getConnection(  "jdbc:"+
                                        "mysql:"+
                                        "//localhost:3306/"+
                                        "conferentiondb",
                                "root" ,
                                "root");

        /*Statement query = con.createStatement();
        ResultSet rs = query.executeQuery("SELECT * FROM event");
        while( rs.next()) {
            System.out.println(rs.getString("name"));}*/


        String query = "SELECT * FROM user WHERE email = ?";

        try(PreparedStatement ps = connection.prepareCall(query)) {

            System.out.println(connection.isClosed());
            ps.setString(1, "modEmail");
            ResultSet rs = ps.executeQuery();

            UserMapper userMapper = new UserMapper();

            userMapper.extractFromResultSet(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
