package pro.sujan.ee.database.utils;

import jakarta.persistence.EntityManager;
import pro.sujan.ee.database.utils.function.ReturnFunction;
import pro.sujan.ee.database.utils.function.VoidFunction;

public class DatabaseTransaction {
    public static void executeAndClose(EntityManager entityManager, VoidFunction transaction){
        entityManager.getTransaction().begin();
        transaction.execute();
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public static <T> T executeAndClose(EntityManager entityManager, ReturnFunction<T> transaction){
        entityManager.getTransaction().begin();
        T t = transaction.execute();
        entityManager.getTransaction().commit();
        return t;
    }
}
