package admin;
public class Admincontroller {
    private Adminmodel model;
    private Adminview view;
    public Admincontroller(Adminmodel model, Adminview view){
        this.model=model;
        this.view=view;
    }
    public void process()throws Exception{
        int i=0;
        do{
            System.out.println("1.To Add Vehicle  || 2.To Update Vehicle  || 3.To Delete Vehicle  || 4.Display Vehicles  || 5.Search Vehicle  || 6.Display Rented Vehicle || 7.Display Fines || 8.Handle Users");
            i=view.input();
            switch(i){
                case 1:
                    System.out.println("1.Add New Vehicle  || 2.Add Existing Vehicle");
                    int k=view.input();
                    switch(k){
                        case 1:
                            System.out.println("Enter Vehicle Name:");
                            String vehicle_name=view.value();
                            System.out.println("Enter Vehicle Number Plate:");
                            String vehicle_number=view.value();
                            System.out.println("Enter type of vehcile:");
                            String type=view.value();
                            System.out.println("Enter rent price:");
                            String rent_price=view.value();
                            model.addVehicle(vehicle_name,vehicle_number,type,rent_price,"0","GOOD","NO");
                            break;
                        case 2:
                            System.out.println("Enter Vehicle Name:");
                            vehicle_name=view.value();
                            System.out.println("Enter Vehicle Number Plate:");
                            vehicle_number=view.value();
                            System.out.println("Enter type of vehcile:");
                            type=view.value();
                            System.out.println("Enter rent price:");
                            rent_price=view.value();
                            System.out.println("Enter kilometer run:");
                            String kilometer=view.value();
                            System.out.println("Enter vehicle condition:");
                            String condition=view.value();
                            System.out.println("Need Service or Not");
                            String service=view.value();
                            model.addVehicle(vehicle_name,vehicle_number,type,rent_price,kilometer,condition,service);
                            break;
                        case 3:
                            break;
                        default:
                            System.out.println("invalid options");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("Updating vehicle details");
                    System.out.println();
                    model.displayVehicles();
                    System.out.println();
                    System.out.println("Enter vehcile number:");
                    String vehicle_number=view.value();
                    do{
                        System.out.println("1.To Update Vehicle Name  || 2.To Update Vehicle_Number || 3.To Update Vehicle_Type || 4.To Update Vehicle_Rent_Price || 5.To Update Vehicle_Kilometer_Run || 6.To Update Vehicle_Quality || 7.To Update Vehicle_ServiceNeed");
                        i=view.input();
                        switch(i){
                            case 1:
                                System.out.println("Enter New Vehicle Name:");
                                String new_vehicleName=view.value();
                                model.updateVehicleDetails(vehicle_number, new_vehicleName, "vehicle_name");
                                break;
                            case 2:
                                System.out.println("Enter New Vehicle Number:");
                                String v_new_number=view.value();
                                model.updateVehicleDetails(vehicle_number, v_new_number, "vehicle_number");
                                break;
                            case 3:
                                System.out.println("Enter New Vehicle Type:");
                                String new_vehicleType=view.value();
                                model.updateVehicleDetails(vehicle_number, new_vehicleType, "type");
                                break;
                            case 4:
                                System.out.println("Enter New Vehicle Rent Price:");
                                String new_rent_price=view.value();
                                model.updateVehicleDetails(vehicle_number, new_rent_price, "rent_price");
                                break;
                            case 5:
                                System.out.println("Enter New Vehicle Kilometer_Run:");
                                String new_vh_run=view.value();
                                model.updateVehicleDetails(vehicle_number, new_vh_run, "kilometer");
                                break;
                            case 6:
                                System.out.println("Enter New Vehicle Quality:");
                                String new_vehicle_quality=view.value();
                                model.updateVehicleDetails(vehicle_number, new_vehicle_quality, "condition");
                                break;
                            case 7:
                                System.out.println("Enter New Vehicle Service Need:");
                                String new_vehicle_service=view.value();
                                model.updateVehicleDetails(vehicle_number, new_vehicle_service, "service");
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println("Invalid Options");
                                break;
                        }         
                    }
                    while(i!=8);
                    break;
                case 3:
                    model.displayVehicles();
                    System.out.println("Enter vehicle number:");
                    vehicle_number=view.value();
                    model.deleteVehicle(vehicle_number);
                    break;
                case 4:
                    System.out.println("Displaying vehicles");
                    int ch;
                    do{
                        System.out.println("1.Display vehicle by name  || 2.Display vehcile by number  || 3.Disply by service need  || 4.Display by price");
                        ch=view.input();
                        switch(ch){
                            case 1:
                                model.display("vehicle_name");
                                break;
                            case 2:
                                model.display("vehicle_number");
                                break;
                            case 3:
                                model.display("service");
                                break;
                            case 4:
                                model.display("rent_price");
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Invalid Options");
                                break;
                        }
                    }
                    while(ch!=5);
                    break;
                case 5:
                    System.out.println("Search vehicles");
                    int c;
                    do{
                        System.out.println("1.Search vehicle by name || 2.Search vehicle by number");
                        c=view.input();
                        switch(c){
                            case 1:
                                System.out.println("Enter vehicle name:");
                                String vehicle_name=view.value();
                                model.search(vehicle_name,"vehcile_name");
                                break;
                            case 2:
                                System.out.println("Enter vehicle number:");
                                String vehicle_Number=view.value();
                                model.search(vehicle_Number,"vehcile_number");
                                break;
                            case 3:
                                break;
                            default:
                                System.out.println("Invalid options");
                                break;
                        }
                    }
                    while(c!=3);
                    break;
                case 6:
                    model.displayRentedVehicles();
                    break;
                case 7:
                    model.displayFines();
                    break;
                case 8:
                    System.out.println("Updating user details...");
                    System.out.println("Enter email-id");
                    String email=view.value();
                    do{
                        System.out.println("1.To Update Username  || 2.To Update Email  || 3.To Update Mobile_Number  || 4.To Update Aadhaar  || 5.To Update License Number  || 6.To Update Address || 7.To Update Security deposit ");
                        i=view.input();
                        switch(i){
                            case 1:
                                System.out.println("Enter new Username:");
                                String newUsername=view.value();
                                model.updateUserDetails(email, newUsername, "username");
                                break;
                            case 2:
                                System.out.println("Enter new email:");
                                String newEmail=view.value();
                                model.updateUserDetails(email, newEmail, "email");
                                break;
                            case 3:
                                System.out.println("Enter new Mobile Number:");
                                String newMobileNumber=view.value();
                                model.updateUserDetails(email, newMobileNumber, "mobile");
                                break;
                            case 4:
                                System.out.println("Enter new Aadhaar number:");
                                String neweAadhaar=view.value();
                                model.updateUserDetails(email, neweAadhaar, "aadhaar");
                                break;
                            case 5:
                                System.out.println("Enter new License number:");
                                String license=view.value();
                                model.updateUserDetails(email, license, "license");
                                break;
                            case 6:
                                System.out.println("Enter New Address:");
                                String address=view.value();
                                model.updateUserDetails(email, address, "address");
                                break;
                            case 7:
                                System.out.println("Enter New Security deposit:");
                                String amount=view.value();
                                model.updateUserDetails(email, amount, "security");
                                break;
                            case 8:
                                break;
                            default:
                                System.out.println("Invalid Options");
                                break;
                        }
                    }
                    while(i!=8);
                    break;
                case 9:
                    break;
                default:
                    System.out.println("Invalid options");
                    break;
            }
        }
        while(i!=9);
    }
}
