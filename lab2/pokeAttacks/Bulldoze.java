// Swinub's, Piloswine's and Mamoswine's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class Bulldoze extends PhysicalMove{

    public Bulldoze(){
        super(Type.GROUND, 60, 100);        
    }
    public void apllyOppEffects(Pokemon p){
        p.setMod(Stat.SPEED, -1);
    }
    public String describe(){
        return "It's time to bulldoze you";
    }
}