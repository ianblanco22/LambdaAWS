package co.com.semillero.service;

import co.com.semillero.model.Client;
import co.com.semillero.model.entity.ClientEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public interface IDynamoService {
    String saveClient(DynamoDBMapper mapper, Client entity);
    ClientEntity getClient(DynamoDBMapper mapper, Client entity);
}