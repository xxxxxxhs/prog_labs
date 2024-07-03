// Hoopa-Confined's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class Psybeam extends SpecialMove{
    
    public Psybeam(){
        super(Type.PSYCHIC, 65, 100);
    }
    public void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1) Effect.confuse(p);
    }
    public String describe(){
        return "Psybeam deals damage and has a 10% chance of confusing the target";
    }
}
