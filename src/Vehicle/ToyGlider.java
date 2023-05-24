//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23

package Vehicle;

public class ToyGlider extends Air_Vehicle implements Not_Motorized
{
    private char engine_score;
    private String power_source;
    public ToyGlider()
    {
        super("Toy",0,10,"Civil");
        engine_score ='A';
        power_source ="Manual";
    }
    public String getPowerSrc()
    {
        return power_source;
    }
    public char getEnergyScore()
    {
        return engine_score;
    }
    public String toString()
    {
        return "ToyGlider: "+super.toString()+"Energy Score: "+ engine_score +" ,Power Source: "+ power_source +".";
    }

    public boolean equals(Object obj)
    {
        if(!(super.equals(obj)))
            return false;
        else
        {
            ToyGlider x = (ToyGlider) obj;
            return power_source.equals(x.getPowerSrc())&& engine_score ==x.engine_score;
        }
    }
}
