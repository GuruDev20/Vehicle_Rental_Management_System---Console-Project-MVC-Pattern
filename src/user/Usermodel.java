package user;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
public class Usermodel {
    private Connection conn=null;
    private Statement st=null;
    public Usermodel()throws Exception{
        if(conn==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehciclerentalmanagementsystem", "root", "GuruDev20**");
        }
    }
    public void displayVehicles()throws Exception{
        st=conn.createStatement();
        String query="SELECT * FROM vehcile WHERE available ='YES'";
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4 )+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7));
        }
    }
}
