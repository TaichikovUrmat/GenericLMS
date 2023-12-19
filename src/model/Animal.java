package model;

import java.util.Comparator;

public class Animal implements Comparator<Animal> {
    private long id;
    private String name;
    private int age;
    private Genders genders;

    public Animal(long id, String name, int age, Genders genders) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.genders = genders;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Genders getGenders() {
        return genders;
    }

    public void setGenders(Genders genders) {
        this.genders = genders;
    }

    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", genders='" + genders + '\'' +
                '}';
    }

    @Override
    public int compare(Animal o1, Animal o2) {
        return o1.getName().compareTo(o2.getName());
    }


    public static Comparator<Animal> sortByPersonAsc = new Comparator<Animal>(){

        @Override
        public int compare(Animal o1, Animal o2) {
            return o1.getName().compareTo(o2.getName());
        }
    };
    public static Comparator<Animal> sortByPersonDesc = new Comparator<Animal>() {

        @Override
        public int compare(Animal o1, Animal o2) {
            return o2.getName().compareTo(o1.getName());
        }
    };
}
