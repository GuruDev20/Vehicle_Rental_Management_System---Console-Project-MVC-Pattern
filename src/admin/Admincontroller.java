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
            System.out.println("1.To Add Vehicle  || 2.To Update Vehicle  || 3.To Delete Vehicle  || 4.Display Vehicles by Names || 5.Display Vehicles by Number || 6.Display Vehicles need Services  || 7.Display Vehicles by Price  || 8.Search Vehicle by Name || 9.Search Vehicle by Number_Plate || 10.Display Rented Vehicle || 11.Display Fines || 12.Handle Users");
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
                    System.out.println("Enter the ");
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
                case 11:
                    break;
                case 12:
                    break;
                case 13:
                    break;
                default:
                    System.out.println("Invalid options");
                    break;
            }
        }
        while(i!=13);
    }
}
