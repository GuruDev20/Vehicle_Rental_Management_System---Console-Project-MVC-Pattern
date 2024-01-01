package user;
import java.util.*;
public class Userview {
    Scanner in=new Scanner(System.in);
    public int input(){
        int i=in.nextInt();
        in.nextLine();
        return i;
    }
    public String value(){return in.next();}
}