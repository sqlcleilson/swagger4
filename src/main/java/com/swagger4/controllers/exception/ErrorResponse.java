package com.swagger4.controllers.exception;

public record ErrorResponse(Integer status, String error, String message) {
}
