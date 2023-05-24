package Vehicle;

public class Electric_Bicyle extends Bicycle implements Motorized{
    private float av_fuel_use;
    private float av_life;


    public Electric_Bicyle(String name, int mpas, int mspeed, boolean rt,float av_li) {
        super(name, mpas, mspeed, rt);
        setAverageFuelUse(20);
        setAverageLifeExpectancy(av_li);
    }


    public boolean equals(Object obj){
        if(!(obj instanceof Electric_Bicyle))
            return false;
        Electric_Bicyle x = (Electric_Bicyle) obj;
        return super.equals(x)&&av_fuel_use==x.getAverageFuelUse() && av_life==x.getAverageLifeExpectancy();
    }


    public String toString(){
        return super.toString().replace("Bicycle: ","Electric_Bicyle: ")+", Engine: "+av_fuel_use+", Average life Expectancy: "+av_life+" years,";
    }

    @Override
    public void setAverageFuelUse(float x) {this.av_fuel_use=x;}

    @Override
    public void setAverageLifeExpectancy(float x) {this.av_life=x;}

    @Override
    public float getAverageFuelUse() {return av_fuel_use;}
    @Override
    public float getAverageLifeExpectancy() {return av_life;}


}
