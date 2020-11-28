/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common.api;

import com.mongodb.MongoClient;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.ValidationExtension;

/**
 *
 * @author JEQO
 */
public class ResourceBase {

    public Datastore ds;

    public ResourceBase(MongoClient mongoClient) {
        Morphia morphia = new Morphia();
        ds = morphia.mapPackage("com.mobile.common.core")
                .createDatastore(mongoClient, "mobile");
        ds.ensureIndexes();
        ValidationExtension validationExtension = new ValidationExtension(morphia);
        validationExtension.getClass();
        
    }
}
