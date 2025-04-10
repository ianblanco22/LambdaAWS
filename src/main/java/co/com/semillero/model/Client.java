package co.com.semillero.model;

import co.com.semillero.model.Entity.AccountEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

    protected int numID;
    protected String strIdentificationType;
    protected String strIdentificationNum;
    protected String strFirstName;
    protected String strLastName;
    protected String strAddress;
    protected String strPhoneNumber;
    protected String strEmail;
    protected String strAccount;
    protected String strBank;
}
