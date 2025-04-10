package co.com.semillero.model.Entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDB;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientEntity {

    @DynamoDBAttribute(attributeName = "strIdLlave")
    protected KeyEntity strIdLlave;

    @DynamoDBAttribute(attributeName = "strTypeLlave")
    protected KeyEntity strTypeLlave;

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

    @DynamoDBAttribute(attributeName = "strAccount")
    protected AccountEntity strAccount;

    @DynamoDBAttribute(attributeName = "strBank")
    protected AccountEntity strBank;
}
