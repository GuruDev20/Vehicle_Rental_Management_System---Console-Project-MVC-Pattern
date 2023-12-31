package admin;
public class Admin {
    private static Admin ref=null;
    private Admin(){}
    public static Admin getReference()throws Exception{
        if(ref==null){
            ref=new Admin();
        }
        return ref;
    }
    public void print() throws Exception{
        Adminmodel model=new Adminmodel();
        Adminview view=new Adminview();
        Admincontroller controller=new Admincontroller(model,view);
        controller.process();
    }
}
