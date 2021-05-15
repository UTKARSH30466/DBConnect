import java.sql.*;

public class DBConnect {
    public static void main(String[] args)  {
        try {
            String host = "jdbc:mysql://localhost:3306/employees";
            String uName = "root";
            String uPass = "root";
            Statement stat;
             Connection con = DriverManager.getConnection(host, uName, uPass) ;
                stat = con.createStatement();

            String sql;
            sql = "select * from workers";
            ResultSet rs = stat.executeQuery(sql);

            while (rs.next()) {
                int id_col = rs.getInt("ID");
                String first_name = rs.getString("First_Name");
                String Last_name = rs.getString("Last_Name");
                String Job_Title = rs.getString("Job_Title");

                String p = id_col + " " + first_name + " " + Last_name + " " + Job_Title;
                System.out.println(p);
            }
        }
        catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
}
