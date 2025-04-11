package co.com.semillero.service;

import co.com.semillero.mapper.ClientMapper;
import co.com.semillero.model.Client;
import co.com.semillero.model.entity.ClientEntity;
import co.com.semillero.repository.DynamoMapperRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoService implements IDynamoService{

    DynamoMapperRepository dynamoMapperRepository = new DynamoMapperRepository();
    ClientMapper clientMapper = new ClientMapper();
    @Override
    public String saveClient(DynamoDBMapper mapper, Client entity) {
        ClientEntity client = clientMapper.clientMapper(entity);
        dynamoMapperRepository.save(mapper, client);
        return "Se guardó correctamente. ";
    }

    @Override
    public ClientEntity getClient(DynamoDBMapper mapper, Client entity) {
        String id = entity.getStrIdLlave();
        ClientEntity response = dynamoMapperRepository.load(mapper, id);
        return response;
    }


    

}
