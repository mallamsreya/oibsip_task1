
package atm.pkginterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
    JButton deposit,back;
    JTextField amount;
    String pinn;
    Deposit(String pinn){
        this.pinn=pinn;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Enter the amount to be deposited");
        text.setBounds(210,245,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        amount=new JTextField();
        amount.setFont(new Font("System",Font.BOLD,24));
        amount.setBounds(210,300,250,35);
        image.add(amount);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(350,380,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        back=new JButton("Back");
        back.setBounds(350,415,150,30);
        back.addActionListener(this);
        image.add(back);
        
        setSize(900,900);
        setLocation(280,0);
        setVisible(true);
        //setUndecorated(true);
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==deposit){
            String amt=amount.getText();
            Date date=new Date();
            if(amt.equals("")){
                JOptionPane.showMessageDialog(null,"Please enter the amount to be deposited");
                
          }else{
                try{
                Connect c=new Connect();
                String query="insert into bank values('"+pinn+"','"+date+"','Deposit','"+amt+"')";
                c.s.executeUpdate(query);
               JOptionPane.showMessageDialog(null, "Amount deposited successfully");
               
                }
                catch(Exception e){
                    System.out.println(e);
                }
                
            }
                
        }
        if(ae.getSource()==back){
            setVisible(false);
            new Money(pinn).setVisible(true);
            
            
        }
        
    }
    public static void main(String[] args){
        new Deposit("");
        
    }
    
}
