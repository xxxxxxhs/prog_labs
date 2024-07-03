package objects;

public class Inanimate extends GeneralObj{
    
    public Inanimate(String name){
        super(name);
    }
    public void lack(){
        System.out.println(this.getName() + " здесь отсутствовал");
    }
    public void located(Environment place){
        System.out.println(this.getName() + " находится на " + place.getName());
    }
}
