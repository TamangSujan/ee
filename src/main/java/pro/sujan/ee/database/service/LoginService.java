package pro.sujan.ee.database.service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.spi.PersistenceUnitInfo;
import pro.sujan.ee.database.Database;
import pro.sujan.ee.database.entity.LoginEntity;
import pro.sujan.ee.database.persistence.units.LoginPersistenceUnit;
import pro.sujan.ee.database.utils.DatabaseTransaction;

import java.util.List;

public class LoginService implements EntityService<LoginEntity, Integer>{
    @Override
    public void save(LoginEntity entity) {
        EntityManager manager = Database.getEntityManager(getPersistenceUnit());
        DatabaseTransaction.executeAndClose(manager, ()->manager.persist(entity));
    }

    @Override
    public LoginEntity findById(Integer id) {
        return null;
    }

    @Override
    public List<LoginEntity> findByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<LoginEntity> findAll() {
        return null;
    }

    @Override
    public PersistenceUnitInfo getPersistenceUnit() {
        return new LoginPersistenceUnit();
    }
}
