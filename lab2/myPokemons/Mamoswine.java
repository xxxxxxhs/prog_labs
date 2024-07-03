package myPokemons;
import ru.ifmo.se.pokemon.*;
import pokeAttacks.*;

public class Mamoswine extends Piloswine{
    public Mamoswine(String name, int level){
        super(name, level);
        setStats(110, 130, 80, 70, 60, 80);
        setType(Type.ICE, Type.GROUND);
        setMove(new Rest(), new Bulldoze(), new IcyWind(), new DoubleHit());
    }
}
