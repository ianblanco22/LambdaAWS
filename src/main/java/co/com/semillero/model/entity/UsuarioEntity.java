package co.com.semillero.model.entity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class UsuarioEntity {
    @DynamoDBRangeKey(attributeName = "id")
    protected String id;
    @DynamoDBHashKey(attributeName = "sdk")
    protected String sdk;
    @DynamoDBAttribute(attributeName = "nombre")
    protected String nombre;
    @DynamoDBAttribute(attributeName = "apellido")
    protected String apellido;
    @DynamoDBAttribute(attributeName = "celular")
    protected String celular;
    @DynamoDBAttribute(attributeName = "correo")
    protected String correo;
    @DynamoDBAttribute(attributeName = "numeroDoc")
    protected String nuemroDoc;
    @DynamoDBAttribute(attributeName = "tipoDocu")
    protected String tipoDoc;
    /**
     * Representa la ubicación asociada con el usuario.
     * Este atributo está mapeado al campo "ubicacion" en la tabla de DynamoDB.
     */
    @DynamoDBAttribute(attributeName = "ubicacion")
    protected UbicacionEntity ubicacion;
}
