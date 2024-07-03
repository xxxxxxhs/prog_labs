// Hoopa-Confined's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class Swagger extends StatusMove{

    public Swagger(){
        super(Type.NORMAL, 0, 85);
    }
    public void applyOppEffects(Pokemon p){
        Effect.confuse(p);
        p.setMod(Stat.ATTACK, 2);
    }
    public String describe(){
        return "Swagger will kill you";
    }
}
