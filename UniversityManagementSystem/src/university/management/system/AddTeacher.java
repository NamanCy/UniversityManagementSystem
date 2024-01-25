package university.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;

public class AddTeacher extends JFrame implements ActionListener {

    JTextField tfname, tffname, tfaddress, tffphone, tfemail, tffx, tffxii,tffaadhaar;
    JLabel labelempid;
    JDateChooser dcdob;
    JComboBox cbcourse,cbbranch;
    JButton submit, cancel;

    Random ran = new Random();
    long first4 = Math.abs((ran.nextLong() % 9000L) + 1000L);
    AddTeacher() {

        setSize(900,700);
        setLocation(350,50);

        setLayout(null);

        //Page Heading
        JLabel heading = new JLabel ("New Teacher Details");
        heading.setBounds(310,30,500,50);
        heading.setFont(new Font("serif",Font.BOLD,30));
        add(heading);

        //Name
        JLabel lblname = new JLabel ("Name");
        lblname.setBounds(50,150,100,30);
        lblname.setFont(new Font("serif",Font.BOLD,20));
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200,150,150,30);
        add(tfname);

        //Fathers Name
        JLabel lblfname = new JLabel ("Fathers Name");
        lblfname.setBounds(400,150,200,30);
        lblfname.setFont(new Font("serif",Font.BOLD,20));
        add(lblfname);

        tffname = new JTextField();
        tffname.setBounds(600,150,150,30);
        add(tffname);

        JLabel lblempid = new JLabel ("Employee ID");
        lblempid.setBounds(50,200,200,30);
        lblempid.setFont(new Font("serif",Font.BOLD,20));
        add(lblempid);

        labelempid = new JLabel ("101"+first4);
        labelempid.setBounds(200,200,200,30);
        labelempid.setFont(new Font("serif",Font.BOLD,20));
        add(labelempid);

        JLabel lbldob = new JLabel ("Date of Birth");
        lbldob.setBounds(400,200,200,30);
        lbldob.setFont(new Font("serif",Font.BOLD,20));
        add(lbldob);

        dcdob = new JDateChooser();
        dcdob.setBounds(600,200,150,30);
        add(dcdob);

        //address
        JLabel lbladdress = new JLabel ("Address");
        lbladdress.setBounds(50,250,200,30);
        lbladdress.setFont(new Font("serif",Font.BOLD,20));
        add(lbladdress);

        tfaddress = new JTextField();
        tfaddress.setBounds(200,250,150,30);
        add(tfaddress);

        //Phone Number
        JLabel lblphone = new JLabel ("Phone Number");
        lblphone.setBounds(400,250,200,30);
        lblphone.setFont(new Font("serif",Font.BOLD,20));
        add(lblphone);

        tffphone = new JTextField();
        tffphone.setBounds(600,250,150,30);
        add(tffphone);

        //Email Id
        JLabel lblemail = new JLabel ("Email Id");
        lblemail.setBounds(50,300,200,30);
        lblemail.setFont(new Font("serif",Font.BOLD,20));
        add(lblemail);

        tfemail = new JTextField();
        tfemail.setBounds(200,300,150,30);
        add(tfemail);

        //Class X
        JLabel lblX = new JLabel ("Class X (%)");
        lblX.setBounds(400,300,200,30);
        lblX.setFont(new Font("serif",Font.BOLD,20));
        add(lblX);

        tffx = new JTextField();
        tffx.setBounds(600,300,150,30);
        add(tffx);

        //Class XII
        JLabel lblxii = new JLabel ("Class XII (%)");
        lblxii.setBounds(400,350,200,30);
        lblxii.setFont(new Font("serif",Font.BOLD,20));
        add(lblxii);

        tffxii = new JTextField();
        tffxii.setBounds(600,350,150,30);
        add(tffxii);

        //Aadhaar
        JLabel lblaadhaar = new JLabel ("Aadhar Number");
        lblaadhaar.setBounds(50,350,200,30);
        lblaadhaar.setFont(new Font("serif",Font.BOLD,20));
        add(lblaadhaar);

        tffaadhaar = new JTextField();
        tffaadhaar.setBounds(200,350,150,30);
        add(tffaadhaar);

        //Course
        JLabel lblcourse = new JLabel ("Course");
        lblcourse.setBounds(50,400,200,30);
        lblcourse.setFont(new Font("serif",Font.BOLD,20));
        add(lblcourse);

        String course[] = {"Btech", "BBA", "BCA", "Bsc", "Msc", "MBA", "MCA", "MCom", "MA", "BA"};
        cbcourse = new JComboBox(course);
        cbcourse.setBounds(200,400,150,30);
        cbcourse.setBackground(Color.WHITE);
        add(cbcourse);

        //Branch
        JLabel lblbranch = new JLabel ("Department");
        lblbranch.setBounds(400,400,200,30);
        lblbranch.setFont(new Font("serif",Font.BOLD,20));
        add(lblbranch);

        String branch[] = {"Computer Science", "Electronics","Electrical", "Mechanical", "Civil", "IT"};
        cbbranch = new JComboBox(branch);
        cbbranch.setBounds(600,400,150,30);
        cbbranch.setBackground(Color.WHITE);
        add(cbbranch);

        submit = new JButton("Submit");
        submit.setBounds(250,550,120,30);
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.addActionListener(this);
        submit.setFont(new Font("Tahoma",Font.BOLD,15));
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450,550,120,30);
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setFont(new Font("Tahoma",Font.BOLD,15));
        add(cancel);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            String name = tfname.getText();
            String fname = tffname.getText();
            String rollno = labelempid.getText();
            String dob = ((JTextField) dcdob.getDateEditor().getUiComponent()).getText();
            String address = tfaddress.getText();
            String phone = tffphone.getText();
            String email = tfemail.getText();
            String x = tffx.getText();
            String xii = tffxii.getText();
            String aadhar = tffaadhaar.getText();
            String course = (String) cbcourse.getSelectedItem();
            String branch = (String) cbbranch.getSelectedItem();

            try {
                String query = "insert into teacher values ('"+name+"', '"+fname+"','"+rollno+"','"+dob+"','"+address+"', '"+phone+"','"+email+"','"+x+"','"+xii+"', '"+aadhar+"','"+course+"','"+branch+"') ";

                Conn con = new Conn();
                con.s.executeUpdate(query);

                JOptionPane.showMessageDialog(null, "Teacher Details Inserted Successfully");
                setVisible(false);

            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
        }
    }
    public static void main(String[] args) {

        new AddTeacher();
    }
}
