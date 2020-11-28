/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.client.api;

import com.mobile.common.api.ResourceBase;
import com.mobile.common.core.Barcode;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoClient;
import java.util.Date;
import java.util.List;
import javax.ws.rs.core.Response;
import org.bson.types.ObjectId;
import org.mongodb.morphia.VerboseJSR303ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author LENOVO
 */
public class MobileResource extends ResourceBase {

    final static Logger LOGGER = LoggerFactory.getLogger(MobileResource.class);
    public MobileResource(MongoClient mongoClient) {
        super(mongoClient);
    }

    public Response saveBarcodeScanned(
            List<Barcode> barcodes
    ) {
        barcodes.stream().forEach(bar -> {
            bar.setId(new ObjectId().toHexString());
            bar.setSaveDate(new Date().getTime());
            saveBarcodes(bar);
        });

        return Response.ok(barcodes).build();
    }
    
    protected void saveBarcodes(Barcode bar){
        try {
            ds.save(bar);
        } catch (DuplicateKeyException | VerboseJSR303ConstraintViolationException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    public Response getBarcodesByMobileId(
            String mobileId
    ) {
        List<Barcode> barcodes = ds.find(Barcode.class)
                .field("mobileId")
                .equal(mobileId)
                .asList();

        return Response.ok(barcodes).build();
    }
}
