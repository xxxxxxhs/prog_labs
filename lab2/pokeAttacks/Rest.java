// Swinub's, Piloswine's and Mamoswine's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class Rest extends StatusMove{

    public Rest(){
        super(Type.PSYCHIC, 0, 0);
    }
    public void applySelfEffects(Pokemon p){
        Effect eff = new Effect().turns(2).condition(Status.SLEEP);
        p.restore();
        p.addEffect(eff);
    }
    public String describe(){
        return "I gotta sleep he-he";
    }
}
