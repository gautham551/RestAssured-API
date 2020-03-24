package com.volvo.gloria.GenericLibrary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

/**
 * Author: A238540
 */
public class CommonLibrary {
    public static JsonPath rawToJSON(String resp) {
        // String r = resp.toString();
        JsonPath JP = new JsonPath(resp);
        return JP;
    }

    public static String CurrentDate() {
        String hours = "T00:00:00.000Z";

        LocalDate localDate = LocalDate.now();
        String date = DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate) + "" + hours;

        return date;
    }

    public static String DateAfterSixMonths() {
        String hours = "T00:00:00.000Z";

        LocalDate localDate = LocalDate.now().plusMonths(6);
        String date = DateTimeFormatter.ofPattern("yyy-MM-dd").format(localDate) + "" + hours;

        return date;
    }

    public static String CurrentDateTime() {

        LocalDateTime localDateTime = LocalDateTime.now();
        String date = localDateTime + "" + "Z";

        return date;
    }

    public static int getRandomNum() {
        Random r = new Random();
        int num = r.nextInt(99999999);
        System.out.println(num);
        return num;
    }

}
