package com.wish.WishTaskManagement.TaskManagement.exceptions;

public class DataExistsValidation extends RuntimeException{
    public DataExistsValidation(String message){
        super(message);
    }
}
