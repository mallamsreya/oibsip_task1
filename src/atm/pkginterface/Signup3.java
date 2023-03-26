
package atm.pkginterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Signup3 extends JFrame implements ActionListener{
    JButton exit;
    String formno;
    

    
    Signup3(String formno){
        this.formno=formno;
        JLabel account=new JLabel("Your Card Details");
        account.setFont(new Font("Raleway",Font.BOLD,30));
        account.setBounds(100,20,300,40);
        add(account);
        
        JLabel card=new JLabel("Card No:");
        card.setFont(new Font("Raleway",Font.PLAIN,24));
        card.setBounds(40,80,100,40);
        add(card);
        
        JLabel cardno=new JLabel("xxxx xxxx xxxx 0494");
        cardno.setFont(new Font("Raleway",Font.PLAIN,24));
        cardno.setBounds(150,80,300,40);
        add(cardno);
        
        JLabel pind=new JLabel("xxxx");
        pind.setFont(new Font("Raleway",Font.PLAIN,24));
        pind.setBounds(200,140,300,40);
        add(pind);
        
        JLabel pin=new JLabel("Pin : ");
        pin.setFont(new Font("Raleway",Font.PLAIN,24));
        pin.setBounds(90,140,100,40);
        add(pin);
       
        exit=new JButton("NEXT");
        exit.setBounds(180,250,100,40);
        exit.setBackground(Color.BLACK);
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Raleway",Font.BOLD,24));
        exit.addActionListener(this);
        add(exit);
        
        JLabel details=new JLabel("");
        details.setFont(new Font("Raleway",Font.PLAIN,24));
        details.setBounds(100,200,300,40);
        add(details);
        
        setSize(500,400);
        setLocation(400,180);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==exit){
            setVisible(false);
            Random random=new Random();
            String cardnum=""+Math.abs(random.nextLong() %90000000L+4849703900000000L);
             String pinnum=""+Math.abs((random.nextLong()%9000L)+10000L);
             try{
                 Connect c1=new Connect();
                 String query1="insert into signup3 values('"+formno+"','"+cardnum+"','"+pinnum+"')";
                 c1.s.executeUpdate(query1);
                 JOptionPane.showMessageDialog(null, "Card Number : "+cardnum+"\n"+"Pin : "+pinnum);
                 
             
                 new Login().setVisible(true);
             
             }
             catch(Exception e){
                 System.out.println(e);
             }
             
             
        
        }
        
    }
    public static void main(String[] args){
        new Signup3("");
        
    }
    
    
    
}
