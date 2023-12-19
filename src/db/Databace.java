package db;

import model.Animal;
import model.Person;

import java.util.ArrayList;
import java.util.List;

public class Databace {
 private ArrayList<Person> personArrayList = new ArrayList<>();
 private ArrayList<Animal> animalArrayList = new ArrayList<>();

 public <T> Boolean add(T type) {
     if (type instanceof Person) {
     return personArrayList.add((Person) type);
        }
     else if (type instanceof Animal){
   return animalArrayList.add((Animal) type);
       }
  throw  new RuntimeException("Incorrect type!");
   }


   public <T> Boolean remove(T type){
       if (type instanceof Person){
        return personArrayList.remove((Person) type);
       }
       else if (type instanceof  Animal){
        return animalArrayList.remove((Animal)type);
       }
       throw new RuntimeException("Invalid remove");
   }


   public  List<Person> personList(){
         return personArrayList;
   }
   public List<Animal> animalList(){
         return animalArrayList;
   }
}

