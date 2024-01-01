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
                    System.out.println("Enter vehicle number:");
                    String v_number = view.value();
                    System.out.println("Enter vehicle type:");
                    String typeVehicle = view.value();
                    System.out.println("Enter return date:");
                    String date = view.value();
                    System.out.println("Enter vehicle quality (LOW, MEDIUM, HIGH):");
                    String quality = view.value();
                    System.out.println("Enter vehicle kilometer run:");
                    int run = Integer.parseInt(view.value());
                    double price = Double.parseDouble(model.fetchRentPrice(v_number));
                    String return_date = model.returnDate(email, v_number);
                    if (!date.equals(return_date)) {
                        price += 0.20 * price;
                    }
                    if (run >= 500) {
                        price += 0.15 * price;
                    } else if (run >= 1500 && typeVehicle.equals("bike")) {
                        model.setVehicleServiceStatus(v_number, "YES");
                    } else if (run >= 3000 && typeVehicle.equals("car")) {
                        model.setVehicleServiceStatus(v_number, "YES");
                    }
                    switch (quality) {
                        case "LOW":
                            double change=price-0.20 * price;
                            price += 0.20 * price;
                            model.setVehicleQuality(v_number,"LOW",change,String.valueOf(run));
                            break;
                        case "MEDIUM":
                            double change1=price-0.50 * price;
                            price += 0.50 * price;
                            model.setVehicleQuality(v_number,"MEDIUM",change1,String.valueOf(run));
                            break;
                        case "HIGH":
                            double change2=price-0.75 * price;
                            price += 0.75 * price;
                            model.setVehicleQuality(v_number,"HIGH",change2,String.valueOf(run));
                            break;
                    }
                    model.updateRentPrice(email, v_number, String.valueOf(price));
                    model.updateVehicleRented("NO",v_number);
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
