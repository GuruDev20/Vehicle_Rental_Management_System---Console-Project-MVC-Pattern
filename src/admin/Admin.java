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
}
