// Mamoswine's attack

package pokeAttacks;
import ru.ifmo.se.pokemon.*;

public class DoubleHit extends PhysicalMove{
    
    public DoubleHit(){
        super(Type.NORMAL, 35, 90, 0, 2);
    }
    public String describe(){
        return "Double tap! You good?";
    }
}
