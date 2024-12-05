package org.bhekumuzi.Resources;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Utils {
    public static RequestSpecification requestSpecification;

    public static RequestSpecification RestAssuredRequestSpecification() throws IOException {
        if (requestSpecification == null) {
            requestSpecification = new RequestSpecBuilder()
                    .setBaseUri(getGlobalConfigurations("baseURL"))
                    .setContentType(ContentType.JSON)
                    .build()
                    .queryParam("key", getGlobalConfigurations("api_key") )
                    .queryParam("token", getGlobalConfigurations("api_token"));
        }
        System.out.println(">>>> " +getGlobalConfigurations("api_key"));
        return requestSpecification;
    }

    private static String getGlobalConfigurations(String key) throws IOException {
        Properties properties = new Properties();

        String path = System.getProperty("user.dir") + "/src/test/java/org/bhekumuzi/config/Global.properties";
        FileInputStream fis = new FileInputStream(path);
        properties.load(fis);
        return properties.getProperty(key);

    }



}
