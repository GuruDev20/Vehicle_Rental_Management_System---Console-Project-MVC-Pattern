package admin;
import java.sql.*;
public class Adminmodel {  
    private Connection conn=null;
    Statement st=null;
    public Adminmodel()throws Exception{
        if(conn==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehciclerentalmanagementsystem", "root", "GuruDev20**");
        }
    }
    public void addVehicle(String vehcile_name,String vehicle_number,String type,String rent_price,String kilometer,String condition,String service)throws Exception{
        st=conn.createStatement();
        String query="INSERT INTO vehicle(vehcile_name,vehcile_number,type,rent_price,kilometer_run,condition,service,available)VALUES('"+vehcile_name+"','"+vehicle_number+"','"+type+"','"+rent_price+"','"+kilometer+"','"+condition+"','"+service+")";
        int inserted=st.executeUpdate(query);
        if(inserted==1){
            System.out.println("Adding Vehicle Details....");
            Thread.sleep(2000);
            System.out.println("Vehicle Details Added");
        }
    }
}
