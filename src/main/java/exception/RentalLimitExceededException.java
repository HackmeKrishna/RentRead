package main.java.exception;



public class RentalLimitExceededException extends RuntimeException {
    public RentalLimitExceededException(String message) {
        super(message);
    }
}
