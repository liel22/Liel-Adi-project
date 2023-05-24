//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23

package Vehicle;

public abstract class Vehicle {
    private int travel_distance;
    private String model_name;
    private int max_pas;
    private int max_speed;

    public Vehicle(String name,int mpas, int mspeed){
        travel_distance=0;
        model_name=name;
        max_pas=mpas;
        max_speed=mspeed;
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Vehicle)){
            return false;
        }
        Vehicle x = (Vehicle) obj;
        return model_name.equals(x.model_name)&&this.max_speed==x.max_speed&&this.max_pas==x.max_pas
                &&this.travel_distance==x.travel_distance;
    }

    public String toString(){
        return "Model: "+model_name+", traveled: "+travel_distance+" Km,"+"Max speed of "+max_speed+" Mph,"
                +"can carry max of "+max_pas+" people.";
    }

    public void Set_travel(int ntravel){
        this.travel_distance+=ntravel;
    }

    public int getTravel_distance(){
        return travel_distance;
    }
    public int getMax_pas(){
        return max_pas;
    }
    public int getMax_speed(){
        return max_speed;
    }
    public String getModel_name(){
        return model_name;
    }


}
