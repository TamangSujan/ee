package pro.sujan.ee.database.persistence;

import jakarta.persistence.SharedCacheMode;
import jakarta.persistence.ValidationMode;
import jakarta.persistence.spi.ClassTransformer;
import jakarta.persistence.spi.PersistenceUnitInfo;
import jakarta.persistence.spi.PersistenceUnitTransactionType;
import pro.sujan.ee.database.Database;
import pro.sujan.ee.database.persistence.attribute.PersistenceAttributes;

import javax.sql.DataSource;
import java.net.URL;
import java.util.List;
import java.util.Properties;

public class AbstractPersistenceUnit implements PersistenceUnitInfo {
    private final String entityName;
    private final String classPath;
    public AbstractPersistenceUnit(String entityName, Class<?> entityClass){
        this.entityName = entityName;
        this.classPath = entityClass.getName();
    }
    @Override
    public String getPersistenceUnitName() {
        return entityName;
    }

    @Override
    public String getPersistenceProviderClassName() {
        return PersistenceAttributes.provider;
    }

    @Override
    public PersistenceUnitTransactionType getTransactionType() {
        return PersistenceAttributes.transactionType;
    }

    @Override
    public DataSource getJtaDataSource() {
        return Database.getDataSource();
    }

    @Override
    public DataSource getNonJtaDataSource() {
        return null;
    }

    @Override
    public List<String> getMappingFileNames() {
        return null;
    }

    @Override
    public List<URL> getJarFileUrls() {
        return null;
    }

    @Override
    public URL getPersistenceUnitRootUrl() {
        return null;
    }

    @Override
    public List<String> getManagedClassNames() {
        return List.of(classPath);
    }

    @Override
    public boolean excludeUnlistedClasses() {
        return false;
    }

    @Override
    public SharedCacheMode getSharedCacheMode() {
        return null;
    }

    @Override
    public ValidationMode getValidationMode() {
        return null;
    }

    @Override
    public Properties getProperties() {
        return null;
    }

    @Override
    public String getPersistenceXMLSchemaVersion() {
        return null;
    }

    @Override
    public ClassLoader getClassLoader() {
        return null;
    }

    @Override
    public void addTransformer(ClassTransformer classTransformer) {

    }

    @Override
    public ClassLoader getNewTempClassLoader() {
        return null;
    }
}
