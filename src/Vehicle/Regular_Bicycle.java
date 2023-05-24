package Vehicle;

public class Regular_Bicycle extends Bicycle implements Not_Motorized{

    private char energy_sc;
    private String power_src;

    public Regular_Bicycle(String name, int mpas, int mspeed, boolean rt) {
        super(name, mpas, mspeed, rt);
        energy_sc='A';
        power_src="Manual";
    }


    public boolean equals(Object obj){
        if(!(obj instanceof Regular_Bicycle))
            return false;
        Regular_Bicycle x = (Regular_Bicycle) obj;
        return super.equals(x)&&power_src.equals(x.getPowerSrc())&&energy_sc==x.energy_sc;
    }


    public String toString(){
        return super.toString().replace("Bicycle: ","Regular_Bicycle: ")+ "Energy Score: "+energy_sc+" ,Power Source: "+power_src+".";
    }


    @Override
    public String getPowerSrc() {
        return power_src;
    }

    @Override
    public char getEnergyScore() {
        return energy_sc;
    }




}
