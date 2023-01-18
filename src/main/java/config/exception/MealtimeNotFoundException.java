package config.exception;

public class MealtimeNotFoundException extends RuntimeException{

    public MealtimeNotFoundException() {
        super();
    }

    public MealtimeNotFoundException(String message) {
        super(message);
    }

}
