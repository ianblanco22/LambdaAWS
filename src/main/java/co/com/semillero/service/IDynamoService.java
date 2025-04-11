package co.com.semillero.service;

import co.com.semillero.model.entity.ClientEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public interface IDynamoService {
    void saveUsuario(DynamoDBMapper mapper, ClientEntity entity);
    ClientEntity getClient(DynamoDBMapper mapper, ClientEntity entity);
}