package co.com.semillero.model.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBDocument
public class ClientEntity {

    @DynamoDBHashKey(attributeName = "id")
    protected String id;

    @DynamoDBRangeKey(attributeName = "sk")
    protected String sk;

    @DynamoDBAttribute(attributeName = "key")
    protected KeyEntity key;

    @DynamoDBAttribute(attributeName = "numID")
    protected int numID;

    @DynamoDBAttribute(attributeName = "strIdentificationType")
    protected String strIdentificationType;

    @DynamoDBAttribute(attributeName = "strIdentificationNum")
    protected String strIdentificationNum;

    @DynamoDBAttribute(attributeName = "strFirstName")
    protected String strFirstName;

    @DynamoDBAttribute(attributeName = "strLastName")
    protected String strLastName;

    @DynamoDBAttribute(attributeName = "strAddress")
    protected String strAddress;

    @DynamoDBAttribute(attributeName = "strPhoneNumber")
    protected String strPhoneNumber;

    @DynamoDBAttribute(attributeName = "strEmail")
    protected String strEmail;

    @DynamoDBAttribute(attributeName = "account")
    protected AccountEntity account;

}
