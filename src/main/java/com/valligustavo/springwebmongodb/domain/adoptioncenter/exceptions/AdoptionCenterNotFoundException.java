package com.valligustavo.springwebmongodb.domain.adoptioncenter.exceptions;

public class AdoptionCenterNotFoundException extends RuntimeException{
    public AdoptionCenterNotFoundException(String message) {
        super(message);
    }
}
