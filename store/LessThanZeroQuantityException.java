package store;

import java.lang.Exception;

public class LessThanZeroQuantityException extends Exception{
    LessThanZeroQuantityException(String message){
        super(message);
    }
}