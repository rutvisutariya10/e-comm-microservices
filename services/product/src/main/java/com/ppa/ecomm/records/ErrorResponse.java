package com.ppa.ecomm.records;


import java.util.Map;

public record ErrorResponse(
    Map<String, String> errors
) {

}