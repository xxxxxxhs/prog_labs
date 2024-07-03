package objects;

public abstract class GeneralObj {
    
    private String name;

    public GeneralObj(String name){
        this.name = name;
    }
    @Override
    public boolean equals(Object obj){
        return this.hashCode() == obj.hashCode();
    }
    @Override
    public int hashCode(){
        return super.hashCode() + this.getName().hashCode();
    }
    public String getName(){
        return name;
    }
    
}
