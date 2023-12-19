package dao;

import model.Person;

import java.util.List;

public interface DaoCRUD<T,ID> {
  // add
   boolean add

   (T t);
    boolean delete(List<T> t);
    T findById(ID id);

    List<T> findAll();

}
