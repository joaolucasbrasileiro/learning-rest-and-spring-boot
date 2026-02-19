package com.lucasbrasileiro.exception;

import java.util.Date;

public record ExceptionResponse(Date timestamp, String msg, String details) {}
