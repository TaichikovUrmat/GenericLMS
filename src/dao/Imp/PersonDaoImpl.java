package dao.Imp;

import dao.DaoCRUD;
import db.Databace;
import model.Person;

import java.util.List;

public class PersonDaoImpl implements DaoCRUD<Person,Long> {
    private  final Databace databace;

    public PersonDaoImpl(Databace databace) {
        this.databace = databace;
    }

    @Override
    public boolean add(Person newPerson) {
        return databace.add(newPerson) ;
    }



    @Override
    public boolean delete(List<Person> person) {
        return databace.remove(person);
    }

    @Override
    public Person findById(Long id) {
        List<Person> persons = databace.personList();
        for (Person person : persons) {
            if (id == person.getId()) return person;

        }
        throw  new RuntimeException(String.format("Loptop with id : %d nod found",id));
    }

    @Override
    public List<Person> findAll() {
        return databace.personList();
    }

}
