package user;
public class User {
    private static User ref=null;
    private User(){}
    public static User getReference()throws Exception{
        if(ref==null){
            ref=new User();
        }
        return ref;
    }
}
