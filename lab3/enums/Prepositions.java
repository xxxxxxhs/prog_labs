package enums;

public enum Prepositions{
    BYTWOSIDES("с обеих сторон"), BEHIND("позади"), AROUND("вокруг"), FROM("из-за");

    private String value;

    Prepositions(String value){
        this.value = value;
    }

    public String getValue(){
        return value;
    }
}
