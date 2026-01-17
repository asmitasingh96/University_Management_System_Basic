// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package university.management.system1;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class UpdateStudent extends JFrame implements ActionListener {
   JTextField tfcourse;
   JTextField tfaddress;
   JTextField tfphone;
   JTextField tfemail;
   JTextField tfbranch;
   JLabel labelrollno;
   JButton submit;
   JButton cancel;
   Choice crollno;

   UpdateStudent() {
      this.setSize(900, 650);
      this.setLocation(350, 50);
      this.setLayout((LayoutManager)null);
      JLabel heading = new JLabel("Update Student Details");
      heading.setBounds(50, 10, 500, 50);
      heading.setFont(new Font("Tahoma", 2, 35));
      this.add(heading);
      JLabel lblrollnumber = new JLabel("Select Roll Number");
      lblrollnumber.setBounds(50, 100, 200, 20);
      lblrollnumber.setFont(new Font("serif", 0, 20));
      this.add(lblrollnumber);
      this.crollno = new Choice();
      this.crollno.setBounds(250, 100, 200, 20);
      this.add(this.crollno);

      try {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from student");

         while(rs.next()) {
            this.crollno.add(rs.getString("rollno"));
         }
      } catch (Exception var25) {
         var25.printStackTrace();
      }

      JLabel lblname = new JLabel("Name");
      lblname.setBounds(50, 150, 100, 30);
      lblname.setFont(new Font("serif", 1, 20));
      this.add(lblname);
      final JLabel labelname = new JLabel();
      labelname.setBounds(200, 150, 150, 30);
      labelname.setFont(new Font("Tahoma", 0, 18));
      this.add(labelname);
      JLabel lblfname = new JLabel("Father's Name");
      lblfname.setBounds(400, 150, 200, 30);
      lblfname.setFont(new Font("serif", 1, 20));
      this.add(lblfname);
      final JLabel labelfname = new JLabel();
      labelfname.setBounds(600, 150, 150, 30);
      labelfname.setFont(new Font("Tahoma", 0, 18));
      this.add(labelfname);
      JLabel lblrollno = new JLabel("Roll Number");
      lblrollno.setBounds(50, 200, 200, 30);
      lblrollno.setFont(new Font("serif", 1, 20));
      this.add(lblrollno);
      this.labelrollno = new JLabel();
      this.labelrollno.setBounds(200, 200, 200, 30);
      this.labelrollno.setFont(new Font("Tahoma", 0, 18));
      this.add(this.labelrollno);
      JLabel lbldob = new JLabel("Date of Birth");
      lbldob.setBounds(400, 200, 200, 30);
      lbldob.setFont(new Font("serif", 1, 20));
      this.add(lbldob);
      final JLabel labeldob = new JLabel();
      labeldob.setBounds(600, 200, 150, 30);
      labeldob.setFont(new Font("Tahoma", 0, 18));
      this.add(labeldob);
      JLabel lbladdress = new JLabel("Address");
      lbladdress.setBounds(50, 250, 200, 30);
      lbladdress.setFont(new Font("serif", 1, 20));
      this.add(lbladdress);
      this.tfaddress = new JTextField();
      this.tfaddress.setBounds(200, 250, 150, 30);
      this.add(this.tfaddress);
      JLabel lblphone = new JLabel("Phone");
      lblphone.setBounds(400, 250, 200, 30);
      lblphone.setFont(new Font("serif", 1, 20));
      this.add(lblphone);
      this.tfphone = new JTextField();
      this.tfphone.setBounds(600, 250, 150, 30);
      this.add(this.tfphone);
      JLabel lblemail = new JLabel("Email Id");
      lblemail.setBounds(50, 300, 200, 30);
      lblemail.setFont(new Font("serif", 1, 20));
      this.add(lblemail);
      this.tfemail = new JTextField();
      this.tfemail.setBounds(200, 300, 150, 30);
      this.add(this.tfemail);
      JLabel lblx = new JLabel("Class X (%)");
      lblx.setBounds(400, 300, 200, 30);
      lblx.setFont(new Font("serif", 1, 20));
      this.add(lblx);
      final JLabel labelx = new JLabel();
      labelx.setBounds(600, 300, 150, 30);
      labelx.setFont(new Font("Tahoma", 0, 18));
      this.add(labelx);
      JLabel lblxii = new JLabel("Class XII (%)");
      lblxii.setBounds(50, 350, 200, 30);
      lblxii.setFont(new Font("serif", 1, 20));
      this.add(lblxii);
      final JLabel labelxii = new JLabel();
      labelxii.setBounds(200, 350, 150, 30);
      labelxii.setFont(new Font("Tahoma", 0, 18));
      this.add(labelxii);
      JLabel lblaadhar = new JLabel("Aadhar Number");
      lblaadhar.setBounds(400, 350, 200, 30);
      lblaadhar.setFont(new Font("serif", 1, 20));
      this.add(lblaadhar);
      final JLabel labelaadhar = new JLabel();
      labelaadhar.setBounds(600, 350, 150, 30);
      labelaadhar.setFont(new Font("Tahoma", 0, 18));
      this.add(labelaadhar);
      JLabel lblcourse = new JLabel("Course");
      lblcourse.setBounds(50, 400, 200, 30);
      lblcourse.setFont(new Font("serif", 1, 20));
      this.add(lblcourse);
      this.tfcourse = new JTextField();
      this.tfcourse.setBounds(200, 400, 150, 30);
      this.add(this.tfcourse);
      JLabel lblbranch = new JLabel("Branch");
      lblbranch.setBounds(400, 400, 200, 30);
      lblbranch.setFont(new Font("serif", 1, 20));
      this.add(lblbranch);
      this.tfbranch = new JTextField();
      this.tfbranch.setBounds(600, 400, 150, 30);
      this.add(this.tfbranch);

      try {
         Conn c = new Conn();
         String query = "select * from student where rollno='" + this.crollno.getSelectedItem() + "'";
         ResultSet rs = c.s.executeQuery(query);

         while(rs.next()) {
            labelname.setText(rs.getString("name"));
            labelfname.setText(rs.getString("fname"));
            labeldob.setText(rs.getString("dob"));
            this.tfaddress.setText(rs.getString("address"));
            this.tfphone.setText(rs.getString("phone"));
            this.tfemail.setText(rs.getString("email"));
            labelx.setText(rs.getString("class_x"));
            labelxii.setText(rs.getString("class_xii"));
            labelaadhar.setText(rs.getString("aadhar"));
            this.labelrollno.setText(rs.getString("rollno"));
            this.tfcourse.setText(rs.getString("course"));
            this.tfbranch.setText(rs.getString("branch"));
         }
      } catch (Exception var24) {
         var24.printStackTrace();
      }

      this.crollno.addItemListener(new ItemListener() {
         public void itemStateChanged(ItemEvent ie) {
            try {
               Conn c = new Conn();
               String query = "select * from student where rollno='" + UpdateStudent.this.crollno.getSelectedItem() + "'";
               ResultSet rs = c.s.executeQuery(query);

               while(rs.next()) {
                  labelname.setText(rs.getString("name"));
                  labelfname.setText(rs.getString("fname"));
                  labeldob.setText(rs.getString("dob"));
                  UpdateStudent.this.tfaddress.setText(rs.getString("address"));
                  UpdateStudent.this.tfphone.setText(rs.getString("phone"));
                  UpdateStudent.this.tfemail.setText(rs.getString("email"));
                  labelx.setText(rs.getString("class_x"));
                  labelxii.setText(rs.getString("class_xii"));
                  labelaadhar.setText(rs.getString("aadhar"));
                  UpdateStudent.this.labelrollno.setText(rs.getString("rollno"));
                  UpdateStudent.this.tfcourse.setText(rs.getString("course"));
                  UpdateStudent.this.tfbranch.setText(rs.getString("branch"));
               }
            } catch (Exception var5) {
               var5.printStackTrace();
            }

         }
      });
      this.submit = new JButton("Update");
      this.submit.setBounds(250, 500, 120, 30);
      this.submit.setBackground(Color.BLACK);
      this.submit.setForeground(Color.WHITE);
      this.submit.addActionListener(this);
      this.submit.setFont(new Font("Tahoma", 1, 15));
      this.add(this.submit);
      this.cancel = new JButton("Cancel");
      this.cancel.setBounds(450, 500, 120, 30);
      this.cancel.setBackground(Color.BLACK);
      this.cancel.setForeground(Color.WHITE);
      this.cancel.addActionListener(this);
      this.cancel.setFont(new Font("Tahoma", 1, 15));
      this.add(this.cancel);
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.submit) {
         String rollno = this.labelrollno.getText();
         String address = this.tfaddress.getText();
         String phone = this.tfphone.getText();
         String email = this.tfemail.getText();
         String course = this.tfcourse.getText();
         String branch = this.tfbranch.getText();

         try {
            String query = "update student set address='" + address + "', phone='" + phone + "', email='" + email + "', course='" + course + "', branch='" + branch + "' where rollno='" + rollno + "'";
            Conn con = new Conn();
            con.s.executeUpdate(query);
            JOptionPane.showMessageDialog((Component)null, "Student Details Updated Successfully");
            this.setVisible(false);
         } catch (Exception var10) {
            var10.printStackTrace();
         }
      } else {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new UpdateStudent();
   }
}
