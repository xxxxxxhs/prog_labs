import myPokemons.*;
import ru.ifmo.se.pokemon.*;

public class Main {
    public static void main(String[] args){
        Battle b = new Battle();
        Pokemon p1 = new HoopaConfined("Mcgraegor", 5);
        Pokemon p2 = new Rattata("Mayweather", 5);
        Pokemon p3 = new Raticate("Oliveyra", 4);
        Pokemon p4 = new Swinub("Pereyra", 5);
        Pokemon p5 = new Piloswine("Makhachev", 5);
        Pokemon p6 = new Mamoswine("Edwards", 4);
        b.addAlly(p1);
        b.addAlly(p2);
        b.addAlly(p3);
        b.addFoe(p4);
        b.addFoe(p5);
        b.addFoe(p6);
        b.go();
    }

}
