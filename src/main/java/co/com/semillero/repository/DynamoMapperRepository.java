package co.com.semillero.repository;

import co.com.semillero.model.Entity.ClientEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoMapperRepository {
    public void save(DynamoDBMapper mapper, ClientEntity entity) {
        mapper.save(entity);
    }

    public ClientEntity load(DynamoDBMapper mapper, String id) {
        return mapper.load(ClientEntity.class, id, id);
    }

}
