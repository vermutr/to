package config.exception;

public class MainDishNotFoundException extends RuntimeException {

    public MainDishNotFoundException() {
        super();
    }

    public MainDishNotFoundException(String message) {
        super(message);
    }
}
