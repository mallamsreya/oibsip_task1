
package atm.pkginterface;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener{
    JButton sign,clear,signup;
    JTextField cardtxt;
    JPasswordField pintxt;
    
    Login(){
        setTitle("Automated Teller Machine");
        
        setLayout(null);
        ImageIcon i=new ImageIcon(ClassLoader.getSystemResource("icons/atm_logo.png"));
        Image i_new=i.getImage().getScaledInstance(100,100,Image.SCALE_DEFAULT);
        ImageIcon i1=new ImageIcon(i_new);
        JLabel lab=new JLabel(i1);
        lab.setBounds(70,10,70,70);
        add(lab);
        
        JLabel intro=new JLabel("WELCOME");
        intro.setFont(new Font("Osward",Font.BOLD,35));
        intro.setBounds(180,10,300,60);
        add(intro);
        
        JLabel card=new JLabel("Card No :");
        card.setFont(new Font("Osward",Font.BOLD,24));
        card.setBounds(50,120,150,40);
        add(card);
        
        cardtxt=new JTextField();
        cardtxt.setBounds(210,120,220,40);
        add(cardtxt);
        
        JLabel pin=new JLabel("PIN :");
        pin.setFont(new Font("Osward",Font.BOLD,24));
        pin.setBounds(90,170,150,40);
        add(pin);
        
        pintxt=new JPasswordField();
        pintxt.setBounds(210,170,220,40);
        add(pintxt);
        
        sign = new JButton("LOGIN");
        sign.setBounds(90,240,150,40);
        sign.setBackground(Color.BLACK);
        sign.setForeground(Color.WHITE);
        sign.addActionListener(this);
        add(sign);
        
        clear = new JButton("CLEAR");
        clear.setBounds(250,240,150,40);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
        signup = new JButton("SIGN UP");
        signup.setBounds(160,300,180,40);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(520,450);
        setVisible(true);
        setLocation(440,200);
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==sign){
            Connect c=new Connect();
            String cardn=cardtxt.getText();
            String pinn=pintxt.getText();
            String query="select * from signup3 where cardnum = '"+cardn+"' and pinnum='"+pinn+"' ";
            try{
               ResultSet rs= c.s.executeQuery(query);
               if(rs.next()){
                   setVisible(false);
                   new Money(pinn).setVisible(true);
                   
               }else{
                   JOptionPane.showMessageDialog(null, "Incorrect details");
               }
                
            }
            catch(Exception e){
                System.out.println(e);
            }
            
            
        }
        else if(ae.getSource()==clear){
            cardtxt.setText("");
            pintxt.setText("");
        }
        else if(ae.getSource()==signup){
            setVisible(false);
            new Signup1().setVisible(true);
        }
        
        
    }
    

    public static void main(String args[]){
        new Login();
        
    
}
}
