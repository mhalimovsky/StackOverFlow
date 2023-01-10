package tests;

import api.BaseApi;
import api.Items;
import api.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;
import java.util.stream.Collectors;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertNotNull;

public class AnswerApiTestWithList {

    private final static String URL = "https://api.stackexchange.com/2.2/answers?site=stackoverflow&page=1&pagesize=10&order=desc&sort=activity&filter=default";


    @Test
    public void getItemsApiTest() {
        BaseApi.installSpecification(BaseApi.requestSpecification(URL), BaseApi.responseSpecification200()); // Проверка - статус код должен быть 200
        List<Items> items = given()
                .when()
                .get(URL)
                .then().log().all()
                .extract().body().jsonPath().getList("items", Items.class);
        assertTrue(items.size() <= 10); // Проверка - содержит не более 10 записей,
        items.forEach(x -> assertNotNull(x.getOwner())); //Проверка - каждый элемент массива содержит объект Owner,
        List<Owner> owner = items.stream().map(Items::getOwner).collect(Collectors.toList());
        owner.forEach(x -> Assert.assertTrue(x.getLink().contains(x.getDisplay_name().replaceAll(" ", "-").replaceAll("_", "-").toLowerCase()))); //Проверка - что link сформирован с помощью display_name
        owner.forEach(x -> Assert.assertTrue(x.getLink().contains(x.getUser_id().toString()))); //Проверка - что link сформирован с помощью user_id

    }

}
