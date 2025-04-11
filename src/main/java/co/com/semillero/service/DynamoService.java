package co.com.semillero.service;

import co.com.semillero.model.entity.ClientEntity;
import co.com.semillero.repository.DynamoMapperRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoService implements IDynamoService{

    DynamoMapperRepository dynamoMapperRepository = new DynamoMapperRepository();
    @Override
    public void saveUsuario(DynamoDBMapper mapper, ClientEntity entity) {
        dynamoMapperRepository.save(mapper, entity);
    }

    @Override
    public ClientEntity getClient(DynamoDBMapper mapper, ClientEntity entity) {
        String id = entity.getStrIdLlave().getStrIdLlave();
        ClientEntity response = dynamoMapperRepository.load(mapper, id);
        return response;
    }


    

}
