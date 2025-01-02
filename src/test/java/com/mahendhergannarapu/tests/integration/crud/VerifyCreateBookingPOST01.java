package com.mahendhergannarapu.tests.integration.crud;

import com.mahendhergannarapu.baseTest.BaseTest;
import com.mahendhergannarapu.endpoints.APIConstants;
import com.mahendhergannarapu.pojos.BookingResponse;
import io.qameta.allure.Link;
import io.qameta.allure.Owner;
import io.qameta.allure.TmsLink;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import io.qameta.allure.Description;

import static org.assertj.core.api.Assertions.*;

public class VerifyCreateBookingPOST01 extends BaseTest {

//    @Owner("Mahendher")
//    @TmsLink("url") //Adding link here about jira testcase link
//    @Link(name = "Link to TC", url ="url"
//    @Issue("JIRA_RBT-4")  //Testcase issue number
    @Description("Verify that POST request working fine")
    @Test
    public void testVerifyCreateBookingPOST01()
    {
        //Setup the base path
        requestSpecification
                .basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);

        //Setting the response
        //We need to give basically body
        //Here payloadManager given the payload
        response =
                RestAssured
                        .given(requestSpecification)
                        .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();
        validatableResponse.statusCode(200);

        //Below given three ways to validate we can use any one.
        //1.Default Rest Assured
        //2.AssertJ
        //3.TestNG Assertions
        //But mostly we are using AssertJ

        //Default Rest Assured - Validation -
        validatableResponse.body("booking.firstname", Matchers.equalTo("James"));


        //When we have payload manager we can verify give this to de-serialization
        //We have converted Everything from the JSON-string we are converting back to BookingResponse class
        //We are verify using AssertJ
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        // AssertJ
        // assertActions.verifyStringKey(bookingResponse.getBooking().getFirstname(),"James");
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("James");


        // TestNG Assertions
        assertActions.verifyStatusCode(response, 200);
        assertActions.verifyResponseBody(bookingResponse.getBooking().getFirstname(), "James", "Verify the First Name");



    }

}
