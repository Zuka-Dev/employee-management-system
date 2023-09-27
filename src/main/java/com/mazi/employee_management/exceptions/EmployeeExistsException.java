package com.mazi.employee_management.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EmployeeExistsException extends RuntimeException{

    public EmployeeExistsException(String message) {
        super(message);
    }


}
