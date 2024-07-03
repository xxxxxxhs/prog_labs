package myPokemons;
import ru.ifmo.se.pokemon.*;
import pokeAttacks.*;

public class Raticate extends Rattata{
    public Raticate(String name, int level){
        super(name, level);
        setStats(55, 81, 60, 50, 70, 97);
        setType(Type.NORMAL);
        setMove(new Confide(), new HyperFang(), new IceBeam(), new SwordsDance());
    }
}
