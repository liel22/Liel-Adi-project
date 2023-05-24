package Vehicle;

public class Air_plane extends Amphibious implements IAir_Vehicle{

    private String Vehicle_use;
    private Air_Vehicle Air_veh;

    public Air_plane(String name, int mpas, int mspeed, int whee, boolean windd, String flagg, float avfu, float avli) {
        super(name, mpas, mspeed, whee, windd, flagg, avfu, avli);
        Set_use("Military");
        Air_veh=new Air_Vehicle(name,mpas,mspeed,Vehicle_use);
    }

    @Override
    public String get_use()
    {
        return Vehicle_use;
    }
    @Override
    public void Set_use(String use)
    {
        Vehicle_use = use;
    }

    public String toString(){
        return super.toString().replace("Amphibious: ","Air_plane: ")+ Vehicle_use +" use.";
    }

    public boolean equals(Object obj) {
        if(!(obj instanceof Air_plane))
            return false;
        Air_plane x = (Air_plane) obj;
        return super.equals(x)&& Air_veh.equals(x.Air_veh);
    }
}


