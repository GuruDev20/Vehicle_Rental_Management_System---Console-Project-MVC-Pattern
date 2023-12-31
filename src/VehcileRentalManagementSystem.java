import java.util.*;
import admin.Admin;
import user.User;
import java.sql.*;
class Vehicle{
    private static Vehicle ref=null;
    private Connection conn=null;
    private Vehicle(){}
    public static Vehicle getReference()throws Exception{
        if(ref==null){
            ref=new Vehicle();
        }
        return ref;
    }
    public Connection getConnection()throws Exception{
        if(conn==null){
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/vehciclerentalmanagementsystem", "root", "GuruDev20**");
        }
        return conn;
    }
}
class Users{
    protected String email;
    protected String password;
    protected Statement st=null;
    public Users(String email,String password){
        this.email=email;
        this.password=password;
    }
    public String getEmail(){
        return email;
    }
    public String getPassword(){
        return password;
    }
}
class Login extends Users{
    public Login(String email,String password){
        super(email,password);
    }
    public void login(Connection conn)throws Exception{
        st=conn.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM users WHERE email='"+email+"'");
        if(!rs.next()){
            System.out.println("User not registered");
        }
        else{
            rs=st.executeQuery("SELECT * FROM users WHERE email='"+email+"' AND password='"+password+"'");
            if(rs.next()){
                String defaultUser=rs.getString("defaultuser");
                if(defaultUser.equals("admin")){
                    System.out.println("Admin");
                    Admin admin=Admin.getReference();
                    //admin.print();
                }
                else if(defaultUser.equals("users")){
                    System.out.println("User");
                    User user=User.getReference();
                    //user.print();
                }
                else{
                    System.out.println("Invalid Default User");
                }
            }
            else{
                System.out.println("Invalid email or password");
            }
        }
    }
}
class Register extends Users{
    private String username;
    private String mobile;
    private String aadhaar;
    private String license;
    private String address;
    private String amount;
    public Register(String username,String email,String password,String mobile,String aadhaar,String license,String address,String amount){
        super(email,password);
        this.username=username;
        this.mobile=mobile;
        this.aadhaar=aadhaar;
        this.license=license;
        this.address=address;
        this.amount=amount;
    }
    public String getUsername(){
        return username;
    }
    public String getMobile(){
        return mobile;
    }
    public String getAadhaar(){
        return aadhaar;
    }
    public String getLicense(){
        return license;
    }
    public String getAddress(){
        return address;
    }
    public String getAmount(){
        return amount;
    }
    public void register(Connection conn)throws Exception{
        st=conn.createStatement();
        ResultSet rs=st.executeQuery("SELECT * FROM users WHERE email='"+email+"' ");
        if(rs.next()){
            System.out.println("User already registered");
        }
        else{
            int rowsInserted=st.executeUpdate("INSERT INTO users (username,email,password,mobile,aadhaar,license,address,security,defaultuser)VALUES('"+getUsername()+"','"+getEmail()+"','"+getPassword()+"','"+getMobile()+"','"+getAadhaar()+"','"+getLicense()+"','"+getAddress()+"','"+getAmount()+"','users')");
            if(rowsInserted>0){
                System.out.println("User registration successfully");
            }
            else{
                System.out.println("User registration failed");
            }
        }
    }
}
public class VehcileRentalManagementSystem {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        try{
            Vehicle v=Vehicle.getReference();
            Connection conn=v.getConnection();
            System.out.println("Connected to database");
            System.out.println("1.Login  || 2.Register");
            int choice=in.nextInt();
            switch(choice){
                case 1:
                    System.out.println("Enter email-id:");
                    String user_email=in.next();
                    System.out.println("Enter password:");
                    String user_password=in.next();
                    Login l=new Login(user_email,user_password);
                    l.login(conn);
                    break;
                case 2:
                    System.out.println("Enter username:");
                    String username=in.next();
                    System.out.println("Enter email-id:");
                    String email=in.next();
                    System.out.println("Enter password:");
                    String password=in.next();
                    System.out.println("Enter mobile number:");
                    String mobile=in.next();
                    System.out.println("Enter Aadhaar number:");
                    String aadhaar=in.next();
                    System.out.println("Enter License Number:");
                    String license=in.next();
                    in.nextLine();
                    System.out.println("Enter Address:");
                    String address=in.nextLine();
                    System.out.println("Enter security deposit amount:");
                    String amount=in.next();
                    Register r=new Register(username,email,password,mobile,aadhaar,license,address,amount);
                    r.register(conn);
                    break;
                default:
                    System.out.println("Invalid Options");
                    break;
            }
            conn.close();
        }
        catch(Exception e){
            System.out.println(e);
        }
        in.close();
    }
}
