/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common;

import com.mobile.common.exception.GoAmbuAppException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author JEQO
 */
@Provider
public class GoAmbuExceptionHandler implements ExceptionMapper<GoAmbuAppException> {

    @Override
    public Response toResponse(GoAmbuAppException exception) {
        return Response
                .status(exception.getResponse().getStatus())
                .type(MediaType.APPLICATION_JSON)
                .entity(exception.getJsonMessage())
                .build();
    }

}
