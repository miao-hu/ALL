import java.sql.*;
/* import com.mysql.jdbc.Driver;  检查这个包是否导入成功
	Connection       MySQL 的网络连接
	Statement        MySQL 语句
	Statement statement=connection.createStatement();
	     statement.executeQuery(sql);     查询语句sql   SELECT/SHOW
         statement.executeUpdate(sql)     更新语句sql   INSERT/DELETE/UPDATE/DROP/CREATE
*/
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.注册驱动Driver，利用Java语言中的反射
        Class.forName("com.mysql.jdbc.Driver");
		
        //2.通过DriverManager  获取数据库连接
        Connection connection=  DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useSSL=false",
                "root",
                "123456");
        //connection只需要新建一次，statement每次用每次创建，每次关闭
        Statement statement=connection.createStatement();
        ResultSet resusultSet= statement.executeQuery("SHOW TABLES");  //查询调用
		// next 必须首先调用一次
        while(resusultSet.next()){
            //jdbc列是从1开始的
            String tableName=resusultSet.getString(1);
            System.out.println(tableName);   //student
        }
        resusultSet.close();
        statement.close();

        System.out.println(connection);   //com.mysql.jdbc.JDBC4Connection@506c589e
        //3.最后关闭连接
        connection.close();
    }
}
