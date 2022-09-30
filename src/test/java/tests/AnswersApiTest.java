package tests;

import api.BaseApi;
import api.Items;
import api.Owner;
import org.junit.jupiter.api.Assertions;
import org.testng.annotations.Test;

import java.util.Arrays;


import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

public class AnswersApiTest {

    private final static String URL = "https://api.stackexchange.com";

    @Test
    public void getItemsTest() {
        BaseApi.installSpecification(BaseApi.requestSpecification(URL), BaseApi.responseSpecification200());
        Items[] items = given()
                .when()
                .get("/2.2/answers?site=stackoverflow&page=1&pagesize=10&order=desc&sort=activity&filter=default")
                .then().log().all()
                .extract()
                .jsonPath()
                .getObject("items", Items[].class);
        assertTrue(items.length <= 10);
        Arrays.stream(items).forEach(x -> assertNotNull(x.getOwner()));
        Owner[] owners = Arrays.stream(items).map(x -> x.getOwner()).toArray(Owner[]::new);
        Arrays.stream(owners).forEach(x -> {
            Assertions.assertTrue(x.getLink().contains("/" + x.getUser_id().toString() + "/"));
            Assertions.assertTrue(x.getLink().endsWith("/" + x.getDisplay_name().replace(" ", "-").replace(".", "-").replace("_", "-").toLowerCase()));
        });
    }
}
