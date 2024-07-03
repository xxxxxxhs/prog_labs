// Piloswine's and Mamoswine's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class IcyWind extends SpecialMove {
    
    public IcyWind() {
        super(Type.ICE, 55, 95);
    }
    public void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPEED, -1);
    }
    public String describe(){
        return "Get an Icy Wind!";
    }
}
