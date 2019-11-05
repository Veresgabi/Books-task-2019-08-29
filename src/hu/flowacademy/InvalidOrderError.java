package hu.flowacademy;

public class InvalidOrderError extends Error {

    String t;
    String u;
    String v;

    public InvalidOrderError(String s) {
        super(s);
    }

}
