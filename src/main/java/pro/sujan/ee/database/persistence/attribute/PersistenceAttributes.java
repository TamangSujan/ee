package pro.sujan.ee.database.persistence.attribute;

import jakarta.persistence.spi.PersistenceUnitTransactionType;

public class PersistenceAttributes {
    public static final String provider = "org.hibernate.jpa.HibernatePersistenceProvider";
    public static final PersistenceUnitTransactionType transactionType = PersistenceUnitTransactionType.JTA;
}
