// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package university.management.system1;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

public class StudentFeeForm extends JFrame implements ActionListener {
   Choice crollno;
   JComboBox cbcourse;
   JComboBox cbbranch;
   JComboBox cbsemester;
   JLabel labeltotal;
   JButton update;
   JButton pay;
   JButton back;

   StudentFeeForm() {
      this.setSize(900, 500);
      this.setLocation(300, 100);
      this.setLayout((LayoutManager)null);
      this.getContentPane().setBackground(Color.WHITE);
      ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fee.jpg"));
      Image i2 = i1.getImage().getScaledInstance(500, 300, 1);
      ImageIcon i3 = new ImageIcon(i2);
      JLabel image = new JLabel(i3);
      image.setBounds(400, 50, 500, 300);
      this.add(image);
      JLabel lblrollnumber = new JLabel("Select Roll No");
      lblrollnumber.setBounds(40, 60, 150, 20);
      lblrollnumber.setFont(new Font("Tahoma", 1, 16));
      this.add(lblrollnumber);
      this.crollno = new Choice();
      this.crollno.setBounds(200, 60, 150, 20);
      this.add(this.crollno);

      try {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from student");

         while(rs.next()) {
            this.crollno.add(rs.getString("rollno"));
         }
      } catch (Exception var18) {
         var18.printStackTrace();
      }

      JLabel lblname = new JLabel("Name");
      lblname.setBounds(40, 100, 150, 20);
      lblname.setFont(new Font("Tahoma", 1, 16));
      this.add(lblname);
      final JLabel labelname = new JLabel();
      labelname.setBounds(200, 100, 150, 20);
      labelname.setFont(new Font("Tahoma", 0, 16));
      this.add(labelname);
      JLabel lblfname = new JLabel("Father's Name");
      lblfname.setBounds(40, 140, 150, 20);
      lblfname.setFont(new Font("Tahoma", 1, 16));
      this.add(lblfname);
      final JLabel labelfname = new JLabel();
      labelfname.setBounds(200, 140, 150, 20);
      labelfname.setFont(new Font("Tahoma", 0, 16));
      this.add(labelfname);

      try {
         Conn c = new Conn();
         String query = "select * from student where rollno='" + this.crollno.getSelectedItem() + "'";
         ResultSet rs = c.s.executeQuery(query);

         while(rs.next()) {
            labelname.setText(rs.getString("name"));
            labelfname.setText(rs.getString("fname"));
         }
      } catch (Exception var17) {
         var17.printStackTrace();
      }

      this.crollno.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent ie) {
            try {
               Conn c = new Conn();
               String query = "select * from student where rollno='" + StudentFeeForm.this.crollno.getSelectedItem() + "'";
               ResultSet rs = c.s.executeQuery(query);

               while(rs.next()) {
                  labelname.setText(rs.getString("name"));
                  labelfname.setText(rs.getString("fname"));
               }
            } catch (Exception var5) {
               var5.printStackTrace();
            }

         }
      });
      JLabel lblcourse = new JLabel("Course");
      lblcourse.setBounds(40, 180, 150, 20);
      lblcourse.setFont(new Font("Tahoma", 1, 16));
      this.add(lblcourse);
      String[] course = new String[]{"BTech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
      this.cbcourse = new JComboBox(course);
      this.cbcourse.setBounds(200, 180, 150, 20);
      this.cbcourse.setBackground(Color.WHITE);
      this.add(this.cbcourse);
      JLabel lblbranch = new JLabel("Branch");
      lblbranch.setBounds(40, 220, 150, 20);
      lblbranch.setFont(new Font("Tahoma", 1, 16));
      this.add(lblbranch);
      String[] branch = new String[]{"Computer Science", "Electronics", "Mechanical", "Civil", "IT"};
      this.cbbranch = new JComboBox(branch);
      this.cbbranch.setBounds(200, 220, 150, 20);
      this.cbbranch.setBackground(Color.WHITE);
      this.add(this.cbbranch);
      JLabel lblsemester = new JLabel("Semester");
      lblsemester.setBounds(40, 260, 150, 20);
      lblsemester.setFont(new Font("Tahoma", 1, 16));
      this.add(lblsemester);
      String[] semester = new String[]{"Semester1", "Semester2", "Semester3", "Semester4", "Semester5", "Semester6", "Semester7", "Semester8"};
      this.cbsemester = new JComboBox(semester);
      this.cbsemester.setBounds(200, 260, 150, 20);
      this.cbsemester.setBackground(Color.WHITE);
      this.add(this.cbsemester);
      JLabel lbltotal = new JLabel("Total Payable");
      lbltotal.setBounds(40, 300, 150, 20);
      lbltotal.setFont(new Font("Tahoma", 1, 16));
      this.add(lbltotal);
      this.labeltotal = new JLabel();
      this.labeltotal.setBounds(200, 300, 150, 20);
      this.labeltotal.setFont(new Font("Tahoma", 0, 16));
      this.add(this.labeltotal);
      this.update = new JButton("Update");
      this.update.setBounds(30, 380, 100, 25);
      this.update.setBackground(Color.BLACK);
      this.update.setForeground(Color.WHITE);
      this.update.addActionListener(this);
      this.add(this.update);
      this.pay = new JButton("Pay Fee");
      this.pay.setBounds(150, 380, 100, 25);
      this.pay.setBackground(Color.BLACK);
      this.pay.setForeground(Color.WHITE);
      this.pay.addActionListener(this);
      this.pay.setFont(new Font("Tahoma", 1, 15));
      this.add(this.pay);
      this.back = new JButton("Back");
      this.back.setBounds(270, 380, 100, 25);
      this.back.setBackground(Color.BLACK);
      this.back.setForeground(Color.WHITE);
      this.back.addActionListener(this);
      this.back.setFont(new Font("Tahoma", 1, 15));
      this.add(this.back);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      String rollno;
      String semester;
      if (ae.getSource() == this.update) {
         rollno = (String)this.cbcourse.getSelectedItem();
         semester = (String)this.cbsemester.getSelectedItem();

         try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from fee where course = '" + rollno + "'");

            while(rs.next()) {
               this.labeltotal.setText(rs.getString(semester));
            }
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      } else if (ae.getSource() == this.pay) {
         rollno = this.crollno.getSelectedItem();
         semester = (String)this.cbcourse.getSelectedItem();
         String semester = (String)this.cbsemester.getSelectedItem();
         String branch = (String)this.cbbranch.getSelectedItem();
         String total = this.labeltotal.getText();

         try {
            Conn c = new Conn();
            String query = "insert into collegefee values('" + rollno + "', '" + semester + "', '" + branch + "', '" + semester + "', '" + total + "')";
            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog((Component)null, "College fee submitted successfully");
            this.setVisible(false);
         } catch (Exception var9) {
            var9.printStackTrace();
         }
      } else {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new StudentFeeForm();
   }
}
