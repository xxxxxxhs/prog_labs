// Ratatta's and Raticate's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class IceBeam extends SpecialMove{

    public IceBeam(){
        super(Type.ICE, 90, 100);
    }
    public void applyOppEffects(Pokemon p){
        if (Math.random() <= 0.1) Effect.freeze(p);
    }
    public void applyOppDamage(Pokemon def, double damage){
        def.setMod(Stat.HP, (int) Math.round(damage));
        if (damage != 0.0){
            System.out.println("ХОЛОДНО!");
        }
    }
    public String describe(){
        return "Shhhh, icyyyy";
    }
}