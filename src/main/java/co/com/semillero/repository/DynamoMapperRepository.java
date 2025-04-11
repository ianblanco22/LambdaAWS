package co.com.semillero.repository;
import co.com.semillero.exception.ErrorResponse;
import co.com.semillero.model.entity.ClientEntity;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

public class DynamoMapperRepository {

    public void save (DynamoDBMapper mapper, ClientEntity entity) throws ErrorResponse {

        try {
            mapper.save(entity);
        } catch (Exception e) {
            throw new ErrorResponse(e);
        }
    }

    public ClientEntity load (DynamoDBMapper mapper, String id) {
        return mapper.load(ClientEntity.class, id);
    }
}
