package uade.api.bd;

import java.util.List;

public interface ICRUD<T> {


    boolean save (T t);
     boolean delete (T t);
     boolean update (T t);
     T get (T t);
     T findBy (int id);

    List<T> findAll();


}
