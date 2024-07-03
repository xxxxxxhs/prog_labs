package myPokemons;
import ru.ifmo.se.pokemon.*;
import pokeAttacks.*;

public class Rattata extends Pokemon{
    public Rattata(String name, int level){
        super(name, level);
        setStats(30, 56, 35, 25, 35, 72);
        setType(Type.NORMAL);
        setMove(new Confide(), new HyperFang(), new IceBeam());
    }
}