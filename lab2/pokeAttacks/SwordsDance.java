// Raticate's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class SwordsDance extends StatusMove{
    public SwordsDance(){
        super(Type.NORMAL, 0, 0);
    }
    public void applySelfEffects(Pokemon p){
        p.setMod(Stat.ATTACK, 2);
    }
    public String describe(){
        return "Swords are dancing!";
    }
}
