package co.com.semillero.model.entity;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@DynamoDBDocument
public class KeyEntity {
    @DynamoDBAttribute()
    protected String strIdLlave;
    @DynamoDBAttribute()
    protected String strTypeLlave;
}
