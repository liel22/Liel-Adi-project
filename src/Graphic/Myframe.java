package Graphic;
import Vehicle.Vehicle;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Myframe
{
    private JFrame frame;
    private JLabel drive_test;
    private Font subTitle_font = new Font("Calibri", Font.PLAIN, 25);

    private JTextField text_drive1;


    public JButton set_distance;

    private ImageIcon[] picture_arr = new ImageIcon[0];

    public Myframe()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.setBackground(new Color(0, 67, 105, 255));
        frame.setVisible(true);

    }

    public void Test_panel(int real_index,Vehicle[] vehicle_arr,JFrame main_f)
    {
        set_distance=new JButton("Set");
        set_distance.setBounds(100,360,100,60);


        text_drive1 = new JTextField("");
        text_drive1.setBounds(100,270,200,30);
        frame.add(text_drive1);

        frame.add(set_distance);
        JLabel drive_test=new JLabel("Set distance to drive:");
        drive_test.setForeground(Color.black);
        drive_test.setBounds(100,200,300,80);
        drive_test.setFont(subTitle_font);
        frame.add(drive_test);


        set_distance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Integer traveled = Integer.parseInt(text_drive1.getText());
                    vehicle_arr[real_index].Set_travel(traveled);
                    JOptionPane.showMessageDialog(null,"Traveled distance have been set !","System",JOptionPane.INFORMATION_MESSAGE);
                    frame.setVisible(false);

                }
                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(null,"Wrong input try numbers :)","Warning",JOptionPane.WARNING_MESSAGE);
                    text_drive1.setText("");
                }
            }
        });



    }



}