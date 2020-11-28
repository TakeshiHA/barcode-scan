/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common.exception;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author JEQO
 */
public class GoAmbuAppException extends WebApplicationException {

    private final GoAmbuExceptionEnum type;

    public GoAmbuAppException(GoAmbuException e) {
        super(e, e.getType().getStatus());
        this.type = e.getType();
    }

    public GoAmbuAppException(GoAmbuExceptionEnum type) {
        super(new GoAmbuException(type), type.getStatus());
        this.type = type;
    }

    public GoAmbuExceptionEnum getExceptionType() {
        return type;
    }

    public ObjectNode getJsonMessage() {
        ObjectNode node = JsonNodeFactory.instance.objectNode();
        node.put("key", type.getKey());
        node.put("message", type.getMessage());
        return node;
    }
}
