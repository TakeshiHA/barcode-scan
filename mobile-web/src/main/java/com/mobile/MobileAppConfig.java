/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mobile.common.MongoDbFactory;
import io.dropwizard.Configuration;
import io.dropwizard.client.JerseyClientConfiguration;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import org.dhatim.dropwizard.jwt.cookie.authentication.JwtCookieAuthConfiguration;

/**
 *
 * @author LENOVO
 */
public class MobileAppConfig extends Configuration {

    @Valid
    @NotNull
    @JsonProperty
    private final JerseyClientConfiguration httpClient = new JerseyClientConfiguration();

    @Valid
    @NotNull
    private JwtCookieAuthConfiguration jwtCookieAuth = new JwtCookieAuthConfiguration();

    @Valid
    @NotNull
    private MongoDbFactory mongoDbFactory = new MongoDbFactory();

    @JsonProperty("swagger")
    public SwaggerBundleConfiguration swaggerBundleConfiguration;

    public JerseyClientConfiguration getJerseyClientConfiguration() {
        return httpClient;
    }

    @JsonProperty("jwtCookieAuth")
    public JwtCookieAuthConfiguration getJwtCookieAuth() {
        return jwtCookieAuth;
    }

    @JsonProperty("jwtCookieAuth")
    public void setJwtCookieAuth(JwtCookieAuthConfiguration jwtCookieAuth) {
        this.jwtCookieAuth = jwtCookieAuth;
    }

    @JsonProperty("mongodb")
    public MongoDbFactory getMongoDbFactory() {
        return mongoDbFactory;
    }

    @JsonProperty("mongodb")
    public void setMongoDbFactory(MongoDbFactory mongoDbFactory) {
        this.mongoDbFactory = mongoDbFactory;
    }
    
}
