// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package university.management.system1;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
   JButton login;
   JButton cancel;
   JTextField tfusername;
   JTextField tfpassword;

   Login() {
      this.getContentPane().setBackground(Color.WHITE);
      this.setLayout((LayoutManager)null);
      JLabel lblusername = new JLabel("Username");
      lblusername.setBounds(40, 20, 100, 20);
      this.add(lblusername);
      this.tfusername = new JTextField();
      this.tfusername.setBounds(150, 20, 150, 20);
      this.add(this.tfusername);
      JLabel lblpassword = new JLabel("Password");
      lblpassword.setBounds(40, 70, 100, 20);
      this.add(lblpassword);
      this.tfpassword = new JPasswordField();
      this.tfpassword.setBounds(150, 70, 150, 20);
      this.add(this.tfpassword);
      this.login = new JButton("Login");
      this.login.setBounds(40, 140, 120, 30);
      this.login.setBackground(Color.BLACK);
      this.login.setForeground(Color.WHITE);
      this.login.addActionListener(this);
      this.login.setFont(new Font("Tahoma", 1, 15));
      this.add(this.login);
      this.cancel = new JButton("Cancel");
      this.cancel.setBounds(180, 140, 120, 30);
      this.cancel.setBackground(Color.BLACK);
      this.cancel.setForeground(Color.WHITE);
      this.cancel.addActionListener(this);
      this.cancel.setFont(new Font("Tahoma", 1, 15));
      this.add(this.cancel);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
      Image i2 = i1.getImage().getScaledInstance(200, 200, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(350, 0, 200, 200);
      this.add(image);
      this.setSize(600, 300);
      this.setLocation(500, 250);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.login) {
         String username = this.tfusername.getText();
         String password = this.tfpassword.getText();
         String query = "select * from login where username='" + username + "' and password='" + password + "'";

         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery(query);
            if (rs.next()) {
               this.setVisible(false);
               new Project();
            } else {
               JOptionPane.showMessageDialog((Component)null, "Invalid username or password");
               this.setVisible(false);
            }
         } catch (Exception var7) {
            var7.printStackTrace();
         }
      } else if (ae.getSource() == this.cancel) {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new Login();
   }
}
