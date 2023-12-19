package service.Impl;

import dao.Imp.PersonDaoImpl;
import db.Databace;
import model.Animal;
import model.Genders;
import model.Person;
import service.GenericService;
import service.PersonService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class PersonServiceImpl implements GenericService<Person>{

    Databace databace = new Databace();
    private final PersonDaoImpl personDao;

    public PersonServiceImpl(PersonDaoImpl personDao) {
        this.personDao = personDao;
    }


    @Override
    public String add(List<Person> person) {
        for (Person person1 : person) {
            personDao.add(person1);
        }
        return "Saktaldy!";
    }

    @Override
    public Person getById(Long id) {

        return personDao.findById(id);
    }

    @Override
    public List<Person> getAll() {
        return personDao.findAll();
    }

    @Override
    public List<Person> sortByName(String ascOrDesc) {
        LinkedList<Person> movieLinkedListSort = new LinkedList<>(personDao.findAll());

        if ("asc".equalsIgnoreCase(ascOrDesc)) {
            movieLinkedListSort.sort(Person.sortByPersonName);

        }else {
            movieLinkedListSort.sort(Person.sortByPersonYear.reversed());
        }
//       if (movieLinkedListSort.equals(personDao.findAll()));
//
//         for (Person movie : movieLinkedListSort) {
//            System.out.println(movie);

        return movieLinkedListSort;
    }



    @Override
    public List<Person> filterByGender() {


        return null;
    }

    @Override
    public List<Person> clear(List<Person> personList) {
        personDao.findAll().clear();
        return personDao.findAll() ;
    }

    @Override
    public TreeMap<String, List<Person>> sortMale(List<Person> personList) {
        TreeMap<String,List<Person>> map = new TreeMap<>();

        for (Person person : personList) {

            String name = String.valueOf(Genders.MALE);

            if (!map.containsValue(name)){
                map.put(name,new ArrayList<>());
            }
            map.get(name).add(person);
        }

        return  map;
    }

    @Override
    public TreeMap<String, List<Person>> sortFemale(List<Person> personList) {
        TreeMap<String,List<Person>> map = new TreeMap<>();

        for (Person person : personList) {
            String name = String.valueOf(Genders.FEMALE);
            if (!map.containsKey(name)){
                map.put(name,new ArrayList<>());
            }
            map.get(name).add(person);
        }
        return map;
    }
}
