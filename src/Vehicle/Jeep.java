
//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23
package Vehicle;

public class Jeep extends Land_Vehicle implements Motorized, Commercial_Use{
    private String license;
    private float av_fuel_use;
    private float av_life;

    public Jeep(String name, int mspeed,float av_fu, float av_li){
        super(name, 5, mspeed, 4, false);
        license="Mini";
        setAverageFuelUse(av_fu);
        setAverageLifeExpectancy(av_li);
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
    public String getLicense(){
        return license;
    }

    public String toString(){
        return "Jeep: "+super.toString()+", Engine: "+av_fuel_use+", Average life Expectancy: "+av_life+" years, License: "+license+".";
    }

    public boolean equals(Object obj){
        if(!(super.equals(obj)))
            return false;
        else {
            Jeep x = (Jeep) obj;
            return license.equals(x.getLicense())&&av_life==x.av_life&&av_fuel_use==x.av_fuel_use;
        }
    }


}
