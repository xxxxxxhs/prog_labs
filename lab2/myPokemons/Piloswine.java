package myPokemons;
import ru.ifmo.se.pokemon.*;
import pokeAttacks.*;

public class Piloswine extends Swinub{
    public Piloswine(String name, int level){
        super(name, level);
        setStats(100, 100, 80, 60, 60, 50);
        setType(Type.ICE, Type.GROUND);
        setMove(new Rest(), new Bulldoze(), new IcyWind());
    }
}
