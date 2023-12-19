package dao.Imp;

import dao.DaoCRUD;
import db.Databace;
import model.Animal;
import model.Person;

import java.util.List;

public class AnimalDaoImpl implements DaoCRUD<Animal,Long> {

    private final Databace databace;

    public AnimalDaoImpl(Databace databace) {
        this.databace = databace;
    }

    @Override
    public boolean add(Animal animal) {
        return databace.add(animal);
    }

    @Override
    public boolean delete(List<Animal>animals) {
        return databace.remove(animals);
    }

    @Override
    public Animal findById(Long id) {
        List<Animal> animalList = findAll();
        for (Animal animal : animalList) {
            if (animal.getId() == id) return animal;
        }
        throw  new RuntimeException(String.format("Animal with id : %d nod found",id));
    }

    @Override
    public List<Animal> findAll() {
        return databace.animalList();
    }


}
