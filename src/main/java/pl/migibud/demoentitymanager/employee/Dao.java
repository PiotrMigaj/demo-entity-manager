package pl.migibud.demoentitymanager.employee;

import java.util.List;

public interface Dao<T,ID> {
    T findById(ID id);
    T save(T entity);
    List<T> findAll();
}
