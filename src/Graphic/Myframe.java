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
    //private ImageIcon chosen_icon=new ImageIcon();

    private JPanel detailsPanel;
    private ImageIcon repaired;

    private JScrollPane ourScroll;

    public JButton set_distance,Yes_butt,No_butt;

    //private ImageIcon[] picture_arr = new ImageIcon[0];

    public Myframe()
    {
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.setLocationRelativeTo(null);
        frame.setLayout(null);
        frame.getContentPane().setBackground(new Color(45, 88, 115, 255));
        frame.setVisible(true);

    }

    public JFrame getFrame(){
        return frame;
    }
    public ImageIcon repair_icon(ImageIcon icon) {

        Image scaledImage3 = icon.getImage().getScaledInstance(250, 140, Image.SCALE_SMOOTH);
        repaired = new ImageIcon(scaledImage3);
        return repaired;
    }

    public void TestDrive_frame(int real_index,Vehicle[] vehicle_arr)
    {
        frame.setTitle("Test panel");
        JLabel drive_test=new JLabel("Set distance to drive:");
        drive_test.setForeground(Color.black);
        drive_test.setBounds(30,20,300,80);
        drive_test.setFont(subTitle_font);
        frame.add(drive_test);


        text_drive1 = new JTextField("");
        text_drive1.setBounds(30,90,200,30);
        frame.add(text_drive1);



        set_distance=new JButton("Set");
        set_distance.setBounds(85,150,80,40);
        set_distance.setBorder(BorderFactory.createEtchedBorder());
        frame.add(set_distance);



        set_distance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try
                {
                    Integer traveled = Integer.parseInt(text_drive1.getText());
                    vehicle_arr[real_index].Set_travel(traveled);

                }
                catch(Exception exception)
                {
                    JOptionPane.showMessageDialog(null,"Wrong input try numbers :)","Warning",JOptionPane.WARNING_MESSAGE);
                    text_drive1.setText("");
                }
                JOptionPane.showMessageDialog(null,"Traveled distance have been set !","System",JOptionPane.INFORMATION_MESSAGE);
                frame.dispose();
            }
        });



    }


    public void Buy_frame(ImageIcon The_Icon){

        frame.setTitle("Buy vehicle");
        JLabel drive_test=new JLabel("Are you Sure?:");
        drive_test.setForeground(Color.black);
        drive_test.setBounds(40,0,400,90);
        drive_test.setFont(subTitle_font);
        frame.add(drive_test);


        Yes_butt=new JButton("Yes!");
        Yes_butt.setBounds(50,210,70,35);
        Yes_butt.setBorder(BorderFactory.createEtchedBorder());
        Yes_butt.setFocusable(false);
        frame.add(Yes_butt);

        No_butt=new JButton("NO!");
        No_butt.setBounds(150,210,70,35);
        No_butt.setBorder(BorderFactory.createEtchedBorder());
        No_butt.setFocusable(false);
        frame.add(No_butt);




        JLabel myLabel=new JLabel(The_Icon);
        myLabel.setBounds(35,50,180,160);
        myLabel.setBorder(BorderFactory.createEmptyBorder());
        frame.add(myLabel);

        //ImageIcon The_icon=new ImageIcon();



    }

    public void removePanel(){
        if(detailsPanel != null){
            frame.remove(detailsPanel);
        }

    }

    public void Inventory_frame(Vehicle[] vehicle_arr,ImageIcon[] picture_arr) {
        //frame.remove();
        //removePanel();
        //frame.setLayout(null);
        frame.setTitle("Inventory");
        frame.setSize(550, 550);

        detailsPanel=new JPanel();
        //detailsPanel.setBackground(backGroundColor);
        detailsPanel.setLayout(new GridLayout(vehicle_arr.length, 1));

        //clearPanel();
        //mainPanel = new JPanel();
        //mainPanel.setLayout(null);
        //mainPanel.setBounds(0, 0, 700, 700);
        //mainPanel.setBackground(backGroundColor);
        detailsPanel = new JPanel();
        detailsPanel.setBackground(new Color(0, 84, 133, 255));
        detailsPanel.setLayout(new GridLayout(vehicle_arr.length, 1));
        for (int i = 0; i < vehicle_arr.length; i++) {
            JButton temp_button = new JButton(repair_icon(picture_arr[i]));
            //JButton temp_button = addButton(picture_arr[i]);
            temp_button.setPreferredSize(new Dimension(150, 150));
            temp_button.setBackground(new Color(0, 84, 133, 255));
            temp_button.setToolTipText("<html>" + vehicle_arr[i].toString().replace(",", "<br>") + "</html>");
            temp_button.setBorder(BorderFactory.createLineBorder(Color.white,3));
            //final int index = i;
//            temp_button.addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    currentIndex =index;
//                    individual_options(index);
//                }
//            });
            detailsPanel.add(temp_button);
        }
        ourScroll = new JScrollPane(detailsPanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        ourScroll.setBounds(130, 70, 290, 370);
        JLabel inventory_Label=new JLabel("Inventory Report:");
        inventory_Label.setBounds(130,10,400,50);
        inventory_Label.setForeground(Color.WHITE);
        inventory_Label.setFont(new Font("Comic Sans",Font.BOLD,35));
        inventory_Label.setText("<html><u>Inventory Report</u></html>");
        frame.add(inventory_Label);
        frame.add(ourScroll);
        //back1_Button = new JButton("Back");
        //back1_Button.setFont(button_Font);
        //back1_Button.setBounds(30, 600, 80, 30);
        //back1_Button.setBackground(new Color(206, 217, 208));
        //back1_Button.addActionListener(e -> createSecondmain_panel());
        //mainPanel.add(back1_Button);
        //add(mainPanel);
//        frame.addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                Inventory_frame(vehicle_arr,picture_arr);
//                System.out.println("focus on inventory");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//
//            }
//        });


        frame.setVisible(true);
        frame.repaint();


}

}