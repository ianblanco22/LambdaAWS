package co.com.semillero.model;

import co.com.semillero.model.entity.AccountEntity;
import co.com.semillero.model.entity.KeyEntity;
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
    protected KeyEntity key;
    protected AccountEntity account;
}
