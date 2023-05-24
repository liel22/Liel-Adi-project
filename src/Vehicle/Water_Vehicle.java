//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23

package Vehicle;

public abstract class Water_Vehicle extends Vehicle
{
    private boolean wind_direction;
    private String flag;
    public Water_Vehicle(String name,int max_passengers, int max_speed, boolean wind, String new_flag){
        super(name, max_passengers, max_speed);
        wind_direction = wind;
        flag = new_flag;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Water_Vehicle))
        {
            return false;
        }
        Water_Vehicle x = (Water_Vehicle) obj;
        return super.equals(x)&&x.wind_direction == wind_direction &&flag.equals(x.flag);
    }

    public void setWind_direction(boolean x)
    {
        wind_direction =x;
    }

    public void setFlagflag(String x)
    {
        flag=x;
    }

    public boolean getwindd()
    {
        return wind_direction;
    }

    public String getFlag()
    {
        return flag;
    }

    public String wind_check()
    {
        if(wind_direction)
            return "with the wind";
        else
            return "against the wind";
    }

    public String toString()
    {
        return super.toString()+"Under "+flag+" flag,"+wind_check()+".";
    }
}
