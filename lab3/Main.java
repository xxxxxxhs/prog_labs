import objects.*;
import enums.*;

public class Main{

    public static void main(String[] args) {
        // Одушевленные объекты
        Entity dunno = new Entity("Незнайка");
        Entity barking = new Entity("Лай");
        Entity dogs = new Entity("Собаки");
        Entity moonShorties = new Entity("Лунные коротышки");
        Entity nobody = new Entity("Никто");
        // Неодушевленные объекты
        Inanimate fence = new Inanimate("Забор");
        Inanimate houses = new Inanimate("Дома");
        Inanimate shops = new Inanimate("Магазины");
        // Места (окружение)
        Environment street = new Environment("Улица");
        Environment sidewalk = new Environment("Тротуар");
        Environment lowerFloors = new Environment("Нижние этажи");
//------1-предложение-------------------------------------        
        dunno.breakOut("преследования");
        dunno.run(street);
        street.surrounded(fence, Prepositions.AROUND);
//------2-предложение-------------------------------------
        barking.distributed(fence, Prepositions.FROM);
        dunno.think(dogs, "гонятся за ним");
//------3-предложение-------------------------------------
        dunno.wasScared();
        dunno.notMention("где бежал");
        dunno.comeRound(street);
//------4-предложение-------------------------------------
        dunno.saw(dogs, "пропали");
        moonShorties.go(sidewalk);
//------5-предложение-------------------------------------
        nobody.doNthnAbout(dunno);
//------6-предложение-------------------------------------
        fence.lack();
//------7-предложение-------------------------------------
        street.surrounded(houses, Prepositions.BYTWOSIDES);
        shops.located(lowerFloors);
    }
}