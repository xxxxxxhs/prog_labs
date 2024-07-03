// Hoopa-Confied's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class Confusion extends SpecialMove{
    
    public Confusion(){
        super(Type.PSYCHIC, 50, 100);
    }
    public void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1) Effect.confuse(p);
    }
    public String describe(){
        return "Is it good to be confused?";
    }
}
