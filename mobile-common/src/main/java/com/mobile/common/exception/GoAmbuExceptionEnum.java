/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobile.common.exception;

import javax.ws.rs.core.Response.Status;

/**
 *
 * @author JEQO
 */
public enum GoAmbuExceptionEnum {

    EXC001("EXC001", "Resource does not exist", Status.BAD_REQUEST),
    EXC002("EXC002", "Error changing status. New status not allowed.", Status.INTERNAL_SERVER_ERROR),
    EXC003("EXC003", "Error creating resource. Check duplicated values or incomplete data.", Status.INTERNAL_SERVER_ERROR),
    EXC004("EXC004", "Error registrating attention request. Client does not exist", Status.BAD_REQUEST),
    EXC005("EXC005", "Error registrating attention request. Client is not approved", Status.INTERNAL_SERVER_ERROR),
    EXC006("EXC006", "Error registrating attention request. Attention is invalid", Status.INTERNAL_SERVER_ERROR),
    EXC007("EXC007", "Error updating medical history. Medical history does not exist", Status.INTERNAL_SERVER_ERROR),
    EXC008("EXC008", "Error updating client. Client does not exist", Status.INTERNAL_SERVER_ERROR),
    EXC009("EXC009", "Error updating emergency unit. Emergency unit does not exist", Status.INTERNAL_SERVER_ERROR),
    EXC010("EXC010", "Error rejecting a client. Client does not exist", Status.INTERNAL_SERVER_ERROR),
    EXC011("EXC011", "Error rejecting a client. Client is from other organization", Status.INTERNAL_SERVER_ERROR),
    EXC012("EXC012", "Error rejecting a client. New status not allowed", Status.INTERNAL_SERVER_ERROR),    
    EXC013("EXC013", "Error sending notification.", Status.INTERNAL_SERVER_ERROR),
    EXC014("EXC014", "Error creating user.", Status.INTERNAL_SERVER_ERROR),
    EXC015("EXC015", "Encryption error.", Status.INTERNAL_SERVER_ERROR),
    EXC016("EXC016", "Clients organizations is different from Organization.", Status.BAD_REQUEST),
    EXC017("EXC017", "Resource Client error. Problems on URI", Status.INTERNAL_SERVER_ERROR),
    EXC018("EXC018", "User does not exist", Status.BAD_REQUEST),
    EXC019("EXC019", "Password is incorrect", Status.BAD_REQUEST),
    EXC020("EXC020", "Attentions emergency unit is different from Emergency Unit.", Status.BAD_REQUEST),
    EXC021("EXC021", "Status must be sent.", Status.BAD_REQUEST),
    EXC022("EXC022", "ID from URL is different from Entity.", Status.BAD_REQUEST),
    EXC023("EXC023", "Clients user is different from User.", Status.BAD_REQUEST),
    EXC024("EXC024", "URL parameter is not included in the request.", Status.BAD_REQUEST),
    EXC025("EXC025", "Clients Medical History is different from Medical History.", Status.BAD_REQUEST),
    EXC026("EXC026", "User is blocked", Status.FORBIDDEN),
    EXC027("EXC027", "Wrong username or token. Password does not change", Status.BAD_REQUEST),
    EXC028("EXC028", "Error updating Attention.", Status.INTERNAL_SERVER_ERROR),
    EXC029("EXC029", "Error updating EmergencyUnit, is not included emergencyUnitId.", Status.BAD_REQUEST),
    EXC030("EXC030", "Error in the request", Status.BAD_REQUEST),
    EXC031("EXC031", "Medical result does not exist", Status.BAD_REQUEST),
    EXC032("EXC032", "Medical Result is different from Organization.", Status.BAD_REQUEST),
    EXC033("EXC033", "Patient exist.", Status.BAD_REQUEST),
    EXC034("EXC034", "Coupon is not found.", Status.BAD_REQUEST),
    EXC035("EXC035", "Client does not exist", Status.BAD_REQUEST),
    EXC036("EXC036", "User is not active", Status.INTERNAL_SERVER_ERROR),
    EXC037("EXC037", "Document does not exist", Status.BAD_REQUEST),
    EXC038("EXC038", "Document has expired", Status.BAD_REQUEST),
    EXC039("EXC039", "Número de documento duplicado", Status.BAD_REQUEST),
    EXC040("EXC040", "Correo duplicado", Status.BAD_REQUEST),
    EXC041("EXC041", "Partner cannot do this request", Status.BAD_REQUEST),    
    EXC042("EXC042", "Tokenization Error", Status.BAD_REQUEST),
    EXC043("EXC043", "User not identified", Status.BAD_REQUEST),
    EXC044("EXC044", "Invalid Token", Status.UNAUTHORIZED),
    EXC045("EXC045", "Conflict of data", Status.BAD_REQUEST),
    EXC046("EXC046", "Su tarjeta no tiene fondos suficientes. Para realizar la compra, verifica tus fondos disponibles con el banco emisor o inténta nuevamente con otra tarjeta.", Status.BAD_REQUEST),
    EXC047("EXC047", "Stolen Cards", Status.BAD_REQUEST),
    EXC048("EXC048", "La operación ha sido denegada por la entidad emisora de tu tarjeta. Contáctate con el banco para conocer el motivo de la denegación.", Status.BAD_REQUEST),
    EXC049("EXC049", "La operación ha sido denegada por la entidad emisora de tu tarjeta. Contáctate con el banco para conocer el motivo de la denegación o intenta nuevamente con otra tarjeta.", Status.BAD_REQUEST),
    EXC050("EXC050", "El código de seguridad (CVV) es incorrecto. Verifica tu tarjeta e ingresa los dígitos correctamente. Si es denegada nuevamente, contáctate con el banco emisor de tu tarjeta.", Status.BAD_REQUEST),
    EXC051("EXC051", "El banco emisor de tu tarjeta no responde y la operación no pudo ser completada. Vuelve a realizar el pago en unos minutos o intenta nuevamente con otra tarjeta.", Status.BAD_REQUEST),
    EXC052("EXC052", "La operación ha sido denegada por la entidad emisora de tu tarjeta. Contáctate con el banco para conocer el motivo de la denegación o intenta nuevamente con otra tarjeta.", Status.BAD_REQUEST),
    EXC053("EXC053", "Invalid Card", Status.BAD_REQUEST),
    EXC054("EXC054", "Ocurrió un error mientras procesabamos tu compra. Contáctate con culqi.com/soporte para que te demos una solución.", Status.BAD_REQUEST),
    EXC055("EXC055", "Fraudulent", Status.BAD_REQUEST),
    EXC056("EXC056", "Sale Declined", Status.BAD_REQUEST),
    EXC057("EXC057", "Lo sentimos, su operación fue rechazada. Contáctanos para más detalle.", Status.BAD_REQUEST),
    EXC058("EXC058", "Only have one patient", Status.BAD_REQUEST),
    EXC059("EXC059", "Can't erase yourself", Status.BAD_REQUEST),
    EXC060("EXC060", "The patient have membership", Status.BAD_REQUEST),
    EXC061("EXC061", "Error cancel subscription", Status.BAD_REQUEST),
    EXC062("EXC062", "The new password and your password is the same", Status.BAD_REQUEST),
    EXC063("EXC063", "The patient is affiliated with another user", Status.BAD_REQUEST),
    EXC064("EXC064", "City does not exist in the country", Status.BAD_REQUEST),
    EXC065("EXC065", "The patient is already in follow", Status.BAD_REQUEST),
    EXC066("EXC066", "El número de documento no tiene el tamaño correcto", Status.BAD_REQUEST),
    EXC067("EXC067", "El número de documento debe ser alfanumerico", Status.BAD_REQUEST),
    EXC068("EXC068", "El número de documento debe ser numerico", Status.BAD_REQUEST),
    EXC069("EXC069", "No tiene tipo o número de documento de identidad.", Status.BAD_REQUEST),
    EXC070("EXC070", "There was an error processing your request.", Status.INTERNAL_SERVER_ERROR),
    EXC071("EXC071", "Invalid Token", Status.UNAUTHORIZED),
    EXC072("EXC072", "El campo correo se encuentra vacío", Status.BAD_REQUEST),
    EXC073("EXC073", "Paciente registrado con otro correo", Status.BAD_REQUEST),
    EXC074("EXC074", "Paciente registrado con otro número de documento", Status.BAD_REQUEST),
    EXC075("EXC075", "Client doesn't exist in Mediweb", Status.BAD_REQUEST),
    EXC076("EXC076", "Client didn't sign consent", Status.BAD_REQUEST),
    EXC077("EXC077", "The coupon has expired", Status.BAD_REQUEST),
    EXC078("EXC078", "La fecha de nacimiento esta vacio o invalido", Status.BAD_REQUEST),
    EXC079("EXC079", "Not acceptable", Status.NOT_ACCEPTABLE);

    private final String key;
    private final String message;
    private final Status status;

    private GoAmbuExceptionEnum(String key, String message, Status status) {
        this.key = key;
        this.message = message;
        this.status = status;
    }

    public String getKey() {
        return key;
    }

    public String getMessage() {
        return message;
    }

    public Status getStatus() {
        return status;
    }
}
