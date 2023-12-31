package admin;
import java.sql.*;
abstract class Vehicles{
    abstract void addVehicle(String vehcile_name,String vehicle_number,String type,String rent_price,String kilometer,String condition,String service)throws Exception;
    abstract void displayVehicles()throws Exception;
    abstract void deleteVehicle(String vehicle_number)throws Exception;
    abstract void display(String key)throws Exception;
    abstract void search(String val,String key)throws Exception;
    abstract void updateVehicleDetails(String vehicle_number,String val,String key)throws Exception;
    abstract void updateUserDetails(String email,String val,String key)throws Exception;
}
public class Adminmodel extends Vehicles{  
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
    public void displayVehicles() throws Exception{
        st=conn.createStatement();
        String query="SELECT * FROM vehicle";
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4 )+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
        }
    }
    public void deleteVehicle(String vehicle_number)throws Exception{
        st=conn.createStatement();
        String query = "DELETE FROM vehicle WHERE vehicle_number = '" + vehicle_number + "'";
        int deleted = st.executeUpdate(query);
        System.out.println("Removing Vehicle Details....");
        if (deleted == 1) {
            Thread.sleep(2000);
            System.out.println("Vehicle Details Removed");
        } else {
            System.out.println("Not deleted");
        }
    }
    public void display(String val)throws Exception{
        st=conn.createStatement();
        String query = "SELECT * FROM vehicle ORDER BY ='"+val+"' ASC";
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4 )+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8)+" "+rs.getString(9));
        }
    }
    public void search(String val,String key)throws Exception{
        st=conn.createStatement();
        String query = "SELECT * FROM vehicle WHERE '"+key+"'='" +val+ "'";
        ResultSet rs=st.executeQuery(query);
        while(rs.next()){
            System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3)+" "+rs.getString(4 )+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+" "+rs.getString(8));
        }
    }
    public void updateVehicleDetails(String vehicle_number,String val,String key)throws Exception{
        st=conn.createStatement();
        String query = String.format("UPDATE vehicle SET %s = '%s' WHERE vehicle_number = '%s'", key, val, vehicle_number);
        int updated = st.executeUpdate(query);
        System.out.printf("Updating %s....", key);
        if (updated == 1) {
            Thread.sleep(2000);
            System.out.printf("Updated %s", key);
        } else {
            System.out.printf("Failed to update %s", key);
        }
    }
    public void updateUserDetails(String email,String val,String key)throws Exception{
        st=conn.createStatement();
        String query = String.format("UPDATE users SET %s = '%s' WHERE email = '%s'", key, val, email);
        int updated = st.executeUpdate(query);
        System.out.printf("Updating %s....", key);
        if (updated == 1) {
            Thread.sleep(2000);
            System.out.printf("Updated %s", key);
        } else {
            System.out.printf("Failed to update %s", key);
        }
    }
}
