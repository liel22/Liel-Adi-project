//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23
package Vehicle;

public class Air_Vehicle extends Vehicle
{
    private String Vehicle_use;

    public Air_Vehicle(String name, int max_passengers, int max_speed, String use){
        super(name, max_passengers, max_speed);
        Vehicle_use = use;
    }

    public String get_use()
    {
        return Vehicle_use;
    }

    public void Set_use(String use)
    {
        Vehicle_use = use;
    }

    public boolean equals(Object obj)
    {
        if(!(obj instanceof Air_Vehicle))
        {
            return false;
        }

        Air_Vehicle x = (Air_Vehicle) obj;
        return super.equals(obj)&& Vehicle_use.equals(x.Vehicle_use);
    }

    public String toString()//returns a string representation of the air vehicle, including its name and intended use
    {
        return super.toString()+"In "+ Vehicle_use +" use.";
    }

}