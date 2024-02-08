import java.sql.*;

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