package pro.sujan.ee.database.utils.function;
@FunctionalInterface
public interface ReturnFunction<T> {
    T execute();
}
