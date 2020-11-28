/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common.core;

/**
 *
 * @author LENOVO
 */
public class Bounds {
    private Points origin;
    private Size size;

    public Bounds() {
    }

    public Points getOrigin() {
        return origin;
    }

    public void setOrigin(Points origin) {
        this.origin = origin;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }
}
