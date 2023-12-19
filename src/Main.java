import dao.Imp.AnimalDaoImpl;
import dao.Imp.PersonDaoImpl;
import db.Databace;
import model.Animal;
import model.Genders;
import model.Person;
import service.GenericService;
import service.Impl.AnimalServiceImpl;

import service.Impl.PersonServiceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Databace databace = new Databace();

        GenericService personService = new PersonServiceImpl(new PersonDaoImpl(databace));
        GenericService animalService = new AnimalServiceImpl(new AnimalDaoImpl(databace));

        List<Person> personList = new ArrayList<>(List.of(
                new Person(1,"Urmat",20, Genders.MALE),
                new Person(2,"Beki",18, Genders.MALE),
                new Person(3,"jigit",21, Genders.MALE),
                new Person(4,"Mirlan",24, Genders.MALE),
                new Person(5,"Edo",22, Genders.MALE),
                new Person(6,"Kutman",21, Genders.MALE)
        ));
                 personService.add(personList);



        List<Animal> animalList = new ArrayList<>(List.of(
                new Animal(1,"Cad",5,Genders.FEMALE),
                new Animal(2,"Goot",5,Genders.FEMALE),
                new Animal(3,"Sheep",5,Genders.FEMALE),
                new Animal(4,"fox",5,Genders.MALE),
                new Animal(5,"Dog",5,Genders.FEMALE)
        ));
                 animalService.add(animalList);

        while (true) {
          System.out.println("""
                 Person:                           Animal:    
                   1. getById(Long id);          8. getById
                   2. getAll();                  9. getAll
                    sortByName();                 sortByName
                   3. sort asc                   10. sort asc
                   4. sort desc                  11. sort desc
                     filterByGende                filterByGender
                   5. sort Mala                  12. sort Male
                   6. sort Female                13. sort Female
                   7. clear();                   14. clear 
                           
                  """);
          switch (sc.nextLine()) {
              case "1" -> System.out.println(personService.getById(1L));
              case "2" -> System.out.println(personService.getAll());
              case "3" -> System.out.println(personService.sortByName("asc"));
              case "4"-> System.out.println(personService.sortByName("desc"));
              case "5"-> System.out.println(personService.sortMale(personList));
              case "6"-> System.out.println(personService.sortFemale(personList));
              case "7"-> System.out.println(personService.clear(personList));
              case "8"-> System.out.println(animalService.getById(1L));
              case "9"-> System.out.println(animalService.getAll());
              case "10"-> System.out.println(animalService.sortByName("asc"));
              case "11"-> System.out.println(animalService.sortByName("desc"));
              case "12"-> System.out.println(animalService.sortMale(animalList));
              case "13"-> System.out.println(animalService.sortFemale(animalList));
              case "14"-> System.out.println(animalService.clear(animalList));
          }
      }

    }

}