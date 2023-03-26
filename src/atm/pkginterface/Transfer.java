
package atm.pkginterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Date;
import java.sql.*;


public class Transfer extends JFrame implements ActionListener {
    String pinn;
    JButton transfer,back;
    JTextField amount,card;
    
    Transfer(String pinn){
        this.pinn=pinn;
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the card number of the receiver ");
        text.setBounds(190,203,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        card=new JTextField();
        card.setFont(new Font("System",Font.BOLD,24));
        card.setBounds(180,245,300,35);
        image.add(card);
        
        
        JLabel text1=new JLabel("Enter the amount to be transferred");
        text1.setBounds(210,290,700,35);
        text1.setForeground(Color.WHITE);
        text1.setFont(new Font("System",Font.BOLD,16));
        image.add(text1);
        
        amount=new JTextField();
        amount.setFont(new Font("System",Font.BOLD,24));
        amount.setBounds(210,335,250,35);
        image.add(amount);
        
        transfer=new JButton("Transfer");
        transfer.setBounds(350,390,150,30);
        transfer.addActionListener(this);
        image.add(transfer);
        
        back=new JButton("Back");
        back.setBounds(350,430,150,30);
        back.addActionListener(this);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(280,0);
        setVisible(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==transfer){
            String cardno=card.getText();
            String amt=amount.getText();
            Date date=new Date();
            if(amt.equals("")||cardno.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the valid details");}
           
            else{
                try{
                    Connect c=new Connect();
                    String pin="";
                    ResultSet rs=c.s.executeQuery("select pinnum from signup3 where cardnum='"+cardno+"'");
                    while(rs.next()){ pin=rs.getString("pinnum");}
                    Connect c1=new Connect();
                    c1.s.executeUpdate("insert into bank values('"+pin+"','"+date+"','Deposit','"+amt+"'),('"+this.pinn+"','"+date+"','Withdrawl','"+amt+"')");
                    
                }
                
                catch(Exception e){
                    System.out.println(e);
                }
                
                JOptionPane.showMessageDialog(null, "Amount transferred successfully");
                        
                
            }
                
            
        }
         if(ae.getSource()==back){
            setVisible(false);
            new Money(pinn).setVisible(true);
        }
    }
    public static void main(String[] args){
        new Transfer("");
    }
    
}
