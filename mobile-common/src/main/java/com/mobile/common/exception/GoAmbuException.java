/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common.exception;

/**
 *
 * @author JEQO
 */
public class GoAmbuException extends Exception{

    GoAmbuExceptionEnum type;

    public GoAmbuExceptionEnum getType() {
        return type;
    }

    public GoAmbuException(GoAmbuExceptionEnum type) {
        super(type.getMessage());
        this.type = type;
    }

    public GoAmbuException(GoAmbuExceptionEnum type, Throwable t) {
        super(type.getMessage(), t);
        this.type = type;
    }
    
}
