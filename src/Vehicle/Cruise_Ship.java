//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23
package Vehicle;

public class Cruise_Ship extends Water_Vehicle implements Commercial_Use,Motorized{

    private String license;
    private float av_fuel_use;
    private float av_life;


    public Cruise_Ship(String name,int mpas, int mspeed, String flagg,float avfu,float avli){
        super(name,mpas,mspeed,true,flagg);
        license="Unlimited";
        setAverageFuelUse(avfu);
        setAverageLifeExpectancy(avli);
    }

    public String toString(){
        return "Cruise Ship: "+super.toString()+" Engine: "+av_fuel_use+", Average life Expectancy: "+av_life+" years"+",License: "+license+".";
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Cruise_Ship))
            return false;
        Cruise_Ship x=(Cruise_Ship) obj;
        return super.equals(x)&&license.equals(x.license)&&av_fuel_use==x.av_fuel_use&&av_life==x.av_life;
    }


    @Override
    public String getLicense() {return license;}

    @Override
    public void setAverageFuelUse(float x) {av_fuel_use=Math.max(x,0);}

    @Override
    public void setAverageLifeExpectancy(float x) {av_life=Math.max(x,0);}

    @Override
    public float getAverageFuelUse() {return av_fuel_use;}

    @Override
    public float getAverageLifeExpectancy() {return av_life;}
}
