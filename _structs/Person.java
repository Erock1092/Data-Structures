package _structs;
public class Person{
    private String name;
    public Person(String name){
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public String toString(){
        return getName();
    }
    public void setName(String name){
        this.name = name;
    }
    public boolean equals(Object o){
        if(o == null || getClass() != o.getClass()){
            return false;
        }
        Person p = (Person) o;
        return name == p.name;
    }
}