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
            System.out.println("1.To Add Vehicle  || 2.To Update Vehicle  || 3.To Delete Vehicle  || 4.Display Vehicles by Names  || 5.Search Vehicle by Name || 6.Search Vehicle by Number_Plate || 7.Display Rented Vehicle || 8.Display Fines || 9.Handle Users");
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
                    break;
                case 3:
                    model.displayVehicles();
                    System.out.println("Enter vehicle number:");
                    String vehicle_number=view.value();
                    model.deleteVehicle(vehicle_number);
                    break;
                case 4:
                    System.out.println("Displaying vehicles");
                    int ch=view.input();
                    do{
                        System.out.println("1.Display vehicle by name  || 2.Display vehcile by number  || 3.Disply by service need  || 4.Display by price");
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
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9:
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Invalid options");
                    break;
            }
        }
        while(i!=10);
    }
}
