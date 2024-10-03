package com.example.exception.handler;

import com.example.exception.type.BadRequestException;
import com.example.model.ErrorResponse;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider
public class BadRequestExceptionMapper implements ExceptionMapper<BadRequestException> {
    @Override
    public Response toResponse(BadRequestException exception) {
        ErrorResponse errorResponse = new ErrorResponse(400, exception.getMessage());
        return Response.status(400).entity(errorResponse).build();
    }
}
