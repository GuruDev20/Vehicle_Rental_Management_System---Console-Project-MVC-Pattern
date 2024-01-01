package user;
public class Usercontroller {
    private Usermodel model;
    private Userview view;
    public Usercontroller(Usermodel model,Userview view){
        this.model=model;
        this.view=view;
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
                
            }
        }
        while(1!=8);
    }
}
