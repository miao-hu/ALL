import java.sql.*;

public class Main1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.通过DriverManager  获取数据库连接
        Connection connection=  DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useSSL=false",
                "root",
                "123456");

        Statement statement=connection.createStatement();
        int rows= statement.executeUpdate("INSERT INTO classes (name) VALUE ('Java 11')");
        System.out.println(rows);   //1
        statement.close();

        statement=connection.createStatement();
        rows=statement.executeUpdate("UPDATE classes SET name='C++' WHERE name='Java 11'");
        System.out.println(rows);   //1
        statement.close();

        //3.最后关闭连接
        connection.close();
    }
}
