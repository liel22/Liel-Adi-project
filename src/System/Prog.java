//By liel forish 316116383
//   Adi meller  316229004
//   14/05/23


package System;
import Vehicle.*;
import java.util.Scanner;

public class Prog {

    /**
     * this method creates an array of Vehicles in the provided size, we use this method to create
     * even a single object for comparing things in the main method. the array contains different types
     * of vehicles by users choice, that means that we use here upcasting.
     * @param length the length of the array,mostly provided by the user.
     * @return we return final array of Vehicles.
     * */
    public static Vehicle[] Agency(int length)
    {
        int first_choice;
        Scanner sc=new Scanner(System.in);
        Vehicle arr[]=new Vehicle[length];
        System.out.println("Enter the type of vehicle :\n"
                +"1:Jeep\n2:Frigate\n3:SpyGlider\n4:ToyGlider\n5:Amphibious\n6:Bicycle\n7:Cruise Ship\n");
        for(int i=0;i< length;i++){
            System.out.println("Vehicle number "+(i+1)+": ");
            first_choice =sc.nextInt();
            if(first_choice ==1)
            {
                System.out.println("Enter name, max speed, average speed, average life expectancy:");
                arr[i]=new Jeep(sc.next(), sc.nextInt(),sc.nextFloat(),sc.nextFloat());
            }
            else if(first_choice ==2)
            {
                System.out.println("Enter name, max passenger, max speed, wind direction(true=with the wind):");
                arr[i]=new Frigate(sc.next(), sc.nextInt(),sc.nextInt(), sc.nextBoolean());
            }
            else if(first_choice ==3)
            {
                System.out.println("Enter power source:");
                arr[i]=new SpyGlider(sc.next());
            }
            else if(first_choice ==4)
            {
                arr[i]=new ToyGlider();
            }
            else if(first_choice==5){
                System.out.println("Enter name, max passenger, max speed, number of wheels, wind direction(true=with the wind), flag name, average fuel use, average life expectancy:");
                arr[i]=new Amphibious(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextInt(),sc.nextBoolean(),sc.next(),sc.nextFloat(),sc.nextFloat());
            }else if(first_choice==6){
                System.out.println("Enter name, max speed, average speed, road type(true=paved road):");
                arr[i]=new Regular_Bicycle(sc.next(),sc.nextInt(),sc.nextInt(),sc.nextBoolean());
            }
            else if(first_choice==7){
                System.out.println("Enter name, max speed, average speed, flag name, average fuel use, average life expectancy:");
                arr[i]=new Cruise_Ship(sc.next(),sc.nextInt(),sc.nextInt(),sc.next(),sc.nextFloat(), sc.nextFloat());
            }
            else{
                System.out.println("Wrong first_choice!\ntry again");
                i--;
            }
        }
        return arr;
    }
    /**
     * this method is used for printing a whole array of vehicles by using the toString method of every class.
     * @param arr the array that's provided for print
     * */
    public static void Print_Agency(Vehicle[] arr) {
        for(int i = 0; i < arr.length&&arr!=null; i++){
            System.out.println(arr[i]);
        }
        System.out.println('\n');
    }

    /**
     * The main class of the program, which allows the user to interact with the vehicle agency.
     * The user can choose from different options to buy a vehicle, take a vehicle to test drive,
     * reset all vehicles distance, change the vehicle flags, and exit the program.
     *
     * */

    public void ResetDis(Vehicle[] arr){
        if (arr == null) {
            System.out.println("There's no vehicles in the agency!\n");

        }

        for (int i = 0; i < arr.length; i++)
        {
            arr[i].Set_travel((-arr[i].getTravel_distance()));
        }
    }
    public void ChangeFlag(Vehicle[] arr){
        if (arr == null) {
            System.out.println("There's no vehicles in the agency!\n");

        } else {

            Scanner sc = new Scanner(System.in);
            System.out.println("Enter new flag:");
            String temp = sc.nextLine();
            temp = sc.nextLine();
            for (int i = 0; i < arr.length; i++) {

                if (arr[i] instanceof Water_Vehicle) {
                    ((Water_Vehicle) arr[i]).setFlagflag(temp);
                }

            }
        }

    }


    public static void main(String[] args){
        int distance2;
        int distance;
        int length;
        int second_choice;
        boolean flag=true;
        System.out.println("Enter the number of vehicles in the agency: ");
        Scanner sc=new Scanner(System.in);
        length=sc.nextInt();
        Vehicle arr[]=new Vehicle[length];
        arr=Agency(length);



        while(flag)
        {
            System.out.println("Enter your choice: \n1. Buy a vehicle from the agency\n" +
                    "2. Take a vehicle to test drive\n3. Reset all vehicles distance\n" +
                    "4. Change the vehicle flags\n5. Exit\n");
            second_choice = sc.nextInt();
            switch (second_choice) {
                case 1: {
                    if (arr == null) {
                        System.out.println("The Agency is empty right now!");
                        break;
                    }
                    else if (arr.length == 1) {
                        Vehicle tmp_arr[] = new Vehicle[1];
                        System.out.println("Which vehicle do you want to buy? \n");
                        Print_Agency(arr);
                        tmp_arr = Agency(1);
                        if (arr[0].equals(tmp_arr[0])) {
                            arr = null;
                            System.out.println("Last vehicle has been sold!\nAgency is empty!\n ");
                            break;
                        } else {
                            System.out.println("Vehicle not available!\n");
                        }
                    }
                    else if (arr.length > 1) {
                        Vehicle tmp_arr[] = new Vehicle[1];
                        System.out.println("Which vehicle do you want to buy?");
                        Print_Agency(arr);
                        tmp_arr = Agency(1);

                        int k = 0;
                        int j = 0;

                        for(int i = 0; i < arr.length; i++){
                            if(arr[i].equals(tmp_arr[0])){
                                k=1;
                                break;
                            }
                        }
                        if(k==1){
                            Vehicle new_arr[] = new Vehicle[(arr.length) - 1];
                            for(int i = 0; i < arr.length; i++){
                                if(arr[i].equals(tmp_arr[0]))
                                    continue;
                                else{
                                    new_arr[j]=arr[i];
                                    j++;
                                }
                            }
                            System.out.println("Vehicle sold successfully!\n");
                            arr = new_arr;
                        }
                        else
                            System.out.println("Vehicle not available!\n");
                    }

                    break;
                }
                case 2: {
                    if (arr == null) {
                        System.out.println("There's no vehicles in the agency!");
                        break;
                    } else {
                        int flag2 = 1;
                        Vehicle arr2[] = new Vehicle[1];
                        System.out.println("Requested vehicle: ");
                        arr2 = Agency(1);
                        System.out.println("Enter the distance that the vehicle already went through: ");
                        distance2 = sc.nextInt();
                        arr2[0].Set_travel(distance2);
                        for (int i = 0; i < arr.length; i++) {
                            if (arr[i].equals(arr2[0])) {
                                System.out.println("What is the test drive distance?");
                                distance = sc.nextInt();
                                arr[i].Set_travel(distance);
                                System.out.println("New travel distance: " + arr[i].getTravel_distance());
                                flag2 = 0;
                                break;

                            }

                        }
                        if (flag2 == 1)
                            System.out.println("Vehicle is not existing in the Agency,Sorry.");

                        Print_Agency(arr);
                        break;
                    }

                }
                case 3: {
                    for (int i = 0; i < arr.length; i++) {
                        arr[i].Set_travel((-arr[i].getTravel_distance()));
                    }
                    System.out.println("All distances were reset!");
                    Print_Agency(arr);
                    break;
                }
                case 4: {
                    if (arr == null) {
                        System.out.println("There's no vehicles in the agency!\n");
                        break;
                    } else {
                        System.out.println("Enter new flag:");
                        String temp = sc.nextLine();
                        temp=sc.nextLine();
                        for (int i = 0; i < arr.length; i++) {

                            if (arr[i] instanceof Water_Vehicle) {
                                ((Water_Vehicle) arr[i]).setFlagflag(temp);
                            }

                        }
                        System.out.println("The flags have changed:");
                        Print_Agency(arr);
                        break;
                    }
                }
                case 5: {
                    System.out.println("End of program...\n");
                    flag = false;
                    break;
                }
                default: {
                    System.out.println("Wrong input, try again!\n");
                }
            }


        }

        sc.close();

    }


}
