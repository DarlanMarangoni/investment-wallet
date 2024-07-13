package com.wallet.investmenthistory;

import io.quarkus.google.cloud.functions.test.FunctionType;
import io.quarkus.google.cloud.functions.test.WithFunction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
@WithFunction(FunctionType.RAW_BACKGROUND)
class RawBackgroundFunctionPubSubTest {

    @Test
    void accept() {
        given()
                .body("{\"data\":{\"name\":\"hello.txt\"}}")
                .when()
                .post()
                .then()
                .statusCode(200);
    }
}