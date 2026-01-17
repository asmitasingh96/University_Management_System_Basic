// Source code is decompiled from a .class file using FernFlower decompiler (from Intellij IDEA).
package university.management.system1;

import java.awt.Color;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import net.proteanit.sql.DbUtils;

public class ExaminationDetails extends JFrame implements ActionListener {
   JTextField search;
   JButton submit;
   JButton cancel;
   JTable table;

   ExaminationDetails() {
      this.setSize(1000, 475);
      this.setLocation(300, 100);
      this.setLayout((LayoutManager)null);
      this.getContentPane().setBackground(Color.WHITE);
      
      JLabel heading = new JLabel("Check Result");
      heading.setBounds(80, 15, 400, 50);
      heading.setFont(new Font("Tahoma", 1, 24));
      this.add(heading);
      this.search = new JTextField();
      this.search.setBounds(80, 90, 200, 30);
      this.search.setFont(new Font("Tahoma", 0, 18));
      this.add(this.search);
      this.submit = new JButton("Result");
      this.submit.setBounds(300, 90, 120, 30);
      this.submit.setBackground(Color.BLACK);
      this.submit.setForeground(Color.WHITE);
      this.submit.addActionListener(this);
      this.submit.setFont(new Font("Tahoma", 1, 15));
      this.add(this.submit);
      this.cancel = new JButton("Back");
      this.cancel.setBounds(440, 90, 120, 30);
      this.cancel.setBackground(Color.BLACK);
      this.cancel.setForeground(Color.WHITE);
      this.cancel.addActionListener(this);
      this.cancel.setFont(new Font("Tahoma", 1, 15));
      this.add(this.cancel);
      this.table = new JTable();
      this.table.setFont(new Font("Tahoma", 0, 16));
      JScrollPane jsp = new JScrollPane(this.table);
      jsp.setBounds(0, 130, 1000, 310);
      this.add(jsp);

      try {
         Conn c = new Conn();
         ResultSet rs = c.s.executeQuery("select * from student");
         this.table.setModel(DbUtils.resultSetToTableModel(rs));
      } catch (Exception var5) {
         var5.printStackTrace();
      }

      this.table.addMouseListener(new MouseAdapter() {
         public void mouseClicked(MouseEvent me) {
            int row = ExaminationDetails.this.table.getSelectedRow();
            ExaminationDetails.this.search.setText(ExaminationDetails.this.table.getModel().getValueAt(row, 2).toString());
         }
      });
      this.setVisible(true);
   }

   public void actionPerformed(ActionEvent ae) {
      if (ae.getSource() == this.submit) {
         this.setVisible(false);
         new Marks(this.search.getText());
      } else {
         this.setVisible(false);
      }

   }

   public static void main(String[] args) {
      new ExaminationDetails();
   }
}
