package com.applicacionesInteractivas.bd;

import java.util.List;

public interface ICRUD<T> {


     void insert(T t);
     void delete(T t);
     void update(T t);
     T get (T t);
     T findBy (int id);

     List<T> findAll();


}
