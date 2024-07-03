// Hoopa-Confined's, Ratatta's and Raticate's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class Confide extends StatusMove{
    
    public Confide(){
        super(Type.NORMAL, 0, 0);
    }
    public void applyOppEffects(Pokemon p){
        p.setMod(Stat.SPECIAL_ATTACK, -1);
    }
    public String describe(){
        return "Confideeeeeee!";
    }
}
