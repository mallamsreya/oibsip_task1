
package atm.pkginterface;
import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
public class Signup1 extends JFrame implements ActionListener{
    long num;
    JTextField nametxt,aadhartxt,phonetxt,mailtxt,addresstxt;
    JButton register;
    Signup1(){
         setTitle("SIGN UP FORM");
         setLayout(null);
        Random r=new Random();
         num=Math.abs((r.nextLong()%9000L)+1000L);
        
        
       JLabel form=new JLabel("APPLICATION NO : "+num);
       form.setFont(new Font("Osward",Font.BOLD,24));
       form.setBounds(140,20,300,40);
       add(form);
       
       JLabel name=new JLabel("Name :");
       name.setFont(new Font("Osward",Font.BOLD,20));
       name.setBounds(70,70,200,40);
       add(name);
       
       nametxt=new JTextField();
       nametxt.setFont(new Font("Osward",Font.BOLD,20));
       nametxt.setBounds(290,70,200,40);
       add(nametxt);
       
       
       
       JLabel aadhar=new JLabel("Aadhar No :");
       aadhar.setFont(new Font("Osward",Font.BOLD,20));
       aadhar.setBounds(70,120,200,40);
       add(aadhar);
       
       aadhartxt=new JTextField();
       aadhartxt.setFont(new Font("Osward",Font.BOLD,20));
       aadhartxt.setBounds(290,120,200,40);
       add(aadhartxt);
       
       JLabel phone=new JLabel("Phone no : ");
       phone.setFont(new Font("Osward",Font.BOLD,20));
       phone.setBounds(70,170,200,40);
       add(phone);
       
       phonetxt=new JTextField();
       phonetxt.setFont(new Font("Osward",Font.BOLD,20));
       phonetxt.setBounds(290,170,200,40);
       add(phonetxt);
       
       JLabel mail=new JLabel("Mail id :");
       mail.setFont(new Font("Osward",Font.BOLD,20));
       mail.setBounds(70,220,200,40);
       add(mail);
       
       mailtxt=new JTextField();
        mailtxt.setFont(new Font("Osward",Font.BOLD,20));
       mailtxt.setBounds(290,220,200,40);
       add(mailtxt);
       
       
       JLabel address=new JLabel("Address :");
       address.setFont(new Font("Osward",Font.BOLD,20));
       address.setBounds(70,270,200,40);
       add(address);
      
       addresstxt=new JTextField();
       addresstxt.setFont(new Font("Osward",Font.BOLD,20));
       addresstxt.setBounds(290,270,200,40);
       add(addresstxt);
       
       register=new JButton("SIGN UP");
        register.setBounds(200,350,200,40);
        register.setBackground(Color.BLACK);
        register.setForeground(Color.WHITE);
        register.addActionListener(this);
        add(register);
       
       getContentPane().setBackground(Color.WHITE);
       setSize(600,500);
       setLocation(350,100);
       setVisible(true);
       
     
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        String formno=""+num;
        String name=nametxt.getText();
        String aadhar=aadhartxt.getText();
        String phone=phonetxt.getText();
        String mail=mailtxt.getText();
        String address=addresstxt.getText();
        
        try{
            if(name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is required");
                
            }
            else{
                Connect c=new Connect();
                String query="insert into signup values('"+formno+"','"+name+"','"+aadhar+"','"+phone+"','"+mail+"','"+address+"')";
                c.s.executeUpdate(query);
                setVisible(false);
                new Signup3(formno);
            }
                
        }
        catch(Exception e){
            System.out.println(e);
        }
        
            
    }
    public static void main(String args[]){
        Signup1 signup1 = new Signup1();
    }
    
}
