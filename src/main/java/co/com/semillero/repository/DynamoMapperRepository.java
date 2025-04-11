package co.com.semillero.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import co.com.semillero.model.entity.UsuarioEntity;

public class DynamoMapperRepository {
    public void save(DynamoDBMapper mapper, UsuarioEntity entity){
        mapper.save(entity);
    }
    public UsuarioEntity load(DynamoDBMapper mapper, String id){
        return mapper.load(UsuarioEntity.class,id,id);

    }
}
