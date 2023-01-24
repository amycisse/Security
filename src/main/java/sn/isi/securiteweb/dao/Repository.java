package sn.isi.securiteweb.dao;

import java.util.List;

public interface Repository <T> {

    public void beginSession();
    public int add(T t);

    public int delete(int id, T t);

    public int update(T t);

    public  List<T> list(T t);

    public T get(int id, T t);
}
