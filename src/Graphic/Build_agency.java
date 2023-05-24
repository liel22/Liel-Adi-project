/**
 * Liel forish 316116383
 * Adi meller  316229004
 */

package Graphic;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import Vehicle.*;


import Vehicle.Vehicle;
import javax.swing.border.Border;
import javax.swing.text.AbstractDocument;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;


public class Build_agency extends JFrame {
    private JPanel NORTH_PANEL,EAST_PANEL,WEST_PANEL,SOUTH_PANEL,CENTER_PANEL,dtpanel;
    private JTextField modelText,maxS_Text,maxP_Text,avfut_Text,flagt_Text,avlit_Text,pwr_Text,wheel_Text;
    private JButton jeep_button,tgly_button,sgly_button,bicy_button,amph_button,crui_button,frig_button,startBUT,Exit_but,backToPickVehicle,Add_butt,Rbutt,Cbutt,BuyButt,BuyButt2,Ebicy_button,AirPlane_button,inventoryBut;
    private JButton flag1,flag2,flag3,flag4,flag5,flag6,flag7;
    private JRadioButton IMAGE_RADIO_b1,IMAGE_RADIO_b2;
    private Font bt_font = new Font("Calibri",Font.BOLD,15);;
    private Font subTitle_font = new Font("Calibri",Font.PLAIN,25);
    private JLabel KOTAROT;
    private JFrame myframe2,myframe3;
    private Vehicle[] vehicle_arr=new Vehicle[0];
    private ImageIcon[] picture_arr=new ImageIcon[0];
    private ImageIcon[] Flag_arr=new ImageIcon[7];
    private ImageIcon chosen_icon=new ImageIcon();
    private JButton FinishBut;
    private JScrollPane scrollPane;
    private ImageIcon repaired;
    private int Choice,real_index,our_index,flag=0,flagInventory=0;
    private Font Title_font=new Font("Calibri",Font.BOLD,50);
    Border border= BorderFactory.createLineBorder(Color.cyan,5);;
    boolean x;
    private Myframe inventoryFrame;

    private ImageIcon my_icon, my_icon2, my_icon3, my_icon4, my_icon5, my_icon6, my_icon7;



    /**
     *     The class extends JFrame and creates a user interface with a North, East, West, South, and Center panel.
     *     sets the size, title, location, and icon of the frame. It creates buttons for starting, finishing, and exiting the program.
     *     It also sets a background image on the center panel.
     *     The method createFirstKoteret() is called to create the first "koteret" or title of the agency.
     */
    public Build_agency() {




        this.setTitle("Build Agency");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //this.setResizable(false);
        this.setSize(700,700);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());
        ImageIcon icon = new ImageIcon("icon.png");
        this.setIconImage(icon.getImage());

        NORTH_PANEL=new JPanel();
        EAST_PANEL=new JPanel();
        WEST_PANEL=new JPanel();
        SOUTH_PANEL=new JPanel();
        CENTER_PANEL=new JPanel();




        NORTH_PANEL.setPreferredSize(new Dimension(70,120));
        NORTH_PANEL.setBackground(new Color(0, 67, 105, 255));
        //NORTH_PANEL.setLayout(null);//////////


        CENTER_PANEL.setPreferredSize(new Dimension(100,80));
        CENTER_PANEL.setBackground(new Color(1, 36, 47, 255));
        CENTER_PANEL.setLayout(null);


        SOUTH_PANEL.setPreferredSize(new Dimension(50,100));
        SOUTH_PANEL.setBackground(new Color(0, 67, 105, 255));
        SOUTH_PANEL.setLayout(null);

        border= BorderFactory.createLineBorder(Color.cyan,5);


        startBUT=new JButton("Start");

        startBUT.setBounds(265,15,80,60);
        startBUT.setFocusable(false);
        startBUT.addActionListener(e->pick_vehicleMenu());
        SOUTH_PANEL.add(startBUT);



        FinishBut=new JButton("Finish");
        FinishBut.setBounds(530,15,100,30);
        FinishBut.setVisible(true);
        FinishBut.setFocusable(false);
        FinishBut.addActionListener(e->show_myAgency());
        SOUTH_PANEL.add(FinishBut);



        Exit_but=new JButton("Exit");
        Exit_but.setBounds(530,55,80,30);
        Exit_but.setFocusable(false);
        Exit_but.setFont(bt_font);
        Exit_but.setVisible(true);
        Exit_but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                JOptionPane.showMessageDialog(null,"Good bye","Our agency",JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });
        SOUTH_PANEL.add(Exit_but);


        ImageIcon myicon=new ImageIcon("familyEnter.jpg");
        Image scaled=myicon.getImage().getScaledInstance(280,270,Image.SCALE_SMOOTH);



        JLabel background_photolabel= new JLabel();
        background_photolabel=new JLabel(new ImageIcon(scaled));
        //background_photolabel.setForeground(new Color(134, 0, 255, 139));

        background_photolabel.setBounds(50,-75,550,550);
        background_photolabel.setBorder(BorderFactory.createLineBorder(new Color(93, 173, 164, 255),100));
        CENTER_PANEL.add(background_photolabel);


        this.add(NORTH_PANEL,BorderLayout.NORTH);
        this.add(CENTER_PANEL,BorderLayout.CENTER);
        this.add(SOUTH_PANEL,BorderLayout.SOUTH);



        createFirstKoteret();
        setVisible(true);

    }


    /**
     * sets the font and the color of the text, and adds a border to the label. it adds the label to the NORTH_PANEL panel.
     */
    public void show_firstTitle() {

        KOTAROT.setText("Choose vehicle :");
        KOTAROT.setFont(Title_font);
        KOTAROT.setForeground(new Color(255,255,255));
        KOTAROT.setBorder(border);
        NORTH_PANEL.add(KOTAROT);
    }



    /**
     Displays a menu of vehicles to choose from and allows the user to select a vehicle.
     Once a vehicle is selected, it creates a panel for that vehicle and adds it to the frame.
     The menu consists of buttons for each vehicle, each displaying an image of the vehicle and labeled with its name.
     The buttons are arranged in a 2x2 grid in the center of the frame.
     The method also removes any previously displayed panel and shows the "back" button and the "finish" button.
     */
    public void pick_vehicleMenu(){

        RemovePanel();

        show_First_back_Butt();

        FinishBut.setEnabled(true);
        //////////////My_agency_object.FinishBut.setEnabled(true);

        show_firstTitle();
        startBUT.setVisible(false);

        CENTER_PANEL = new JPanel();
        CENTER_PANEL.setBackground(new Color(22, 77, 101, 255));
        CENTER_PANEL.setLayout(new GridLayout(2,2,10,10));



        jeep_button=new JButton();
        ImageIcon jeepIcon2 = new ImageIcon(getClass().getResource("myPic/jeep2.jpeg"));
        Image img = jeepIcon2.getImage().getScaledInstance(135, 187, Image.SCALE_SMOOTH);
        jeepIcon2 = new ImageIcon(img);
        jeep_button.setIcon(jeepIcon2);
        jeep_button.setText("Jeep");
        jeep_button.setHorizontalTextPosition(JButton.CENTER);
        jeep_button.setVerticalTextPosition(JButton.NORTH);
        jeep_button.setFont(new Font("Comic Sans",Font.BOLD,17));
        jeep_button.addActionListener(e->createJepp_panel());
        CENTER_PANEL.add(jeep_button);




        sgly_button=new JButton();
        sgly_button.setText("SpyGlider");
        ImageIcon spyGIcon2 = new ImageIcon(getClass().getResource("myPic/spyGlider3_new.jpg"));
        img = spyGIcon2.getImage().getScaledInstance(135, 185, Image.SCALE_SMOOTH);
        spyGIcon2 = new ImageIcon(img);
        //sgly_button.setVerticalTextPosition(JLabel.CENTER);
        //sgly_button.setHorizontalTextPosition(JLabel.TOP);
        sgly_button.setIcon(spyGIcon2);
        sgly_button.setHorizontalTextPosition(JButton.CENTER);
        sgly_button.setVerticalTextPosition(JButton.NORTH);
        sgly_button.setFont(new Font("Comic Sans",Font.BOLD,17));
        sgly_button.addActionListener(e->createSpyG_panel());
        CENTER_PANEL.add(sgly_button);




        bicy_button=new JButton();
        ImageIcon ByclIcon1 = new ImageIcon(getClass().getResource("myPic/bicy3.jpg"));
        img = ByclIcon1.getImage().getScaledInstance(135, 185, Image.SCALE_SMOOTH);
        ByclIcon1 = new ImageIcon(img);
        bicy_button.setIcon(ByclIcon1);
        bicy_button.setText("Bicycle");
        bicy_button.setHorizontalTextPosition(JButton.CENTER);
        bicy_button.setVerticalTextPosition(JButton.NORTH);
        bicy_button.setFont(new Font("Comic Sans",Font.BOLD,17));


        bicy_button.addActionListener(e->createByce_panel());
        CENTER_PANEL.add(bicy_button);


        Ebicy_button=new JButton();
        ImageIcon ElecByclIcon1 = new ImageIcon(getClass().getResource("myPic/Ebicycle1.jpg"));
        img = ElecByclIcon1.getImage().getScaledInstance(135, 185, Image.SCALE_SMOOTH);
        ElecByclIcon1 = new ImageIcon(img);
        Ebicy_button.setIcon(ElecByclIcon1);
        Ebicy_button.setText("E-Bicycle");
        Ebicy_button.setHorizontalTextPosition(JButton.CENTER);
        Ebicy_button.setVerticalTextPosition(JButton.NORTH);
        Ebicy_button.setFont(new Font("Comic Sans",Font.BOLD,17));
        Ebicy_button.addActionListener(e->createElectricByce_panel());
        CENTER_PANEL.add(Ebicy_button);


        amph_button=new JButton();
        ImageIcon ampIcon1 = new ImageIcon(getClass().getResource("myPic/amphibious2.jpg"));
        img = ampIcon1.getImage().getScaledInstance(135, 185, Image.SCALE_SMOOTH);
        ampIcon1 = new ImageIcon(img);
        amph_button.setIcon(ampIcon1);
        amph_button.setText("Amphibious");
        amph_button.setHorizontalTextPosition(JButton.CENTER);
        amph_button.setVerticalTextPosition(JButton.NORTH);
        amph_button.setFont(new Font("Comic Sans",Font.BOLD,17));


        amph_button.addActionListener(e->createAmphi_panel());
        CENTER_PANEL.add(amph_button);



        crui_button=new JButton();
        ImageIcon crusIcon2 = new ImageIcon(getClass().getResource("myPic/cru1.jpg"));
        img = crusIcon2.getImage().getScaledInstance(135, 185, Image.SCALE_SMOOTH);
        crusIcon2 = new ImageIcon(img);
        crui_button.setIcon(crusIcon2);
        crui_button.setText("Cruise");
        crui_button.setHorizontalTextPosition(JButton.CENTER);
        crui_button.setVerticalTextPosition(JButton.NORTH);
        crui_button.setFont(new Font("Comic Sans",Font.BOLD,17));

        crui_button.addActionListener(e->createCru_panel());
        CENTER_PANEL.add(crui_button);


        frig_button=new JButton();
        ImageIcon frigacon1 = new ImageIcon(getClass().getResource("myPic/frigate2.jpg"));
        img = frigacon1.getImage().getScaledInstance(135, 185, Image.SCALE_SMOOTH);
        frigacon1 = new ImageIcon(img);
        frig_button.setIcon(frigacon1);
        frig_button.setText("Frigate");
        frig_button.setHorizontalTextPosition(JButton.CENTER);
        frig_button.setVerticalTextPosition(JButton.NORTH);
        frig_button.setFont(new Font("Comic Sans",Font.BOLD,17));
        frig_button.addActionListener(e->createFri_panel());
        CENTER_PANEL.add(frig_button);



        tgly_button=new JButton("ToyGlider");
        ImageIcon toyIcon1 = new ImageIcon(getClass().getResource("myPic/Toyglider3.jpg"));
        img = toyIcon1.getImage().getScaledInstance(135, 185, Image.SCALE_SMOOTH);
        toyIcon1 = new ImageIcon(img);
        tgly_button.setIcon(toyIcon1);

        tgly_button.setText("ToyGlider");
        tgly_button.setHorizontalTextPosition(JButton.CENTER);
        tgly_button.setVerticalTextPosition(JButton.NORTH);
        tgly_button.setFont(new Font("Comic Sans",Font.BOLD,17));
        tgly_button.addActionListener(e->createToyG_panel());
        CENTER_PANEL.add(tgly_button);



        AirPlane_button=new JButton();
        ImageIcon AirPlaneIcon1 = new ImageIcon(getClass().getResource("myPic/Airp1.jpg"));
        img = AirPlaneIcon1.getImage().getScaledInstance(152, 185, Image.SCALE_SMOOTH);
        AirPlaneIcon1 = new ImageIcon(img);
        AirPlane_button.setIcon(AirPlaneIcon1);

        AirPlane_button.setText("AirPlane");
        AirPlane_button.setHorizontalTextPosition(JButton.CENTER);
        AirPlane_button.setVerticalTextPosition(JButton.NORTH);
        AirPlane_button.setFont(new Font("Comic Sans",Font.BOLD,17));
        AirPlane_button.addActionListener(e->createAirPlane_panel());
        CENTER_PANEL.add(AirPlane_button);


        this.add(CENTER_PANEL,BorderLayout.CENTER);
        this.add(NORTH_PANEL,BorderLayout.NORTH);
        this.add(SOUTH_PANEL,BorderLayout.SOUTH);


        this.repaint();
        this.setVisible(true);


    }



    /**
     * This method creates a file chooser dialog box to allow the user to select an image file from their local system. If the user selects a file and clicks "Open"
     * , the image file is loaded into a BufferedImage object and used to create a new ImageIcon object.
     * The ImageIcon object is then assigned to the "chosen_icon" variable.
     */
    public void CreateUpdatefILE_Chooser() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION)
        {

            File selectedFile = fileChooser.getSelectedFile();
            try {
                BufferedImage image = ImageIO.read(selectedFile);
                chosen_icon = new ImageIcon(image);
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
    }



    /**
     This method adds three images to the panel as buttons.
     When a button is clicked, the corresponding image is selected as the chosen_icon.
     A message dialog box is displayed showing the selected image.
     The selected button is highlighted with a border while the others are unselected.
     The buttons are added to the CENTER_PANEL.
     @param str1 String representing the file path of the first image
     @param str2 String representing the file path of the second image
     @param str3 String representing the file path of the third image
     */
    public void add_3Imagetopanel(String str1, String str2, String str3) {

        ImageIcon icon1 = new ImageIcon(getClass().getResource(str1));
        Image scaledImage1 = icon1.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH);
        icon1 = new ImageIcon(scaledImage1);

        ImageIcon icon2 = new ImageIcon(getClass().getResource(str2));
        Image scaledImage2 = icon2.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH);
        icon2 = new ImageIcon(scaledImage2);

        ImageIcon icon3 = new ImageIcon(getClass().getResource(str3));
        Image scaledImage3 = icon3.getImage().getScaledInstance(130, 100, Image.SCALE_SMOOTH);
        icon3 = new ImageIcon(scaledImage3);

        JButton pic_Button1 = new JButton(icon1);
        pic_Button1.setBounds(500, 80, 120, 100);
        ImageIcon finalIcon = icon1;




        JButton pic_Button2 = new JButton(icon2);
        pic_Button2.setBounds(500, 200, 120, 100);
        ImageIcon finalIcon2 = icon2;




        JButton pic_Button3 = new JButton(icon3);
        pic_Button3.setBounds(500, 320, 120, 100);
        ImageIcon finalIcon3 = icon3;




        pic_Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosen_icon = finalIcon;
                JLabel mylabel=new JLabel(chosen_icon);
                JOptionPane.showOptionDialog(null,"Chosen style","Info", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,chosen_icon,null,0);
                pic_Button1.setBorder(border);

                pic_Button2.setBorder(BorderFactory.createEmptyBorder());
                pic_Button3.setBorder(BorderFactory.createEmptyBorder());



            }
        });



        pic_Button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosen_icon = finalIcon2;
                JLabel mylabel=new JLabel(chosen_icon);
                JOptionPane.showOptionDialog(null,"Chosen style","Info", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,chosen_icon,null,0);
                pic_Button2.setBorder(border);

                pic_Button1.setBorder(BorderFactory.createEmptyBorder());
                pic_Button3.setBorder(BorderFactory.createEmptyBorder());


            }
        });


        pic_Button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                chosen_icon = finalIcon3;
                JLabel mylabel=new JLabel(chosen_icon);
                JOptionPane.showOptionDialog(null,"Chosen style","Info", JOptionPane.DEFAULT_OPTION,JOptionPane.INFORMATION_MESSAGE,chosen_icon,null,0);
                pic_Button3.setBorder(border);

                pic_Button1.setBorder(BorderFactory.createEmptyBorder());
                pic_Button2.setBorder(BorderFactory.createEmptyBorder());

            }
        });

        pic_Button1.setBackground(Color.DARK_GRAY);
        pic_Button2.setBackground(Color.DARK_GRAY);
        pic_Button3.setBackground(Color.DARK_GRAY);

        CENTER_PANEL.add(pic_Button1);
        CENTER_PANEL.add(pic_Button2);
        CENTER_PANEL.add(pic_Button3);

    }



    /**
     Creates a "Add" button with specified bounds, font, and background color. When the button is clicked,
     it checks the value of our_index and creates a vehicle object based on it. Then, it adds the vehicle's picture
     and hides the "Add" button. Finally, it calls the pick_vehicleMenu() method to go back to the vehicle selection menu.
     */
    public void show_add_butt(){
        Add_butt=new JButton("Add");
        Add_butt.setBounds(265,15,80,60);
        Add_butt.setFocusable(false);
        Add_butt.setBackground(new Color(255, 255, 255, 255));
        Add_butt.setFont(subTitle_font);
        Add_butt.setEnabled(true);
        Add_butt.setVisible(true);
        SOUTH_PANEL.add(Add_butt);

        Add_butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(our_index==1){
                    System.out.println("im adding jeep");////////////////////////
                    Jeep jeep=new Jeep(modelText.getText(),Integer.parseInt(maxS_Text.getText()),Float.parseFloat(avfut_Text.getText()),Float.parseFloat(avlit_Text.getText()));
                    add_vehicle_pic(jeep,chosen_icon);////////////////////////
                    System.out.println(" added jeep");/////////////////////////
                    //Add_butt.setEnabled(true);
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();

                }
                if(our_index==2){
                    System.out.println("im adding SpyGlider");////////////////////////
                    SpyGlider sgly=new SpyGlider(pwr_Text.getText());
                    add_vehicle_pic(sgly,chosen_icon);////////////////////////
                    System.out.println(" added SpyGlider");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();


                }
                if(our_index==3){
                    System.out.println("im adding bicy");////////////////////////
                    Regular_Bicycle bicy=new Regular_Bicycle(modelText.getText(),Integer.parseInt(maxP_Text.getText()),Integer.parseInt(maxS_Text.getText()),x);
                    add_vehicle_pic(bicy,chosen_icon);////////////////////////
                    System.out.println(" added bicy");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();
                    //createFirstmain_panel();

                }
                if(our_index==4){
                    System.out.println("im adding amph");////////////////////////
                    Amphibious amph=new Amphibious(modelText.getText(),Integer.parseInt(maxP_Text.getText()),Integer.parseInt(maxS_Text.getText()),Integer.parseInt(wheel_Text.getText()),x,flagt_Text.getText(),Float.parseFloat(avfut_Text.getText()),Float.parseFloat(avlit_Text.getText()));
                    add_vehicle_pic(amph,chosen_icon);////////////////////////
                    System.out.println(" added amph");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();
                    //createFirstmain_panel();
                }
                if(our_index==5){
                    System.out.println("im adding cruise");////////////////////////
                    Cruise_Ship cruise=new Cruise_Ship(modelText.getText(),Integer.parseInt(maxS_Text.getText()),Integer.parseInt(maxP_Text.getText()),flagt_Text.getText(),Float.parseFloat(avfut_Text.getText()),Float.parseFloat(avlit_Text.getText()));
                    add_vehicle_pic(cruise,chosen_icon);////////////////////////
                    System.out.println(" added cruise");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();
                    //createFirstmain_panel();
                }
                if(our_index==6){
                    System.out.println("im adding Frigate");////////////////////////
                    Frigate frigate=new Frigate(modelText.getText(),Integer.parseInt(maxS_Text.getText()),Integer.parseInt(maxP_Text.getText()),x);
                    add_vehicle_pic(frigate,chosen_icon);////////////////////////
                    System.out.println(" added frigate");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();
                    //createFirstmain_panel();

                }
                if(our_index==7){
                    System.out.println("im adding tgly");////////////////////////
                    ToyGlider tgly=new ToyGlider();
                    add_vehicle_pic(tgly,chosen_icon);
                    System.out.println(" added tgly");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();

                }
                if(our_index==8){
                    System.out.println("im adding Electric bycle");////////////////////////
                    Electric_Bicyle ebycle=new Electric_Bicyle(modelText.getText(),Integer.parseInt(maxP_Text.getText()),Integer.parseInt(maxS_Text.getText()),x,Float.parseFloat(avlit_Text.getText()));
                    add_vehicle_pic(ebycle,chosen_icon);
                    System.out.println(" added Electric bycle");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();

                }
                if(our_index==9){
                    System.out.println("im adding Air_plane");////////////////////////
                    Air_plane airPlane1=new Air_plane(modelText.getText(),Integer.parseInt(maxP_Text.getText()),Integer.parseInt(maxS_Text.getText()),Integer.parseInt(wheel_Text.getText()),x,flagt_Text.getText(),Float.parseFloat(avfut_Text.getText()),Float.parseFloat(avlit_Text.getText()));
                    add_vehicle_pic(airPlane1,chosen_icon);////////////////////////
                    System.out.println(" added Air_plane");/////////////////////////
                    Add_butt.setVisible(false);
                    pick_vehicleMenu();
                    //createFirstmain_panel();
                }



            }
        });



    }



    /**
     * This method creates a JButton and adds it to the SOUTH_PANEL.
     * The JButton is used to go back to the vehicle selection menu.
     */
    public void show_First_back_Butt(){

        backToPickVehicle=new JButton("Back");
        backToPickVehicle.setBounds(20,15,85,75);
        ImageIcon backIcon = new ImageIcon(getClass().getResource("myPic/HouseIcon.png"));
        Image img8 = backIcon.getImage().getScaledInstance(45, 45, Image.SCALE_SMOOTH);
        backIcon = new ImageIcon(img8);
        backToPickVehicle.setIcon(backIcon);
        backToPickVehicle.setFocusable(false);
        backToPickVehicle.setVisible(true);

        backToPickVehicle.setVerticalTextPosition(JButton.BOTTOM);
        backToPickVehicle.setHorizontalTextPosition(JButton.CENTER);
        backToPickVehicle.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //Add_butt.setVisible(false);
                //SOUTH_PANEL.add(Add_butt);
                //pick_vehicleMenu();

                //new Build_agency();

                pick_vehicleMenu();

            }
        });
        SOUTH_PANEL.add(backToPickVehicle);



    }



    /**
     * clear panels
     */
    public void RemovePanel(){

        if (CENTER_PANEL != null)
            this.remove(CENTER_PANEL);
    }



    /**
     * eating two temporary arrays with sizes one more than the current arrays, copying the contents of the current arrays to the temporary arrays,
     * adding the new Vehicle and ImageIcon objects to the end of their respective temporary arrays,
     * and then setting the current arrays to the temporary arrays.
     */
    public void add_vehicle_pic(Vehicle vehicle, ImageIcon pic){

        Vehicle[] vetmparr=new Vehicle[vehicle_arr.length+1];
        ImageIcon[] pictmparr=new ImageIcon[picture_arr.length+1];
        System.arraycopy(vehicle_arr,0,vetmparr,0,vehicle_arr.length);
        System.arraycopy(picture_arr,0,pictmparr,0,picture_arr.length);
        vetmparr[vetmparr.length-1]=vehicle;
        pictmparr[pictmparr.length-1]=pic;
        vehicle_arr=vetmparr;
        picture_arr=pictmparr;
        System.out.println("really adding to array now!");
    }


    /**
     * his method creates a JLabel with a welcome message and adds it to the NORTH_PANEL
     */
    public void createFirstKoteret(){
        KOTAROT=new JLabel("Welcome to the agency!");
        KOTAROT.setFont(Title_font);
        KOTAROT.setForeground(new Color(255,255,255));
        KOTAROT.setBorder(border);

        NORTH_PANEL.add(KOTAROT);
    }




    /**
     Creates a panel for our object vehicle data.
     Removes any existing panel before creating a new one.
     Disables the "Finish" button.
     Sets the index to 1 for jeep to create action-lisc for each reletive add butt
     Sets the title to "Create Jeep:" and uses a custom font for it.
     Displays three images of Jeeps on the panel.
     Displays a label to choose the Jeep style.
     Creates input fields to enter the model name, maximum speed, average fuel consumption, and average life of the Jeep.
     Displays a label and a button to upload a photo of the Jeep.
     Displays the "Add" button to add the Jeep to the list.
     Adds all the created components to the panel and adds the panel to the center of the frame.
     */
    public void createJepp_panel() {

        RemovePanel();




        FinishBut.setEnabled(false);
        our_index=1;
        CENTER_PANEL=new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0,0,700,700);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));
        KOTAROT.setText("Create Jeep:");
        KOTAROT.setFont(Title_font);



        add_3Imagetopanel("myPic/jeep2.jpeg","myPic/jeep3.jpg","myPic/jeep_2.jpg");


        JLabel choose =new JLabel("Choose jeep style:");
        choose.setBounds(400,30,300,30);
        choose.setForeground(Color.WHITE);
        choose.setFont(subTitle_font);

        dtpanel =new JPanel();
        dtpanel.setLayout(null);
        dtpanel.setBounds(15,0,300,500);
        dtpanel.setBackground(new Color(0, 67, 105,255));



        createModelName(dtpanel,50,80);
        createMaxSpeed(dtpanel,110,140);
        createavfu(dtpanel,170,200);
        createavli(dtpanel,245,270);
        dtpanel.setVisible(true);
        CENTER_PANEL.add(dtpanel);


        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,315,150,30);
        CENTER_PANEL.add(uploadlabel);

        JButton upload=new JButton("Upload");
        upload.setFont(bt_font);
        upload.setBounds(340,350,135,30);
        upload.setBackground(Color.WHITE);
        upload.addActionListener(e->CreateUpdatefILE_Chooser());
        CENTER_PANEL.add(upload);


        show_add_butt();
        CENTER_PANEL.add(choose);

        //Myframe frame=new Myframe(NORTH_PANEL,CENTER_PANEL,SOUTH_PANEL);
        //frame.frame.setVisible(true);
        this.add(CENTER_PANEL,BorderLayout.CENTER);


    }
    public void createSpyG_panel() {


        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=2;

        CENTER_PANEL=new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0,0,700,700);
        CENTER_PANEL.setBackground(new Color(0, 58, 82));


        add_3Imagetopanel("myPic/spyGlider1_new.jpg","myPic/spyGlider2_new.jpg","myPic/spyGlider3_new.jpg");

        KOTAROT.setText("Create Spy Glider: ");
        createPowerSource(CENTER_PANEL,170,200);


        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,315,150,30);
        CENTER_PANEL.add(uploadlabel);

        JButton upload=new JButton("Upload");
        upload.setFont(bt_font);
        upload.setBounds(340,350,135,30);
        upload.setBackground(Color.WHITE);
        upload.addActionListener(e->CreateUpdatefILE_Chooser());
        CENTER_PANEL.add(upload);



        show_add_butt();

        CENTER_PANEL.add(upload);
        this.add(CENTER_PANEL,BorderLayout.CENTER);
    }

    public void createByce_panel(){

        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=3;

        CENTER_PANEL=new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));
        //CENTER_PANEL=new JPanel();
        //panel.setLayout(null);
        dtpanel =new JPanel();
        dtpanel.setLayout(null);
        dtpanel.setBounds(15,0,300,500);
        dtpanel.setBackground(new Color(0, 67, 105, 255));




        CENTER_PANEL.setBounds(0,0,700,700);
        add_3Imagetopanel("myPic/bicy1.jpg","myPic/bicy2.jpg","myPic/bicy3.jpg");

        //dtpanel.add(top_label1);

        this.add(CENTER_PANEL);

        KOTAROT.setText("Create Bicycle : ");


        /////////////////////
        createModelName(dtpanel,30,60);
        createMaxPessnger(dtpanel,100,140);
        createMaxSpeed(dtpanel,175,205);
        createRoadType(dtpanel,240);
        ButtonGroup group = new ButtonGroup();


        IMAGE_RADIO_b1 =new JRadioButton("Paved");
        IMAGE_RADIO_b1.setBackground(new Color(0, 67, 105, 255));
        IMAGE_RADIO_b1.setFocusable(false);
        IMAGE_RADIO_b2 =new JRadioButton("Dirt");
        IMAGE_RADIO_b2.setFocusable(false);

        IMAGE_RADIO_b1.setBounds(30,275,200,15);
        IMAGE_RADIO_b2.setBounds(30,305,200,15);
        IMAGE_RADIO_b1.setFont(bt_font);
        IMAGE_RADIO_b2.setFont(bt_font);
        IMAGE_RADIO_b1.setBackground(Color.DARK_GRAY);
        IMAGE_RADIO_b2.setBackground(Color.DARK_GRAY);
        IMAGE_RADIO_b1.setForeground(Color.WHITE);
        IMAGE_RADIO_b2.setForeground(Color.WHITE);
        IMAGE_RADIO_b1.addActionListener(e -> x=true);
        IMAGE_RADIO_b2.addActionListener(e -> x=false);
        group.add(IMAGE_RADIO_b1);
        group.add(IMAGE_RADIO_b2);
        dtpanel.add(IMAGE_RADIO_b1);
        dtpanel.add(IMAGE_RADIO_b2);
        IMAGE_RADIO_b1.addActionListener(e -> x=true);
        IMAGE_RADIO_b2.addActionListener(e -> x=false);

        dtpanel.setVisible(true);
        CENTER_PANEL.add(dtpanel);



        JLabel choose =new JLabel("Choose Bicycle style:");
        choose.setBounds(400,30,300,30);
        choose.setForeground(Color.WHITE);
        choose.setFont(subTitle_font);



        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,315,150,30);
        CENTER_PANEL.add(uploadlabel);

        JButton upload=new JButton("Upload");
        upload.setFont(bt_font);
        upload.setBounds(340,350,135,30);
        upload.setBackground(Color.WHITE);
        upload.addActionListener(e->CreateUpdatefILE_Chooser());

        CENTER_PANEL.add(upload);

        show_add_butt();

        CENTER_PANEL.add(upload);
        CENTER_PANEL.add(choose);

        this.add(CENTER_PANEL,BorderLayout.CENTER);





    }

    public void createAmphi_panel(){

        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=4;
        CENTER_PANEL = new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0, 0, 700, 700);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));

        add_3Imagetopanel("myPic/amphibious1.jpg","myPic/amphibious2.jpg","myPic/amphibious3.jpg");

        dtpanel=new JPanel();
        dtpanel.setLayout(null);
        dtpanel.setBounds(0,0,285,500);
        dtpanel.setBackground(new Color(0, 67, 105, 255));

        createModelName(dtpanel,20,55);
        createMaxSpeed(dtpanel,85,105);
        createMaxPessnger(dtpanel,140,170);

        JLabel winddl =new JLabel("Wind Direction:");
        winddl.setFont(subTitle_font);
        winddl.setForeground(Color.WHITE);
        winddl.setBounds(280,140,200,30);

        CENTER_PANEL.add(winddl);
        ButtonGroup group = new ButtonGroup();
        IMAGE_RADIO_b1=new JRadioButton("With");
        IMAGE_RADIO_b2=new JRadioButton("Against");

        IMAGE_RADIO_b1.setBounds(290,170,200,15);
        IMAGE_RADIO_b2.setBounds(290,190,200,15);
        IMAGE_RADIO_b1.setFont(bt_font);
        IMAGE_RADIO_b2.setFont(bt_font);
        IMAGE_RADIO_b1.setBackground(new Color(0, 67, 105, 255));
        IMAGE_RADIO_b2.setBackground(new Color(0, 67, 105, 255));
        IMAGE_RADIO_b1.setForeground(Color.WHITE);
        IMAGE_RADIO_b2.setForeground(Color.WHITE);
        group.add(IMAGE_RADIO_b1);
        group.add(IMAGE_RADIO_b2);
        CENTER_PANEL.add(IMAGE_RADIO_b1);
        CENTER_PANEL.add(IMAGE_RADIO_b2);

        IMAGE_RADIO_b1.addActionListener(e -> x=true);
        IMAGE_RADIO_b2.addActionListener(e -> x=false);
        createFlag(dtpanel,250,280);
        createavfu(dtpanel,310,350);
        createavli(dtpanel,380,410);
        createWheel(dtpanel,200,220);

        //dtpanel.setBackground(Color.black);
        dtpanel.setVisible(true);

        CENTER_PANEL.add(dtpanel);



        KOTAROT.setText("Create Amphi : ");


        JLabel styleL = new JLabel("Choose Amphibious Vehicle style:");
        styleL.setBounds(480,30,300,30);
        styleL.setForeground(Color.WHITE);
        styleL.setFont(subTitle_font);

        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,370,300,30);
        CENTER_PANEL.add(uploadlabel);




        JButton uploadbut = new JButton("Upload");
        uploadbut.setFont(bt_font);
        uploadbut.setBounds(340,400,135,30);
        uploadbut.setBackground(Color.WHITE);
        //final_photo = new ImageIcon();
        uploadbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                uploadbut.setBorder(border);
                CreateUpdatefILE_Chooser();
            }
        });


        CENTER_PANEL.add(uploadbut);

        show_add_butt();

        CENTER_PANEL.add(uploadbut);
        CENTER_PANEL.add(styleL);

        JButton add_Amph = new JButton("Add");
        add_Amph.setFont(bt_font);
        add_Amph.setBounds(300, 580, 100, 50);
        add_Amph.setBackground(new Color(48, 186, 83));
        add_Amph.setForeground(Color.WHITE);
        //creat_Backbutton();
        //CENTER_PANEL.add(add_Amph);
        //setAdd_Amph()

        this.add(CENTER_PANEL,BorderLayout.CENTER);

    }
    public void createCru_panel(){
        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=5;
        CENTER_PANEL=new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0,0,700,700);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));
        KOTAROT.setText("Create Cruise:");
        KOTAROT.setFont(Title_font);

        add_3Imagetopanel("myPic/cruise1.jpg", "myPic/cruise2.jpg", "myPic/one_piece.jpg");

        JLabel choose =new JLabel("Choose Cruise style:");
        choose.setBounds(400,30,300,30);
        choose.setForeground(Color.WHITE);
        choose.setFont(subTitle_font);

        dtpanel =new JPanel();
        dtpanel.setLayout(null);
        dtpanel.setBounds(15,0,300,500);
        dtpanel.setBackground(new Color(0, 58, 82));

        createModelName(dtpanel, 5, 35);
        createMaxSpeed(dtpanel, 70, 100);
        createMaxPessnger(dtpanel, 135, 160);
        createavfu(dtpanel, 190, 220);
        createavli(dtpanel, 260, 280);
        createFlag(dtpanel, 312, 340);
        dtpanel.setVisible(true);
        CENTER_PANEL.add(dtpanel);


        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,315,150,30);
        CENTER_PANEL.add(uploadlabel);

        JButton upload=new JButton("Upload");
        upload.setFont(bt_font);
        upload.setBounds(340,350,135,30);
        upload.setBackground(Color.WHITE);
        upload.addActionListener(e->CreateUpdatefILE_Chooser());
        CENTER_PANEL.add(upload);




        show_add_butt();

        CENTER_PANEL.add(choose);

        this.add(CENTER_PANEL,BorderLayout.CENTER);
    }
    public void createFri_panel(){
        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=6;
        CENTER_PANEL=new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0,0,700,700);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));
        add_3Imagetopanel("myPic/frigate1.jpg","myPic/frigate2.jpg","myPic/frigate3.jpg");

        KOTAROT.setText("Create Frigate : ");




        dtpanel =new JPanel();
        dtpanel.setLayout(null);
        dtpanel.setBounds(15,0,300,500);
        dtpanel.setBackground(new Color(0, 67, 105, 255));
        createModelName(dtpanel, 5, 35);
        createMaxSpeed(dtpanel, 70, 100);
        createMaxPessnger(dtpanel, 135, 160);






        JLabel winddl =new JLabel("Wind Direction:");
        winddl.setFont(subTitle_font);
        winddl.setForeground(Color.WHITE);
        winddl.setBounds(30,190,200,30);
        dtpanel.add(winddl);

        ButtonGroup group = new ButtonGroup();
        JRadioButton temp_radio=new JRadioButton("with");
        JRadioButton temp_radio2=new JRadioButton("Against");
        temp_radio.setBounds(30,220,200,15);
        temp_radio2.setBounds(30,250,200,15);
        temp_radio.setFont(bt_font);
        temp_radio2.setFont(bt_font);
        temp_radio.setBackground(Color.DARK_GRAY);
        temp_radio2.setBackground(Color.DARK_GRAY);
        temp_radio.setForeground(Color.WHITE);
        temp_radio2.setForeground(Color.WHITE);
        group.add(temp_radio);
        group.add(temp_radio2);
        dtpanel.add(temp_radio);
        dtpanel.add(temp_radio2);

        temp_radio.addActionListener(e -> x=true);
        temp_radio2.addActionListener(e -> x=false);


        dtpanel.setVisible(true);
        CENTER_PANEL.add(dtpanel);


        JLabel styleL =new JLabel("Choose Frigate style:");
        styleL.setBounds(400,30,300,30);
        styleL.setForeground(Color.WHITE);
        styleL.setFont(subTitle_font);


        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,375,150,30);
        CENTER_PANEL.add(uploadlabel);





        JButton uploadbut = new JButton("Upload");
        uploadbut.setFont(bt_font);
        uploadbut.setBounds(340,400,135,30);
        uploadbut.setBackground(Color.WHITE);
        uploadbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                uploadbut.setBorder(border);
                CreateUpdatefILE_Chooser();
            }
        });

        show_add_butt();
        CENTER_PANEL.add(uploadbut);
        CENTER_PANEL.add(styleL);
        this.add(CENTER_PANEL,BorderLayout.CENTER);



    }
    public void createToyG_panel(){
        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=7;
        CENTER_PANEL=new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0,0,700,700);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));
        add_3Imagetopanel("myPic/toyGlider1.jpg","myPic/toyGlider2.jpg","myPic/ToyGlider3.jpg");

        KOTAROT.setText("Create ToyGlider : ");

        JLabel choose =new JLabel("Choose Frigate style:");
        choose.setBounds(400,30,300,30);
        choose.setForeground(Color.WHITE);
        choose.setFont(subTitle_font);




        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,375,150,30);
        CENTER_PANEL.add(uploadlabel);




        JButton uploadbut = new JButton("Upload");
        uploadbut.setFont(bt_font);
        uploadbut.setBounds(340,400,135,30);
        uploadbut.setBackground(Color.WHITE);
        //final_photo = new ImageIcon();
        uploadbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                uploadbut.setBorder(border);
                CreateUpdatefILE_Chooser();
            }
        });
        CENTER_PANEL.add(uploadbut);

        CENTER_PANEL.add(uploadbut);
        CENTER_PANEL.add(choose);
        JButton add_Tgly = new JButton("Add");
        add_Tgly.setFont(bt_font);
        add_Tgly.setBounds(300,580,100,50);
        add_Tgly.setBackground(new Color(48, 186, 83));
        add_Tgly.setForeground(Color.WHITE);





        show_add_butt();

        CENTER_PANEL.add(add_Tgly);

        this.add(CENTER_PANEL,BorderLayout.CENTER);

    }

    public void createElectricByce_panel(){

        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=8;

        CENTER_PANEL=new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));
        //CENTER_PANEL=new JPanel();
        //panel.setLayout(null);
        dtpanel =new JPanel();
        dtpanel.setLayout(null);
        dtpanel.setBounds(15,0,300,500);
        dtpanel.setBackground(new Color(0, 67, 105, 255));




        CENTER_PANEL.setBounds(0,0,700,700);
        add_3Imagetopanel("myPic/Ebicycle1.jpg","myPic/Ebycle.jpg","myPic/Ebycle2.jpg");

        //dtpanel.add(top_label1);

        this.add(CENTER_PANEL);

        KOTAROT.setText("Create EBicycle : ");


        /////////////////////
        createModelName(dtpanel,30,60);
        createMaxPessnger(dtpanel,100,140);
        createMaxSpeed(dtpanel,175,205);
        createRoadType(dtpanel,240);
        //createavfu(dtpanel,340,380);
        createavli(dtpanel,340,380);

        ButtonGroup group = new ButtonGroup();


        IMAGE_RADIO_b1 =new JRadioButton("Paved");
        IMAGE_RADIO_b1.setBackground(new Color(0, 67, 105, 255));
        IMAGE_RADIO_b1.setFocusable(false);
        IMAGE_RADIO_b2 =new JRadioButton("Dirt");
        IMAGE_RADIO_b2.setFocusable(false);

        IMAGE_RADIO_b1.setBounds(30,275,200,15);
        IMAGE_RADIO_b2.setBounds(30,305,200,15);
        IMAGE_RADIO_b1.setFont(bt_font);
        IMAGE_RADIO_b2.setFont(bt_font);
        IMAGE_RADIO_b1.setBackground(Color.DARK_GRAY);
        IMAGE_RADIO_b2.setBackground(Color.DARK_GRAY);
        IMAGE_RADIO_b1.setForeground(Color.WHITE);
        IMAGE_RADIO_b2.setForeground(Color.WHITE);
        IMAGE_RADIO_b1.addActionListener(e -> x=true);
        IMAGE_RADIO_b2.addActionListener(e -> x=false);
        group.add(IMAGE_RADIO_b1);
        group.add(IMAGE_RADIO_b2);
        dtpanel.add(IMAGE_RADIO_b1);
        dtpanel.add(IMAGE_RADIO_b2);
        IMAGE_RADIO_b1.addActionListener(e -> x=true);
        IMAGE_RADIO_b2.addActionListener(e -> x=false);

        dtpanel.setVisible(true);
        CENTER_PANEL.add(dtpanel);



        JLabel choose =new JLabel("Choose Bicycle style:");
        choose.setBounds(400,30,300,30);
        choose.setForeground(Color.WHITE);
        choose.setFont(subTitle_font);



        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,315,150,30);
        CENTER_PANEL.add(uploadlabel);

        JButton upload=new JButton("Upload");
        upload.setFont(bt_font);
        upload.setBounds(340,350,135,30);
        upload.setBackground(Color.WHITE);
        upload.addActionListener(e->CreateUpdatefILE_Chooser());

        CENTER_PANEL.add(upload);

        show_add_butt();

        CENTER_PANEL.add(upload);
        CENTER_PANEL.add(choose);

        this.add(CENTER_PANEL,BorderLayout.CENTER);





    }

    public void createAirPlane_panel(){

        RemovePanel();
        FinishBut.setEnabled(false);
        our_index=9;
        CENTER_PANEL = new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0, 0, 700, 700);
        CENTER_PANEL.setBackground(new Color(0, 67, 105, 255));

        KOTAROT.setText("Create Hybrid-AirPlane: ");

        add_3Imagetopanel("myPic/Airp1.jpg","myPic/Airp2.jpg","myPic/Airp3.jpg");

        dtpanel=new JPanel();
        dtpanel.setLayout(null);
        dtpanel.setBounds(0,0,285,500);
        dtpanel.setBackground(new Color(0, 67, 105, 255));

        createModelName(dtpanel,20,55);
        createMaxSpeed(dtpanel,85,105);
        createMaxPessnger(dtpanel,140,170);

        JLabel winddl =new JLabel("Wind Direction:");
        winddl.setFont(subTitle_font);
        winddl.setForeground(Color.WHITE);
        winddl.setBounds(280,140,200,30);

        CENTER_PANEL.add(winddl);
        ButtonGroup group = new ButtonGroup();
        IMAGE_RADIO_b1=new JRadioButton("With");
        IMAGE_RADIO_b2=new JRadioButton("Against");

        IMAGE_RADIO_b1.setBounds(290,170,200,15);
        IMAGE_RADIO_b2.setBounds(290,190,200,15);
        IMAGE_RADIO_b1.setFont(bt_font);
        IMAGE_RADIO_b2.setFont(bt_font);
        IMAGE_RADIO_b1.setBackground(new Color(0, 67, 105, 255));
        IMAGE_RADIO_b2.setBackground(new Color(0, 67, 105, 255));
        IMAGE_RADIO_b1.setForeground(Color.WHITE);
        IMAGE_RADIO_b2.setForeground(Color.WHITE);
        group.add(IMAGE_RADIO_b1);
        group.add(IMAGE_RADIO_b2);
        CENTER_PANEL.add(IMAGE_RADIO_b1);
        CENTER_PANEL.add(IMAGE_RADIO_b2);

        IMAGE_RADIO_b1.addActionListener(e -> x=true);
        IMAGE_RADIO_b2.addActionListener(e -> x=false);
        createFlag(dtpanel,250,280);
        createavfu(dtpanel,310,350);
        createavli(dtpanel,380,410);
        createWheel(dtpanel,200,220);

        //dtpanel.setBackground(Color.black);
        dtpanel.setVisible(true);

        CENTER_PANEL.add(dtpanel);



        JLabel styleL = new JLabel("Choose Air plane style:");
        styleL.setBounds(480,30,300,30);
        styleL.setForeground(Color.WHITE);
        styleL.setFont(subTitle_font);

        JLabel uploadlabel=new JLabel("Upload your photo:");
        uploadlabel.setFont(bt_font);
        uploadlabel.setForeground(Color.WHITE);
        uploadlabel.setBounds(340,370,300,30);
        CENTER_PANEL.add(uploadlabel);




        JButton uploadbut = new JButton("Upload");
        uploadbut.setFont(bt_font);
        uploadbut.setBounds(340,400,135,30);
        uploadbut.setBackground(Color.WHITE);
        //final_photo = new ImageIcon();
        uploadbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                uploadbut.setBorder(border);
                CreateUpdatefILE_Chooser();
            }
        });


        CENTER_PANEL.add(uploadbut);

        show_add_butt();

        CENTER_PANEL.add(uploadbut);
        CENTER_PANEL.add(styleL);

        JButton add_Amph = new JButton("Add");
        add_Amph.setFont(bt_font);
        add_Amph.setBounds(300, 580, 100, 50);
        add_Amph.setBackground(new Color(48, 186, 83));
        add_Amph.setForeground(Color.WHITE);
        //creat_Backbutton();
        //CENTER_PANEL.add(add_Amph);
        //setAdd_Amph()

        this.add(CENTER_PANEL,BorderLayout.CENTER);

    }




    /**
     Creates a label and a text field for entering the model name,max speed,max pass,flags,road type and more of every reletive vehicle.
     Creates a text field for entering the model name and sets its position and size.
     Restricts the input of the text field to accept only string values.
     Adds the text field to the specified panel.
     @param tp the JPanel to which the label and text field are added
     @param yl the y-coordinate position of the label
     @param yt the y-coordinate position of the text field
     */
    public void createModelName(JPanel tp,int yl,int yt){
        JLabel namelb = new JLabel("Model Name:");
        namelb.setFont(subTitle_font);
        namelb.setForeground(Color.WHITE);
        namelb.setBounds(30,yl,200,30);
        tp.add(namelb);
        modelText=new JTextField(1);
        modelText.setBounds(30,yt,200,30);
        onlyStringType(modelText);
        tp.add(modelText);
    }
    public void createMaxSpeed(JPanel x,int y1,int y2){
        JLabel maxsplb=new JLabel("Max Speed:");
        maxsplb.setFont(subTitle_font);
        maxsplb.setForeground(Color.WHITE);
        maxsplb.setBounds(30,y1,200,30);
        x.add(maxsplb);
        maxS_Text=new JTextField(1);
        maxS_Text.setBounds(30,y2,200,30);
        onlyIntType(maxS_Text);
        x.add(maxS_Text);
    }
    public void createMaxPessnger(JPanel x,int y1,int y2){
        JLabel maxplb =new JLabel("Max Pessnger: ");
        maxplb.setFont(subTitle_font);
        maxplb.setForeground(Color.WHITE);
        maxplb.setBounds(30,y1,200,30);
        x.add(maxplb);
        maxP_Text =new JTextField(1);
        maxP_Text.setBounds(30,y2,200,30);
        onlyIntType(maxP_Text);
        x.add(maxP_Text);
    }
    public void createavfu(JPanel x,int y1,int y2){
        JLabel avfulb=new JLabel("Average fuel use:");
        avfulb.setFont(subTitle_font);
        avfulb.setForeground(Color.WHITE);
        avfulb.setBounds(30,y1,200,30);
        x.add(avfulb);
        avfut_Text=new JTextField(1);
        avfut_Text.setBounds(30,y2,200,30);
        onlyFloatType(avfut_Text);
        x.add(avfut_Text);
    }
    public void createFlag(JPanel x,int y1,int y2){
        JLabel flaglb =new JLabel("Flag:");
        flaglb.setFont(subTitle_font);
        flaglb.setForeground(Color.WHITE);
        flaglb.setBounds(30,y1,200,30);
        x.add(flaglb);
        flagt_Text =new JTextField(1);
        flagt_Text.setBounds(30,y2,200,30);
        onlyStringType(flagt_Text);
        x.add(flagt_Text);
    }
    public void createavli(JPanel x,int y1,int y2){
        JLabel avlilb=new JLabel("Average life expectancy:");
        avlilb.setFont(subTitle_font);
        avlilb.setForeground(Color.WHITE);
        avlilb.setBounds(30,y1,260,25);
        x.add(avlilb);
        avlit_Text=new JTextField(1);
        avlit_Text.setBounds(30,y2,200,30);
        onlyFloatType(avlit_Text);
        x.add(avlit_Text);

    }
    public void createRoadType(JPanel x,int y1){
        JLabel spylb =new JLabel("Road Type:");
        spylb.setFont(subTitle_font);
        spylb.setForeground(Color.WHITE);
        spylb.setBounds(30,y1,200,30);
        x.add(spylb);

    }
    public void createPowerSource(JPanel x,int y1,int y2){
        JLabel pwrl = new JLabel("Power Source:");
        pwrl.setFont(subTitle_font);
        pwrl.setForeground(Color.WHITE);
        pwrl.setBounds(30,y1,200,30);
        x.add(pwrl);
        pwr_Text=new JTextField(1);
        pwr_Text.setBounds(30,y2,200,30);
        onlyStringType(pwr_Text);
        x.add(pwr_Text);
    }
    public void createWheel(JPanel x,int y1,int y2){
        JLabel wheelb = new JLabel("wheels:");
        wheelb.setFont(subTitle_font);
        wheelb.setForeground(Color.WHITE);
        wheelb.setBounds(30,y1,200,30);
        x.add(wheelb);
        wheel_Text=new JTextField(1);
        wheel_Text.setBounds(30,y2,200,30);
        onlyIntType(wheel_Text);
        x.add(wheel_Text);
    }


    /**
     Displays the main panel of the agency, which includes a button for resetting traveled distance of vehicles,
     a scrolling panel to show the list of vehicles in the agency, and a button to change the flag of all vehicles.
     Removes any previously displayed panel from the screen.
     The center panel is created and added to the main frame.
     Sets the font, color, position, and size of the title label and adds it to the north panel.
     Creates a button for resetting the traveled distance of all vehicles and sets its position and size.
     Adds an action listener to the reset button to reset the traveled distance of all vehicles and display a message dialog.
     Creates a scrolling panel to show the list of vehicles in the agency.
     Creates a button to change the flag of all vehicles and sets its position and size.
     Adds an action listener to the change flag button to change the flag of all vehicles.
     Adds the reset button, scrolling panel, and change flag button to the center panel and adds the center panel to the main frame.
     */
    public void show_myAgency(){


//        inventoryFrame.getFrame().addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                inventoryFrame.Inventory_frame(vehicle_arr,picture_arr);
//                System.out.println("focus on inventory");
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//
//            }
//        });


        RemovePanel();
//        if(vehicle_arr.length==0){
//
//            JLabel soldLabel=new JLabel();
//            ImageIcon myIcon = new ImageIcon(getClass().getResource("myPic/jeep2.jpeg"));
//            Image img = myIcon.getImage().getScaledInstance(135, 187, Image.SCALE_SMOOTH);
//            myIcon = new ImageIcon(img);
//            soldLabel.setIcon(myIcon);
//            jeep_button.setText("Jeep");
//            jeep_button.setHorizontalTextPosition(JButton.CENTER);
//            jeep_button.setVerticalTextPosition(JButton.NORTH);
//            jeep_button.setFont(new Font("Comic Sans",Font.BOLD,17));
//            jeep_button.addActionListener(e->createJepp_panel());
//            CENTER_PANEL.add(jeep_button);
//
//
//
//        }

        CENTER_PANEL = new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0,0,700,700);

        KOTAROT.setText("Welcome to our Agency ! :");
        KOTAROT.setFont(Title_font);
        KOTAROT.setForeground(new Color(255,255,255));
        KOTAROT.setBorder(border);
        NORTH_PANEL.add(KOTAROT);


        Rbutt=new JButton("Reset Distance");
        Rbutt.setBounds(500,0,180,70);
        Rbutt.setFocusable(false);
        Rbutt.setFont(new Font("Comic Sans",Font.BOLD,17));
        Rbutt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if (vehicle_arr.length > 0) {
                    for (int i = 0; i < vehicle_arr.length; i++)
                    {
                        vehicle_arr[i].Set_travel(-(vehicle_arr[i].getTravel_distance()));
                    }
                    RemovePanel();
                    show_myAgency();
                    setVisible(true);


                    JOptionPane.showMessageDialog(null, "All The traveled distance set to zero", "Our Agency", JOptionPane.INFORMATION_MESSAGE);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "There is No vehicle in the agency", "Our Agency", JOptionPane.WARNING_MESSAGE);

                }


            }

        });
        CENTER_PANEL.add(Rbutt);


        Cbutt=new JButton("Change all flags");
        Cbutt.setBounds(500,75,180,70);
        Cbutt.setFocusable(false);
        Cbutt.setFont(new Font("Comic Sans",Font.BOLD,17));
        //Cbutt.setBorder(BorderFactory.createEtchedBorder());
        Cbutt.addActionListener(e->ChangeFlag());
        CENTER_PANEL.add(Cbutt);


        inventoryBut=new JButton("Show inventory");
        inventoryBut.setBounds(500,150,180,70);
        inventoryBut.setFocusable(false);
        inventoryBut.setFont(new Font("Comic Sans",Font.BOLD,17));
        //Cbutt.setBorder(BorderFactory.createEtchedBorder());

        inventoryBut.addActionListener(e->show_inventory());








        CENTER_PANEL.add(inventoryBut);

        vehicle_scrolling_panel();


        Flag_arr[0]=new ImageIcon("myPic/aa1.png");
        Flag_arr[1]=new ImageIcon("myPic/aa2.png");
        Flag_arr[2]=new ImageIcon("myPic/aa3.png");
        Flag_arr[3]=new ImageIcon("myPic/download.png");
        Flag_arr[4]=new ImageIcon("myPic/aa5.png");
        Flag_arr[5]=new ImageIcon("myPic/aa6.png");
        Flag_arr[6]=new ImageIcon("myPic/aa7.png");


        this.add(CENTER_PANEL,BorderLayout.CENTER);
        this.repaint();
        this.setVisible(true);
    }
    public void show_inventory(){

        inventoryFrame=new Myframe();



        inventoryFrame.getFrame().addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e)
            {
                inventoryFrame.clearFrame(inventoryFrame.getFrame());
                inventoryFrame.Inventory_frame(vehicle_arr,picture_arr);

            }

            @Override
            public void focusLost(FocusEvent e)
            {

            }
        });

        flagInventory=1;
//        inventoryFrame.getFrame().addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                inventoryFrame.Inventory_frame(vehicle_arr,picture_arr);
//                System.out.println("inventory focus");
//
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//
//            }
//        });
//        inventoryFrame.getFrame().addFocusListener(new FocusListener() {
//            @Override
//            public void focusGained(FocusEvent e) {
//                //RemovePanel();
//
//            }
//
//            @Override
//            public void focusLost(FocusEvent e) {
//
//            }
//        });

    }



    /**
     * Creates a JPanel with a vertical scroll bar and adds buttons for each vehicle in the `vehicle_arr` array.
     * The buttons display an image of the vehicle and have a tool tip that shows the details of the vehicle.
     * When a button is clicked, the `specific_options` method is called with the index of the clicked button.
     */
    public void vehicle_scrolling_panel() {

        if (vehicle_arr.length > 0) {
            dtpanel = new JPanel();
            dtpanel.setBackground(Color.DARK_GRAY);
            //dtpanel.setBounds();
            dtpanel.setLayout(new GridLayout(vehicle_arr.length, 1));
            for (int i = 0; i < vehicle_arr.length; i++) {

                JButton temp_button = new JButton(repair_icon(picture_arr[i]));
                temp_button.setPreferredSize(new Dimension(150, 150));
                temp_button.setBackground(Color.DARK_GRAY);
                temp_button.setToolTipText("<html>" + vehicle_arr[i].toString().replace(",", "<br>") + "</html>");
                final int index = i;
                temp_button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        real_index=index;
                        specific_options(index);
                    }
                });
                dtpanel.add(temp_button);
            }
            scrollPane = new JScrollPane(dtpanel, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            scrollPane.setBounds(0, 0, 500, 440);
            CENTER_PANEL.add(scrollPane);

        }

        //repaint();
        setVisible(true);
        this.add(CENTER_PANEL,BorderLayout.CENTER);
    }



    /**
     * his method takes an ImageIcon as input and returns a repaired version of the image as an ImageIcon
     */
    public ImageIcon repair_icon(ImageIcon icon) {

        Image scaledImage3 = icon.getImage().getScaledInstance(250, 140, Image.SCALE_SMOOTH);
        repaired = new ImageIcon(scaledImage3);
        return repaired;
    }



    /**
     * This method creates a panel with specific options for a selected vehicle.
     * It adds two buttons for buying the vehicle from the agency or taking it for a test drive.
     * The method also sets the layout, bounds, and background color of the panel.
     */
    public void specific_options(int index) {
        RemovePanel();
        CENTER_PANEL = new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0, 0, 700, 700);
        CENTER_PANEL.setBackground(Color.DARK_GRAY);

        KOTAROT.setFont(subTitle_font);

        KOTAROT.setForeground(Color.WHITE);
        KOTAROT.setText("<html><u>Vehicle Options</u></html>");


        BuyButt = new JButton("Buy this vehicle from the agency");
        BuyButt.setBounds(170, 250, 350, 35);

        BuyButt2 = new JButton("Take this vehicle to test drive");
        BuyButt2.setBounds(170, 300, 350, 35);

        BuyButt.setBackground(new Color(206, 217, 208));
        BuyButt2.setBackground(new Color(206, 217, 208));

        BuyButt.setFont(bt_font);
        BuyButt2.setFont(bt_font);

        BuyVehicle();
        ActionTestDrive();

        CENTER_PANEL.add(BuyButt);
        CENTER_PANEL.add(BuyButt2);
        this.add(CENTER_PANEL, BorderLayout.CENTER);
        setVisible(true);
    }



    ////////////our new gui frames methods


    ///testdrive
    /**
     The TestDrive method allows the user to test drive a selected vehicle by setting the distance they wish to drive.
     The method displays a form where the user can input the desired distance and click the "Enjoy!" button to set the traveled distance of the vehicle.
     @throws NumberFormatException if the input value is not a valid integer.
     */
    public void TestDrive(){
        RemovePanel();
        Myframe frame1=new Myframe();
        frame1.TestDrive_frame(real_index,vehicle_arr);
        addFocusListener(new FocusListener()
        {
            @Override
            public void focusGained(FocusEvent e)
            {
                show_myAgency();
                System.out.println("test drive focus");
            }
            @Override
            public void focusLost(FocusEvent e) {

            }
        });

    }

    public void buyFrame(){

        //RemovePanel();
        Myframe frame1=new Myframe();
        frame1.Buy_frame(chosen_icon);


        frame1.Yes_butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                if(e.getSource()==frame1.Yes_butt)
                {
                    buyVehicleAndPicture(real_index);
                    frame1.getFrame().dispose();
                    show_myAgency();


                }
            }
        });

        frame1.No_butt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==frame1.No_butt){
                    show_myAgency();
                    frame1.getFrame().dispose();
                }

            }
        });


        //JButton pic_Button3 = new JButton(icon3);
        //pic_Button3.setBounds(500, 320, 120, 100);
        //ImageIcon finalIcon3 = icon3;




    }




    /**
     This method is used to set an action listener for the "BuyButt2" button,
     which opens the "TestDrive" method when clicked.
     */
    public void ActionTestDrive(){
        BuyButt2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                TestDrive();

            }
        });

    }


    /**
     * This method removes a vehicle from the vehicle array and its corresponding picture from the picture array,
     * based on the index provided as a parameter.
     * If the index is not found, nothing happens.
     */
    public void buyVehicleAndPicture(int index){
        int j=0;
        Vehicle[] temp1=new Vehicle[vehicle_arr.length-1];
        ImageIcon[] temp_picture_arr=new ImageIcon[picture_arr.length-1];

        if (vehicle_arr.length == 0)
        {
            System.out.println("The Agency is empty right now!");

        }
        else if (vehicle_arr.length == 1)
        {
            //Vehicle tmp_arr[] = new Vehicle[1];
            Vehicle temp=vehicle_arr[index];
            vehicle_arr = new Vehicle[0];
            picture_arr= new ImageIcon[0];
            RemovePanel();
            vehicle_scrolling_panel();

        }

        else if (vehicle_arr.length > 1)
        {
            for (int i = 0; i < vehicle_arr.length; i++)
            {

                if(i==index)
                {
                    continue;
                }

                temp1[j]= vehicle_arr[i];
                temp_picture_arr[j]=picture_arr[i];
                j++;
            }
            vehicle_arr =new Vehicle[temp1.length];
            picture_arr =new ImageIcon[temp_picture_arr.length];
            vehicle_arr=temp1;
            picture_arr=temp_picture_arr;


            //RemovePanel();
            //vehicle_scrolling_panel();
        }
    }


    /**
     * This method sets an action listener for the "BuyButt" button, which is used to remove a selected vehicle from the agency's inventory.
     * When the button is clicked, the "buyVehicleAndPicture" method is called with the index of the selected vehicle.
     * The "show_myAgency" method is also called to update the UI with the new inventory.
     */
    public void BuyVehicle(){
        BuyButt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                buyFrame();


            }
        });
    }






    ///////////////////////////

    /**
     Changes the flag displayed in the GUI by creating a new panel with buttons
     for each flag and setting their corresponding images and action listeners.
     The method also sets the text of a label to "Change flag!" and removes a previous panel.
     */
    public void ChangeFlag() {
        RemovePanel();

        SOUTH_PANEL.setVisible(false);

        KOTAROT.setText("Change flag !");
        CENTER_PANEL = new JPanel();
        CENTER_PANEL.setLayout(null);
        CENTER_PANEL.setBounds(0, 0, 700, 700);
        CENTER_PANEL.setBackground(Color.DARK_GRAY);


        dtpanel = new JPanel();
        dtpanel.setLayout(new GridLayout(3, 3, 10, 10));
        dtpanel.setBounds(80, 15, 550, 500);
        dtpanel.setBackground(Color.DARK_GRAY);


        flag1 = new JButton();
        ImageIcon jeepIcon1 = new ImageIcon(getClass().getResource("myPic/aa1.png"));
        Image img = jeepIcon1.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jeepIcon1 = new ImageIcon(img);
        flag1.setIcon(jeepIcon1);
        my_icon = new ImageIcon(img);
        flag1.addActionListener(e -> set_Flag("Somalia", my_icon));
        dtpanel.add(flag1);

        flag2 = new JButton();
        ImageIcon jeepIcon2 = new ImageIcon(getClass().getResource("myPic/aa2.png"));
        Image img2 = jeepIcon2.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jeepIcon2 = new ImageIcon(img2);
        flag2.setIcon(jeepIcon2);
        my_icon2 = new ImageIcon(img2);
        flag2.addActionListener(e -> set_Flag("Israel", my_icon2));
        dtpanel.add(flag2);


        flag3 = new JButton();
        ImageIcon jeepIcon3 = new ImageIcon(getClass().getResource("myPic/aa3.png"));
        Image img3 = jeepIcon3.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jeepIcon3 = new ImageIcon(img3);
        flag3.setIcon(jeepIcon3);
        my_icon3 = new ImageIcon(img3);
        flag3.addActionListener(e -> set_Flag("Italy", my_icon3));
        dtpanel.add(flag3);

        flag4 = new JButton();
        ImageIcon jeepIcon4 = new ImageIcon(getClass().getResource("myPic/download.png"));
        Image img4 = jeepIcon4.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jeepIcon4 = new ImageIcon(img4);
        flag4.setIcon(jeepIcon4);
        my_icon4 = new ImageIcon(img4);
        flag4.addActionListener(e -> set_Flag("Pirate", my_icon4));
        dtpanel.add(flag4);

        flag5 = new JButton();
        ImageIcon jeepIcon5 = new ImageIcon(getClass().getResource("myPic/aa5.png"));
        Image img5 = jeepIcon5.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jeepIcon5 = new ImageIcon(img5);
        flag5.setIcon(jeepIcon5);
        my_icon5 = new ImageIcon(img5);
        flag5.addActionListener(e -> set_Flag("Greece", my_icon5));
        dtpanel.add(flag5);

        flag6 = new JButton();
        ImageIcon jeepIcon6 = new ImageIcon(getClass().getResource("myPic/aa6.png"));
        Image img6 = jeepIcon6.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jeepIcon6 = new ImageIcon(img6);
        flag6.setIcon(jeepIcon6);
        my_icon6 = new ImageIcon(img6);

        flag6.addActionListener(e -> set_Flag("Germany", my_icon6));
        dtpanel.add(flag6);

        flag7 = new JButton();


        ImageIcon jeepIcon7 = new ImageIcon(getClass().getResource("myPic/aa7.png"));

        Image img7 = jeepIcon7.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH);
        jeepIcon7 = new ImageIcon(img7);


        flag7.setIcon(jeepIcon7);
        my_icon7 = new ImageIcon(img7);
        flag7.addActionListener(e -> set_Flag("USA", my_icon7));

        dtpanel.add(flag7);


        CENTER_PANEL.add(dtpanel);
        this.add(CENTER_PANEL, BorderLayout.CENTER);



        setVisible(true);
        this.repaint();
    }


    /**
     Sets the flag of a Water_Vehicle object in the vehicle_arr array.
     @param flag a String representing the flag to be set for the Water_Vehicle object
     @param icon an ImageIcon to be displayed in a dialog box showing the chosen style
     */
    public void set_Flag(String flag, ImageIcon icon) {


        if (vehicle_arr.length == 0) {

            JOptionPane.showMessageDialog(null, "There is no vehicle in our agency", "Agency", JOptionPane.WARNING_MESSAGE);
        } else {

            for (int i = 0; i < vehicle_arr.length; i++) {

                if (vehicle_arr[i] instanceof Water_Vehicle) {
                    ((Water_Vehicle) vehicle_arr[i]).setFlagflag(flag);
                }
            }
            JLabel mylabel = new JLabel(icon);
            JOptionPane.showOptionDialog(null, "Chosen style", "Info", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, icon, null, 0);


        }
        SOUTH_PANEL.setVisible(true);
        show_myAgency();
    }


    /**
     This method sets a document filter to a JTextField to only allow integers to be entered.
     @param tfield The JTextField to set the document filter on.
     */
    public void onlyIntType(JTextField tfield){
        ((AbstractDocument) tfield.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) {
                    return;
                }
                // Allow only digits to be entered
                if (string.matches("\\d+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) {
                    return;
                }
                // Allow only digits to be entered
                if (text.matches("\\d+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }



    /**
     This method sets a document filter to a JTextField to only allow String to be entered.
     @param tfield The JTextField to set the document filter on.
     */
    public void onlyStringType(JTextField tfield){
        ((AbstractDocument) tfield.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) {
                    return;
                }
                if (string.matches("[a-zA-Z ,.-]+")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) {
                    return;
                }
                if (text.matches("[a-zA-Z ,.-]+")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }


    /**
     This method sets a document filter to a JTextField to only allow float to be entered.
     @param tfield The JTextField to set the document filter on.
     */
    public void onlyFloatType(JTextField tfield){
        ((AbstractDocument) tfield.getDocument()).setDocumentFilter(new DocumentFilter() {
            @Override
            public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr) throws BadLocationException {
                if (string == null) {
                    return;
                }
                if (string.matches("[-\\d.]++")) {
                    super.insertString(fb, offset, string, attr);
                }
            }
            @Override
            public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs) throws BadLocationException {
                if (text == null) {
                    return;
                }
                if (text.matches("[-\\d.]++")) {
                    super.replace(fb, offset, length, text, attrs);
                }
            }
        });
    }

    public static void main(String[] args){
        new Build_agency();
    }

}
