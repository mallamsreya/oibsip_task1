
package atm.pkginterface;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class Money extends JFrame implements ActionListener{
    JButton deposit,withdrawl,history,balance,transfer,quit;
    String pinn;
    Money(String pinn){
        this.pinn=pinn;
        
        ImageIcon i1=new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2=i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3=new ImageIcon(i2);
        JLabel image=new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);
        
        JLabel text=new JLabel("Please select your transaction");
        text.setBounds(210,245,700,35);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("System",Font.BOLD,16));
        image.add(text);
        
        deposit=new JButton("Deposit");
        deposit.setBounds(160,345,150,30);
        deposit.addActionListener(this);
        image.add(deposit);
        
        withdrawl=new JButton("Cash Withdrawl");
        withdrawl.setBounds(350,345,150,30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);
        
        history=new JButton("Transaction History");
        history.setBounds(160,380,150,30);
        history.addActionListener(this);
        image.add(history);
        
        balance=new JButton("Bank Balance");
        balance.setBounds(350,380,150,30);
        balance.addActionListener(this);
        image.add(balance);
        
        transfer=new JButton("Transfer");
        transfer.setBounds(160,415,150,30);
        transfer.addActionListener(this);
        image.add(transfer);
        
        quit=new JButton("Quit");
        quit.setBounds(350,415,150,30);
        quit.addActionListener(this);
        image.add(quit);
                
        setSize(900,900);
        setLocation(280,0);
        setVisible(true);
        
        
        
        
    }
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==quit){
            setVisible(false);
        }
        else if(ae.getSource()==deposit){
            setVisible(false);
            new Deposit(pinn).setVisible(true);
            
        }else if(ae.getSource()==withdrawl){
            setVisible(false);
            new Withdrawl(pinn).setVisible(true);
        }
        else if(ae.getSource()==balance){
            setVisible(false);
            new Balance(pinn).setVisible(true);
        }else if(ae.getSource()==history){
        
            new History(pinn).setVisible(true);
            
        }else if(ae.getSource()==transfer){
            setVisible(false);
            new Transfer(pinn).setVisible(true);
        }
        
    }
    public static void main(String[] args){
        new Money("");
    }
    
}
