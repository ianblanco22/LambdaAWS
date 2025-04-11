package co.com.semillero.service;

import co.com.semillero.exception.ErrorResponse;
import co.com.semillero.mapper.ClientMapper;
import co.com.semillero.model.Client;
import co.com.semillero.model.entity.ClientEntity;
import co.com.semillero.repository.DynamoMapperRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.jboss.logging.Logger;

public class DynamoService implements IDynamoService {

    DynamoMapperRepository dynamoMapperRepository = new DynamoMapperRepository();
    ClientMapper clientMapper = new ClientMapper();
    private static final Logger logger = Logger.getLogger(DynamoService.class.getName());

    @Override
    public String saveClient(DynamoDBMapper mapper, Client entity) throws ErrorResponse {
        logger.info("Iniciando el método saveClient.");
        ClientEntity client = clientMapper.clientMapper(entity);
        logger.info("Cliente mapeado correctamente.");
        dynamoMapperRepository.save(mapper, client);
        logger.info("Cliente guardado correctamente en DynamoDB.");
        return "Se guardó correctamente. ";
    }

    @Override
    public ClientEntity getClient(DynamoDBMapper mapper, Client entity) {
        logger.info("Iniciando el método getClient.");
        String id = entity.getKey().getStrIdLlave();
        logger.info("Obteniendo cliente con ID: " + id);
        ClientEntity response = dynamoMapperRepository.load(mapper, id);
        logger.info("Cliente obtenido correctamente.");
        return response;
    }
}
