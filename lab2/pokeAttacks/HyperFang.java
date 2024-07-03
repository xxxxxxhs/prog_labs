// Ratatta's and Raticate's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class HyperFang extends PhysicalMove{
    
    public HyperFang(){
        super(Type.NORMAL, 80, 90);
    }
    public void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1) Effect.flinch(p);
    }
    public String describe(){
        return "I just used Hyper Fang, watch out!";
    }
}
