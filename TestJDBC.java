import java.sql.*;

// Steps to followed for JDBC 

// Import package java.sql.*;
// Load & register the driver 
// establish the connection (url,uname,pass)
// create a statement 
// execute the qurey
// process the result 
// close

// We have 4 types of sql query
// DDL 
// DML  - executeUpdate()
// DQL  - executeQuery()
// TQL


public class TestJDBC {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/squad";
        String uname = "root";
        String pass = "Faizan@786";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uname, pass);

        Statement st = con.createStatement();

        ResultSet rs = st.executeQuery("Select * from student");

        while (rs.next()) {
            System.out.println(rs.getInt("sid") + " : " + rs.getString("sname") + " : " + rs.getString("fee"));
        }

        st.close();
        con.close();

    }

}