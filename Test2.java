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

public class Test2 {
    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost:3306/squad";
        String uname = "root";
        String pass = "Faizan@786";
        int sid = 5;
        String sname = "Surya";
        int fee = 4000;

        String query = "insert into student values(?,?,?)";
        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection con = DriverManager.getConnection(url, uname, pass);

        // preparedstatement are useful when dynamically add values in the db 
        // only while using this we need to send query first to solve the ? confusion
        // after that just executeUpdate()

        PreparedStatement st = con.prepareStatement(query);

        st.setInt(1, sid);
        st.setString(2, sname);
        st.setInt(3, fee);

        int count = st.executeUpdate();

        System.out.println("bye");
        System.out.println(count + "row/s affected ");

        st.close();
        con.close();

    }
}
