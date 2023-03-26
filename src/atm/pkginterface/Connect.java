
package atm.pkginterface;
import java.sql.*;

public class Connect {
    Connection c;
    Statement s;
    public Connect(){
        try{
            //Class.forName(com.mysql.cj.jdbc.Driver);
            c=DriverManager.getConnection("jdbc:mysql:///atminterface","root","Sreyareddy@27");
            s=c.createStatement();
            
        }
        catch(Exception e){
            System.out.println(e);
            
        }
            
     }
    
}
