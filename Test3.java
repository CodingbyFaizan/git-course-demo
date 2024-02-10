import java.sql.*;

public class Test3 {

    public static void main(String[] args) throws Exception {

        String url = "jdbc:mysql://localhost/squad";
        String user = "root";
        String pass = "Faizan@786";
        String query = "Select * from student";


        //Load and register the driver
        Class.forName("com.mysql.cj.jdbc.Driver");

        //establish the connection
        Connection con = DriverManager.getConnection(url, user, pass);

        //creat the statement
        Statement st = con.createStatement();

        //resultset can hold table like structure data 
        ResultSet rs = st.executeQuery(query);

        // rs.next();

        // System.out.println(rs.getInt(1));
        // System.out.println(rs.getString(2));


        //rs.next() will move pointer to print the data
        // and also check if there is next element or not 

        while(rs.next()){
            System.out.println(rs.getInt(1) + " : " + rs.getString(2) + " : " + rs.getInt(3));
        }


        //close the connection
        st.close();
        con.close();

    }

}
