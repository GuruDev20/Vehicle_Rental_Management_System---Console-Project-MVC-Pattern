package user;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
abstract class Rentals{
    abstract void displayVehicles()throws Exception;
    abstract String[] fetchVehicleDetails(String str)throws Exception;
    abstract void rentVehicle(String username,String email,String mobile,String vehicle_name,String vehicle_number,String rent_price)throws Exception;
    abstract void updateVehicleRented(String rented,String vehicle_number)throws Exception;
}
public class Usermodel extends Rentals{
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
    public String[] fetchVehicleDetails(String str)throws Exception{
        String[] arr=new String[3];
        Statement s = conn.createStatement();
        String query = "SELECT * FROM vehicle WHERE vehicle_name = '" + str + "' OR vehicle_number = '" + str + "' AND rented='YES'";
        ResultSet resultSet = s.executeQuery(query);
        while (resultSet.next()) {
            arr[0] = resultSet.getString("vehicle_name");
            arr[1] = resultSet.getString("vehicle_number");
            arr[2]= resultSet.getString("rent_price");
        }
        return arr;
    }
    public void rentVehicle(String username,String email,String mobile,String vehicle_name,String vehicle_number,String rent_price)throws Exception{
        st=conn.createStatement();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date currentDate = new Date();
        String rentDate = dateFormat.format(currentDate);
        long returnDateTime = currentDate.getTime() + (24 * 60 * 60 * 1000); 
        Date returnDate = new Date(returnDateTime);
        String returnDateString = new SimpleDateFormat("yyyy-MM-dd 00:00:00").format(returnDate);
        String rentQuery = "INSERT INTO rented_vehicles(vehicle_name, vehicle_number, vehicle_user, email, mobile, rented,rent_date,return_date) VALUES('" + vehicle_name + "', '" + vehicle_number + "', '" + username + "', '" + email + "', '" + mobile + "', 'YES'"+rentDate+"','"+returnDateString+")";
        int inserted = st.executeUpdate(rentQuery);
        if (inserted == 1) {
            System.out.println("Rented vehicle");
        }
    }
    public void updateVehicleRented(String rented,String vehicle_number)throws Exception{
        st=conn.createStatement();
        String query="UPDATE vehicle SET available ='"+rented+"' WHERE vehicle_number='"+vehicle_number+"'";
        int updated=st.executeUpdate(query);
        if(updated==1){
            System.out.println("Vehicle Rented Status updated successfully");
        }
    }
}
