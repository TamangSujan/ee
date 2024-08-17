package pro.sujan.ee.database.service;

import jakarta.persistence.spi.PersistenceUnitInfo;

import java.util.List;

public interface EntityService<T, R> {
    void save(T entity);
    T findById(R id);
    List<T> findByIds(List<R> ids);
    List<T> findAll();
    PersistenceUnitInfo getPersistenceUnit();
}
