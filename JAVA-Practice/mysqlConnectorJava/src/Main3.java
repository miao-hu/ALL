import java.sql.*;

public class Main3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册Driver
        Class.forName("com.mysql.jdbc.Driver");
        //2.通过DriverManager  获取数据库连接
        Connection connection=  DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useSSL=false",
                "root",
                "123456");

        Statement statement=connection.createStatement();
        statement.executeUpdate("INSERT INTO classes (name) VALUE ('向日葵班')");
        statement.close();

        statement=connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT id FROM classes WHERE name='向日葵班'");
        resultSet.next();
        int class_Id=resultSet.getInt(1);
        statement.close();
        resultSet.close();

        statement=connection.createStatement();
        String sql="INSERT INTO students (sn, class_id, name)"
                + " VALUES ('10086', " + class_Id + ", '蜡笔小新'),"
                + " ('10087', " + class_Id + ", '麦兜'),"
                + " ('10088', " + class_Id + ", '孙悟空')";
        System.out.println(sql);
        statement.executeUpdate(sql);
        statement.close();

        //3.最后关闭连接
        connection.close();
    }
}
