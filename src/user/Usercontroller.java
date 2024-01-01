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
                            model.addToCart(vehicle_name,vehicle_number,rent_price,username,email,mobile);
                            model.updateVehicleRented("YES",vehicle_number);
                            break;
                        default:
                            System.out.println("Invalid options");
                            break;
                    }
                    break;
                case 3:
                    String fines=model.displayFinesToPay(email);
                    System.out.println("Enter fine amount:");
                    String val=view.value();
                    model.payFines(email,val,fines);
                    break;
                case 4:
                    System.out.println("Do you need to extend your rent for an extra day?");
                    System.out.println("1. Yes, extend rent || 2. Cancel extension");
                    int n = view.input();
                    switch (n) {
                        case 1:
                            if (model.canExtendRent(email)) {
                                model.extendRent(email, 1);
                            } else {
                                System.out.println("Sorry, the vehicle cannot be rented for more than 2 days consecutively.");
                            }
                            break;
                        case 2:
                            break;
                        default:
                            System.out.println("Invalid options");
                            break;
                    }
                    break;
                case 5:
                    model.viewCart(email);
                    System.out.println("1.Remove all from cart || 2.Enter a vehicle number to remove");
                    int number=view.input();
                    switch(number){
                        case 1:
                            model.removeAllVehicle(email); 
                            break;
                        case 2:
                            System.out.println("Enter vehicle number:");
                            String num=view.value();
                            model.removeVehicle(num,email);
                            break;
                        default:
                            System.out.println("Invalid options");
                            break;
                    }
                    break;
                case 6:
                    break;
                case 7:
                    model.viewHistory(email);
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
