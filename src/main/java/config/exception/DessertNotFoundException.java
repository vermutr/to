package config.exception;

public class DessertNotFoundException extends RuntimeException{
    public DessertNotFoundException() {
        super();
    }

    public DessertNotFoundException(String message) {
        super(message);
    }

}