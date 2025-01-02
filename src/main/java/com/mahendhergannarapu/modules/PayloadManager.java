package com.mahendhergannarapu.modules;

import com.google.gson.Gson;
import com.mahendhergannarapu.pojos.*;

//Responsibility of PayloadManager -create a payload and return as a String
public class PayloadManager {

    // Converting the java object to the String through gson
        Gson gson;
        //Serailization
    public String createPayloadBookingAsString()
    {

        //Creating a payload with hardcoded(manually added payload)
        Booking booking = new Booking();
        booking.setFirstname("James");
        booking.setLastname("Brown");
        booking.setTotalprice(111);
        booking.setDepositpaid(true);

        Bookingdates bookingdates= new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2025-02-01");

        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");

        System.out.println(booking);

        //Convert this "booking" object to return String format
        gson = new Gson();
        String jsonStringPayload = gson.toJson(booking);
        //toJson() function -If give the object it will convert to the String format
        System.out.println(jsonStringPayload);
        return jsonStringPayload;
    }

    //Creating another function for retrive payload from Excel file in future
    //public String createPayloadBookingAsStringFromExcel()
    //{
    //}


    //Adding BookingResponse for converted String response to object
    //De-Serailization
    public BookingResponse bookingResponseJava(String responseString)
    {
        gson = new Gson();
        BookingResponse bookingResponse = gson.fromJson(responseString, BookingResponse.class);
        return bookingResponse;
    }

    //Below function do De-Serialization
    //Whatever Booking which is coming it will deserialize using gson
    public Booking getResponseFromJSON(String getResponse){
        Booking booking = gson.fromJson(getResponse,Booking.class);
        return booking;
    }


    //For GET token we required two functions
    //First Function
    public String setAuthPayload()
    {
        //Auth Object ->json String
        Auth auth = new Auth();
        auth.setUsername("admin");
        auth.setPassword("password123");
        gson =new Gson();
        String jsonPayloadString = gson.toJson(auth);
        System.out.println("Payload set to the ->" +jsonPayloadString);
        return  jsonPayloadString;
    }

    //Second Function for used for token(String) Extraction
    public String getTokenFromJSON(String tokenResponse) {
        gson = new Gson();
        TokenResponse tokenResponse1 = gson.fromJson(tokenResponse, TokenResponse.class);
        return tokenResponse1.getToken();
    }


    //    public String createPayloadBookingAsStringFromExcel() {}

    public String fullUpdatePayloadAsString() {
        Booking booking = new Booking();
        booking.setFirstname("Mahendher");
        booking.setLastname("Gannarapu");
        booking.setTotalprice(112);
        booking.setDepositpaid(true);

        Bookingdates bookingdates = new Bookingdates();
        bookingdates.setCheckin("2024-02-01");
        bookingdates.setCheckout("2024-02-05");
        booking.setBookingdates(bookingdates);
        booking.setAdditionalneeds("Breakfast");
        return gson.toJson(booking);


    }

}
