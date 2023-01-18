package config.exception;

public class CuisineNotFoundException extends RuntimeException{

    public CuisineNotFoundException() {
        super();
    }

    public CuisineNotFoundException(String message) {
        super(message);
    }

}
