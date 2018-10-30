package com.applicacionesInteractivas.bd;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface ICRUD<T> {


     void insert(T t);
     void delete(T t);
     void update(T t);
     T get (T t);
     T findBy (int id) throws SQLException;

     List<T> findAll();

     T mapToEntity(ResultSet rs) throws SQLException;


}
