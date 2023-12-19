package service;

import model.Animal;

import java.util.List;
import java.util.TreeMap;

public interface GenericService<T> {
    String add(List<T> t);
    T getById(Long id);
    List<T> getAll();
    List<T> sortByName(String ascOrDesc);  //1 ди басканда ascending, 2 ни басканда descending кылып сорттосун
    List<T> filterByGender();   //1 ди басканда female, 2 ни басканда male кылып фильтрлесин
    List<T> clear(List<T> t);
    TreeMap<String, List<T>> sortMale(List<T> t);
    TreeMap<String,List<T>> sortFemale(List<T> t);

}
