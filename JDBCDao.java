// JDBC (Java Database Connectivity) DAO (Data Access Object) 
// is a design pattern used to separate the data access logic 
// from the rest of the application. The DAO pattern typically 
// involves creating classes or interfaces that encapsulate the 
// logic for accessing and manipulating data in a database. 
// This separation helps improve modularity, maintainability, 
// and testability of the application.

import java.sql.*;

class Student {

    String sname;
    int sid;
}

class StudentDao {

    Connection con = null;

    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/squad", "root", "Faizan@786");
        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public Student getStudent(int sid) {

        try {

            String query = "Select sname from student where sid=" + sid;
            Student s1 = new Student();
            s1.sid = sid;

            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);
            rs.next();
            String name = rs.getString(1);
            s1.sname = name;
            return s1;

        } catch (Exception e) {
            System.out.println(e);
        }
        return null;

    }

    public void addStudent(Student s) {
        String query = "insert into student values(?,?,1000)";

        try {
            PreparedStatement pst = con.prepareStatement(query);
            pst.setInt(1, s.sid);
            pst.setString(2, s.sname);
            int count = pst.executeUpdate();

            System.out.println(count + "row/s affected");

            pst.close();
            con.close();
        } catch (Exception e) {
            System.out.println(e);
        }

    }
}

public class JDBCDao {
    public static void main(String[] args) {

        StudentDao dao = new StudentDao();
        dao.connect();
        Student s2 = new Student();
        s2.sid = 8;
        s2.sname = "Deepak";
        dao.addStudent(s2);

    }
}
