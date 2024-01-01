package user;
public class Usercontroller {
    private Usermodel model;
    private Userview view;
    private String username;
    private String email;
    private String mobile;
    public Usercontroller(Usermodel model,Userview view,String username,String email,String mobile){
        this.model=model;
        this.view=view;
        this.username=username;
        this.email=email;
        this.mobile=mobile;
    }
    public void process()throws Exception{
        int i=0;
        do{
            System.out.println("1.Display All Available Vehicles || 2.Rent a Vehicle  || 3.Pay Fines  || 4.Extend Rent || 5.View Cart  || 6.Payment  || 7.View History");
            i=view.input();
            switch(i){
                case 1:
                    model.displayVehicles();
                    break;
                case 2:
                    System.out.println("Enter Vehicle Name (or) Vehcile_Number:");
                    String str=view.value();
                    String[] arr=model.fetchVehicleDetails(str);
                    String vehicle_name=arr[0];
                    String vehicle_number=arr[1];
                    String rent_price=arr[2];
                    String type=arr[3];
                    System.out.println("1.To Rent a vehicle  || 2.Add vehicle to cart");
                    int k=view.input();
                    switch(k){
                        case 1:
                            model.rentVehicle(username,email,mobile,vehicle_name,vehicle_number,rent_price,type);
                            model.updateVehicleRented("YES",vehicle_number);
                            break;
                        case 2:
                            model.addToCart(vehicle_name,vehicle_number,username,email,mobile);
                            model.updateVehicleRented("YES",vehicle_number);
                            break;
                        default:
                            System.out.println("Invalid options");
                            break;
                    }
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                default:
                    System.out.println("Invalid Options");
                    break;
                
            }
        }
        while(1!=8);
    }
}
