
//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23
package Vehicle;

public class Frigate extends Water_Vehicle implements Motorized{

    private float av_fuel_use;
    private float av_life;

    public Frigate(String name, int mpas, int mspeed, boolean windd){
        super(name,mpas,mspeed,windd,"Israel");
        av_fuel_use=500;
        av_life=4;
    }
    public void setAverageFuelUse(float x){
        av_fuel_use=x;
    }
    public void setAverageLifeExpectancy(float x){
        av_life=x;
    }
    public float getAverageFuelUse(){
        return av_fuel_use;
    }
    public float getAverageLifeExpectancy(){
        return av_life;
    }

    public String toString(){
        return "Frigate: "+super.toString()+"Engine: "+av_fuel_use+"L ,Average life Expectancy: "+av_life+" years.";
    }

    public boolean equals(Object obj){
        if(!(super.equals(obj)))
            return false;
        else {
            Frigate x = (Frigate) obj;
            return av_fuel_use==x.av_fuel_use&&av_life==x.av_life;
        }
    }
}
