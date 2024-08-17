package pro.sujan.ee.database.persistence.units;

import pro.sujan.ee.database.entity.LoginEntity;
import pro.sujan.ee.database.persistence.AbstractPersistenceUnit;

public class LoginPersistenceUnit extends AbstractPersistenceUnit {
    public LoginPersistenceUnit() {
        super("login", LoginEntity.class);
    }
}
