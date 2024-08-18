package pro.sujan.ee.database.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.spi.PersistenceUnitInfo;
import pro.sujan.ee.database.Database;
import pro.sujan.ee.database.entity.UserEntity;
import pro.sujan.ee.database.persistence.units.UserPersistenceUnit;
import pro.sujan.ee.database.utils.DatabaseTransaction;

import java.io.Serializable;
import java.util.List;

@Named
@ApplicationScoped
public class UserService implements EntityService<UserEntity, Integer>, Serializable {
    @Override
    public void save(UserEntity user) {
        EntityManager userManager = Database.getEntityManager(getPersistenceUnit());
        DatabaseTransaction.executeAndClose(userManager, ()->userManager.persist(user));
    }

    @Override
    public UserEntity findById(Integer id) {
        EntityManager userManager = Database.getEntityManager(getPersistenceUnit());
        return DatabaseTransaction.executeAndClose(userManager, ()->userManager.find(UserEntity.class, id));
    }

    @Override
    public List<UserEntity> findByIds(List<Integer> ids) {
        return null;
    }

    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public PersistenceUnitInfo getPersistenceUnit() {
        return new UserPersistenceUnit();
    }

}
