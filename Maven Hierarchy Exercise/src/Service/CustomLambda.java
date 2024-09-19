package Service;

public interface CustomLambda<T, R> {
    R apply(T t);
}
