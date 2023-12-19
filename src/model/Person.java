package model;

import java.util.Comparator;

public class Person  implements Comparable<Person> {
    private long id;
    private String name;
    private int age;
    private Genders genders;

//    public Person() {
//    }

    public Person(long id, String name, int age, Genders genders) {
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
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", genders=" + genders +
                '}';
    }


    public static Comparator<Person> sortByPersonName = new Comparator<Person>(){

        @Override
        public int compare(Person o1, Person o2) {
            return o1.name.compareTo(o2.name);
        }
    };
    public static Comparator<Person> sortByPersonYear = new Comparator<Person>() {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.compareTo(o2);
        }
    };

    @Override
    public int compareTo(Person o) {
        return this.name.compareTo(o.getName());
    }
}
