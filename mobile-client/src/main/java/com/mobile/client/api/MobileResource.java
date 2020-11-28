/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.client.api;

import com.mobile.common.api.ResourceBase;
import com.mobile.common.core.Barcode;
import com.mobile.common.exception.GoAmbuAppException;
import com.mobile.common.exception.GoAmbuException;
import com.mobile.common.exception.GoAmbuExceptionEnum;
import com.mongodb.DuplicateKeyException;
import com.mongodb.MongoClient;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
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
            try {
                saveBarcodes(bar);
            } catch (GoAmbuException ex) {
                LOGGER.error(ex.getMessage(), ex);
                throw new GoAmbuAppException(ex);
            }
        });

        return Response.ok(barcodes).build();
    }

    protected void saveBarcodes(Barcode bar) throws GoAmbuException {
        try {
            ds.save(bar);
        } catch (DuplicateKeyException | VerboseJSR303ConstraintViolationException e) {
            throw new GoAmbuException(GoAmbuExceptionEnum.EXC003, e);
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
