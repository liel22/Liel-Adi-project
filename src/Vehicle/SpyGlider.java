//By liel forish 316116383
//   Adi meller  316229004
//   19/04/23

package Vehicle;

public class SpyGlider extends Air_Vehicle implements Not_Motorized{
    private char engine_score;
    private String power_source;
    public SpyGlider(String PS){
        super("Classified",1,50,"Army");
        engine_score ='C';
        this.power_source = PS;
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
        return "SpyGlider: "+super.toString()+"Energy Score: "+ engine_score +" ,Power Source: "+ power_source +".";
    }

    public boolean equals(Object obj)
    {
        if(!(super.equals(obj)))
            return false;
        else
        {
            SpyGlider x = (SpyGlider) obj;
            return power_source.equals(x.getPowerSrc())&& engine_score ==x.engine_score;
        }
    }




}
