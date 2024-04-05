package com.valligustavo.springwebmongodb.domain.pet.exceptions;

public class PetNotFoundException extends RuntimeException{
    public PetNotFoundException(String message) {
        super(message);
    }
}
