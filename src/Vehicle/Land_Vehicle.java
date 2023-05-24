//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23

package Vehicle;

public class Land_Vehicle extends Vehicle{
    private int wheels;
    private boolean road_type;

    public Land_Vehicle(String name, int mpas, int mspeed, int whee, boolean rt){
        super(name, mpas, mspeed);
        wheels=whee;
        road_type=rt;
    }

    public int getWheels(){
        return wheels;
    }

    public boolean getRoad_type(){
        return road_type;
    }

    public void setWheels(int x){//maybe remove
        wheels=x;
    }

    public void setRoad_type(boolean x){
        road_type=x;
    }

    public String road_check(){//true=paved road||false=dirt road
        if(road_type)
            return "paved road";
        else
            return "dirt road";
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Land_Vehicle)){
            return false;
        }
        Land_Vehicle x = (Land_Vehicle) obj;
        return getModel_name().equals(x.getModel_name())&&this.getMax_speed()==x.getMax_speed()&&this.getMax_pas()==x.getMax_pas()
                &&this.getTravel_distance()==x.getTravel_distance()&&wheels==x.getWheels()&&road_type==x.getRoad_type();
    }

    public String toString(){
        return super.toString()+"has "+wheels+" wheels, "+"road type: "+road_check();
    }

}
