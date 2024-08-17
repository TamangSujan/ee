package pro.sujan.ee.database;


import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.spi.PersistenceUnitInfo;
import org.hibernate.jpa.HibernatePersistenceProvider;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

public class Database {
    private static final DataSource dataSource;
    private static final HibernatePersistenceProvider provider;
    private static final Map<String, String> providerProperties;
    static {
        try {
            dataSource = (DataSource) new InitialContext().lookup("java:/MySqlDS");
            provider = new HibernatePersistenceProvider();
            providerProperties = new HashMap<>();

            providerProperties.put("hibernate.hbm2ddl.auto", "update");
            providerProperties.put("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }

    public static EntityManager getEntityManager(PersistenceUnitInfo unitInfo){
        return provider.createContainerEntityManagerFactory(unitInfo, providerProperties)
                .createEntityManager();
    }
}
