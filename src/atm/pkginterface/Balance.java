
package atm.pkginterface;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Balance extends JFrame implements ActionListener {
    JButton back;
    String pinn;
    Balance(String pinn){
        this.pinn=pinn;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        
        
        Connect c=new Connect();
        int balance=0;
        try{
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinn+"'");
            while(rs.next()){
                if(rs.getString("type").equals("Deposit")){
                    balance+=Integer.parseInt(rs.getString("amount"));
                }else{
                    balance-=Integer.parseInt(rs.getString("amount"));
                }
                    
            }
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
        JLabel text=new JLabel("Your Current balance is Rs "+balance);
        text.setBounds(230,300,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        
                
        
         
        back=new JButton("Back");
        back.setBounds(350,415,150,30);
        back.addActionListener(this);
        image.add(back);
        
        
        setSize(900,900);
        setLocation(280,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Money(pinn).setVisible(true);
        
        
    }
    public static void main(String[] args){
        new Balance("");
        
        
    }
    
}
