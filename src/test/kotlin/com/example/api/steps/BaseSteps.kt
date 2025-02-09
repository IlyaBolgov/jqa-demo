package com.example.api.steps

import io.restassured.builder.RequestSpecBuilder
import io.restassured.filter.log.RequestLoggingFilter
import io.restassured.filter.log.ResponseLoggingFilter
import io.restassured.http.ContentType
import io.restassured.specification.RequestSpecification
import java.nio.charset.StandardCharsets


abstract class BaseSteps(
    url: String = "https://jsonplaceholder.typicode.com/"
) {
    protected val requestSpecification: RequestSpecification = RequestSpecBuilder()
        .setContentType(ContentType.JSON.withCharset(StandardCharsets.UTF_8))
        .setAccept(ContentType.ANY)
        .setBaseUri(url)
        .addFilter(ResponseLoggingFilter())
        .addFilter(RequestLoggingFilter())
        .build()
}
