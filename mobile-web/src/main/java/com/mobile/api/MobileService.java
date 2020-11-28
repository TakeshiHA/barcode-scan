/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.api;

import com.codahale.metrics.annotation.Timed;
import com.mobile.client.api.MobileResource;
import com.mobile.common.core.Barcode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author LENOVO
 */
@Api("/mobiles")
@Path("api/mobiles")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MobileService {

    private final MobileResource cr;

    public MobileService(MobileResource cr) {
        this.cr = cr;
    }

    @POST
    @Timed
    @ApiOperation(
            value = "MBL01",
            notes = "",
            response = Response.class
    )
    public Response saveBarcodeScanned(
            @ApiParam(value = "") List<Barcode> barcodes
    ) {
        return cr.saveBarcodeScanned(barcodes);
    }

    @GET
    @Timed
    @ApiOperation(
            value = "MBL02",
            notes = "",
            response = Response.class
    )
    public Response getBarcodesByMobileId(
            @QueryParam("mobile_id") final String mobileId
    ) {
        return cr.getBarcodesByMobileId(mobileId);
    }
}
