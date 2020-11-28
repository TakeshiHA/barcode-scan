/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import io.dropwizard.lifecycle.Managed;
import io.dropwizard.setup.Environment;
import java.net.UnknownHostException;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import org.hibernate.validator.constraints.NotEmpty;

/**
 *
 * @author LENOVO
 */
public class MongoDbFactory {

    @NotEmpty
    private String host = "localhost";

    @Min(1)
    @Max(65535)
    private int port = 27017;

    @NotEmpty
    private String username = "mobileAdmin";

    @NotEmpty
    private String password = "BnZkE4HTCcvCsUCB";

    @JsonProperty
    public String getHost() {
        return host;
    }

    @JsonProperty
    public void setHost(String host) {
        this.host = host;
    }

    @JsonProperty
    public int getPort() {
        return port;
    }

    @JsonProperty
    public void setPort(int port) {
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public MongoClient build(Environment environment) throws UnknownHostException {
        MongoClientOptions.Builder builder = MongoClientOptions.builder().connectionsPerHost(200)
                .threadsAllowedToBlockForConnectionMultiplier(20);
        final String mongoUri
                = String.format(
                        "mongodb+srv://%s:%s@%s/mobile?retryWrites=true&w=majority",
                        username,
                        password,
                        host);
        MongoClient client
                = new MongoClient(
                        new MongoClientURI(mongoUri, builder));
        environment.lifecycle().manage(new Managed() {
            @Override
            public void start() {
            }

            @Override
            public void stop() {
                client.close();
            }
        });
        return client;
    }
    
}
