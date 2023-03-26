
package atm.pkginterface;
import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class History extends JFrame{
    String pinn;
    History(String pinn){
        this.pinn=pinn;
        setTitle("Transaction History");
        
        JLabel bank=new JLabel("ICICI Bank");
        bank.setBounds(150,20,100,20);
        add(bank);
        
        JLabel card=new JLabel();
        card.setBounds(50,50,200,20);
        add(card);
        
        JLabel text=new JLabel();
        text.setBounds(100,140,400,200);
        add(text);
        
        JLabel balance=new JLabel();
        balance.setBounds(20,400,300,20);
        
        try{
            Connect c=new Connect();
            ResultSet rs=c.s.executeQuery("select* from signup3 where pinnum='"+pinn+"'");
            while(rs.next()){
                card.setText("Card Number : "+rs.getString("cardnum").substring(0,4)+" xxxx xxxx "+rs.getString("cardnum").substring(12));
                
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
        try{
            Connect c= new Connect();
            int b=0;
            ResultSet rs=c.s.executeQuery("select * from bank where pin='"+pinn+"'");
            while(rs.next()){
                text.setText(text.getText()+"<html>"+rs.getString("date")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("type")+"&nbsp;&nbsp;&nbsp;&nbsp;"+rs.getString("amount")+"<br><br><html>");
                if(rs.getString("type").equals("Deposit")){
                    b+=Integer.parseInt(rs.getString("amount"));
                }else{
                    b-=Integer.parseInt(rs.getString("amount"));
                }
            
            
            }balance.setText("Your current balance is Rs "+b);
            
        }
        catch(Exception e){
            System.out.println(e);
        }
        
       
        setSize(500,900);
        setLocation(20,20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
        
    }
    public static void main(String[] args){
        new History("");
    }
    
    
}
