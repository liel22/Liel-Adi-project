//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23
package Vehicle;

public class Amphibious extends Water_Vehicle implements ILand_Vehicle,Motorized {

    private Land_Vehicle land;
    private float av_fuel_use;
    private float av_life;

    public Amphibious(String name,int mpas, int mspeed, int whee, boolean windd, String flagg, float avfu, float avli){
        super(name,mpas,mspeed,windd,flagg);
        land = new Land_Vehicle(name,mpas,mspeed,whee,true);
        setAverageFuelUse(avfu);
        setAverageLifeExpectancy(avli);
    }

    @Override
    public int getWheels() {return land.getWheels();}

    @Override
    public boolean getRoad_type() {return land.getRoad_type();}

    @Override
    public void setWheels(int x) {land.setWheels(x);}

    @Override
    public void setRoad_type(boolean x) {land.setRoad_type(x);}

    @Override
    public String road_check() {return land.road_check();}

    @Override
    public void setAverageFuelUse(float x) {av_fuel_use=Math.max(x,0);}

    @Override
    public void setAverageLifeExpectancy(float x) {av_life=Math.max(x,0);}

    @Override
    public float getAverageFuelUse() {return av_fuel_use;}

    @Override
    public float getAverageLifeExpectancy() {return av_life;}


    public String toString(){
        return "Amphibious: "+super.toString()+ "Road type: "+road_check()+" ,Engine: "+av_fuel_use+", Average life Expectancy: "+av_life+" years";
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Amphibious))
            return false;
        Amphibious x = (Amphibious) obj;
        return super.equals(x)&& land.equals(x.land)&&av_life==x.av_life&&av_fuel_use==x.av_fuel_use;
    }
}
