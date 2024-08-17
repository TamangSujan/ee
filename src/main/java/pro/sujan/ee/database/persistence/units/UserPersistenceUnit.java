package pro.sujan.ee.database.persistence.units;

import pro.sujan.ee.database.entity.UserEntity;
import pro.sujan.ee.database.persistence.AbstractPersistenceUnit;

public class UserPersistenceUnit extends AbstractPersistenceUnit {
    public UserPersistenceUnit() {
        super("users", UserEntity.class);
    }
}
