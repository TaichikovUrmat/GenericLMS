package service.Impl;

import dao.Imp.AnimalDaoImpl;
import model.Animal;
import model.Genders;
import model.Person;
import service.AnimalService;
import service.GenericService;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

public class AnimalServiceImpl implements GenericService<Animal> , AnimalService {
  private final AnimalDaoImpl animalDao;

    public AnimalServiceImpl(AnimalDaoImpl animalDao) {
        this.animalDao = animalDao;
    }


    @Override
    public String add(List<Animal> animals) {
        for (Animal animal : animals) {
            animalDao.add(animal);
        }
        return "Caktalday";
    }

    @Override
    public Animal getById(Long id) {

        return  animalDao.findById(id);
    }

    @Override
    public List<Animal> getAll() {
        return animalDao.findAll();
    }

    @Override
    public List<Animal> sortByName(String ascOrDesc) {

        LinkedList<Animal> movieLinkedListSort = new LinkedList<>(animalDao.findAll());

        if ("asc".equalsIgnoreCase(ascOrDesc)) {
            movieLinkedListSort.sort(Animal.sortByPersonAsc);

        }else {
            movieLinkedListSort.sort(Animal.sortByPersonDesc);
        }
//       if (movieLinkedListSort.equals(personDao.findAll()));
//
//         for (Person movie : movieLinkedListSort) {
//            System.out.println(movie);

        return movieLinkedListSort;

    }

    @Override
    public List<Animal> filterByGender() {
        return null;
    }

    @Override
    public List<Animal> clear(List<Animal> animalList) {
        animalDao.findAll().clear();
        return animalDao.findAll();
    }

    @Override
    public TreeMap<String, List<Animal>> sortMale(List<Animal> animals) {
        TreeMap<String,List<Animal>> map = new TreeMap<>();

        for (Animal animal : animals) {
            String name = String.valueOf(Genders.MALE);
            if (!map.containsValue(name)){
                map.put(name,new ArrayList<>());
            }
            map.get(name).add(animal);
        }
        return  map;
    }

    @Override
    public TreeMap<String, List<Animal>> sortFemale(List<Animal> animals) {
        TreeMap<String,List<Animal>> map = new TreeMap<>();

        for (Animal animal : animals) {
            String name = String.valueOf(Genders.FEMALE);
            if (!map.containsKey(name)){
                map.put(name,new ArrayList<>());
            }
            map.get(name).add(animal);
        }
        return map;
    }
}
