/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.resources;

import java.net.URI;
import java.net.URISyntaxException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;

/**
 *
 * @author SYSCO01
 */
public abstract class ResourceClientBase {

    final WebTarget resource;

    public ResourceClientBase(Client client, String baseUrl, String resourceUrl) throws URISyntaxException {
        String url = baseUrl + resourceUrl;
        resource = client.target(new URI(url));
    }
}
