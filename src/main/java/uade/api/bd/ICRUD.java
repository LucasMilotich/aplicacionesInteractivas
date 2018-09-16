package uade.api.bd;

public interface ICRUD {

    <T> boolean save (T t);
    <T> boolean delete (T t);
    <T> boolean update (T t);
    <T> T get (T t);
    <T> T findBy (int id);

}
