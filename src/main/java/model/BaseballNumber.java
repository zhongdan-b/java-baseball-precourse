package model;

public class BaseballNumber {
    private int number;

    boolean isValid(){
        return number >= 111 && number <= 999;
    }
}
