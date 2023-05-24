//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23
package Vehicle;

public abstract class Bicycle extends Land_Vehicle {

    public Bicycle(String name, int mpas, int mspeed, boolean rt){
        super(name,mpas,mspeed,2,rt);
    }

    public String toString(){
        return "Bicycle: "+super.toString();
    }

    public boolean equals(Object obj){
        if(!(obj instanceof Bicycle))
            return false;
        Bicycle x = (Bicycle) obj;
        return super.equals(x);
    }

}
