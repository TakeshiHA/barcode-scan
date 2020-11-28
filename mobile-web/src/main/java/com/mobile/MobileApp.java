/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mobile.api.MobileService;
import com.mobile.client.api.MobileResource;
import com.mobile.common.CorsFilter;
import com.mongodb.MongoClient;
import io.dropwizard.Application;
import io.dropwizard.Configuration;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import io.federecio.dropwizard.swagger.SwaggerBundle;
import io.federecio.dropwizard.swagger.SwaggerBundleConfiguration;
import java.util.TimeZone;
import org.dhatim.dropwizard.jwt.cookie.authentication.JwtCookieAuthBundle;
import org.glassfish.jersey.logging.LoggingFeature;

/**
 *
 * @author LENOVO
 */
public class MobileApp extends Application<MobileAppConfig> {

    public static void main(String[] args) throws Exception {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
        new MobileApp().run(args);
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    @Override
    public void initialize(Bootstrap<MobileAppConfig> bootstrap) {
        bootstrap.addBundle(new SwaggerBundle<MobileAppConfig>() {
            @Override
            protected SwaggerBundleConfiguration getSwaggerBundleConfiguration(MobileAppConfig configuration) {
                return configuration.swaggerBundleConfiguration;
            }
        });
        bootstrap.addBundle(JwtCookieAuthBundle.getDefault().withConfigurationSupplier( (Configuration c )-> ((MobileAppConfig)c).getJwtCookieAuth()));
    }

    @Override
    public void run(MobileAppConfig config, Environment environment) throws Exception {
        MongoClient mongoClient = config.getMongoDbFactory().build(environment);
        MobileResource cr = new MobileResource(mongoClient);
        
        environment.jersey().register(new MobileService(cr));
        
        environment.jersey().register(new CorsFilter());

        environment.getObjectMapper().setSerializationInclusion(JsonInclude.Include.NON_NULL);

        environment.jersey().register(new LoggingFeature(java.util.logging.Logger.getLogger(
                getClass().getName())));

    }
    
}
