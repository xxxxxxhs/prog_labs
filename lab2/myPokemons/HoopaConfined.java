package myPokemons;
import ru.ifmo.se.pokemon.*;
import pokeAttacks.*;

public class HoopaConfined extends Pokemon{
    public HoopaConfined(String name, int level){
        super(name, level);
        setStats(80, 110, 60, 150, 130, 70);
        setType(Type.PSYCHIC, Type.GHOST);
        setMove(new Swagger(), new Confide(), new Confusion(), new Psybeam());
    }
}
