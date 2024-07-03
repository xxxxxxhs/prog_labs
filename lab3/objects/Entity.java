package objects;

import enums.*;
import interfaces.*;

public class Entity extends GeneralObj implements Move, Thoughts{

    public Entity(String name){
        super(name);
    }
    
    @Override
    public String toString(){
        return "Entity{name=" + this.getName() + "}";
    }

    public void breakOut(String addition){
        System.out.println(this.getName() + " избавился от " + addition);
    }
    @Override
    public void run(GeneralObj obj){
        System.out.println(this.getName() + " помчался по " + obj.getName());
    }
    public void distributed(GeneralObj obj, Prepositions prep){
        System.out.println(this.getName() + " раздавался " + prep.getValue() + " " + obj.getName());
    }
    @Override
    public void think(GeneralObj obj, String action){
        System.out.println(this.getName() + " думал, что " + obj.getName() + " " + action);
    }
    public void notMention(String action){
        System.out.println(this.getName() + " не замечал, " + action);
    }
    public void wasScared(){
        System.out.println(this.getName() + " боялся");
    }
    public void comeRound(Environment place){
        System.out.println(this.getName() + " начал приходить в себя на " + place.getName());
    }
    public void saw(GeneralObj obj, String action){
        System.out.println(this.getName() + " увидел, что " + obj.getName() + " " + action);
    }
    public void go(Environment place){
        System.out.println(this.getName() + " шёл по " + place.getName());
    }
    public void doNthnAbout(GeneralObj obj){
        System.out.println(this.getName() + " ничего не делал, не наносил вред " + obj.getName());
    }
}
