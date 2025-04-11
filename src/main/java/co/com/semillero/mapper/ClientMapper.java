package co.com.semillero.mapper;

import co.com.semillero.model.Client;
import co.com.semillero.model.entity.AccountEntity;
import co.com.semillero.model.entity.ClientEntity;
import co.com.semillero.model.entity.KeyEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ClientMapper {

    private static final Logger logger = LoggerFactory.getLogger(ClientMapper.class);

    public ClientEntity clientMapper(Client client){
        ClientEntity clientEntity = new ClientEntity();
        AccountEntity accountEntity=new AccountEntity();
        KeyEntity keyEntity=new KeyEntity();

        logger.info("Mapping Client to ClientEntity...");

        // Log de AccountEntity
        logger.info("AccountEntity - strAccount: {}", client.getAccount().getStrAccount());
        logger.info("AccountEntity - strBank: {}", client.getAccount().getStrBank());
        accountEntity.setStrAccount(client.getAccount().getStrAccount());
        accountEntity.setStrBank(client.getAccount().getStrBank());

        // Log de KeyEntity
        logger.info("KeyEntity - strIdLlave: {}", client.getKey().getStrIdLlave());
        logger.info("KeyEntity - strTypeLlave: {}", client.getKey().getStrTypeLlave());
        keyEntity.setStrIdLlave(client.getKey().getStrIdLlave());
        keyEntity.setStrTypeLlave( client.getKey().getStrTypeLlave());

        // Log de ClientEntity
        String id = client.getStrIdentificationType()+"_"+ keyEntity.getStrIdLlave();
        logger.info("ClientEntity - id: {}", id);
        clientEntity.setId(id);
        clientEntity.setSk(id);
        logger.info("ClientEntity - strFirstName: {}", client.getStrFirstName());
        logger.info("ClientEntity - strLastName: {}", client.getStrLastName());
        logger.info("ClientEntity - strEmail: {}", client.getStrEmail());
        logger.info("ClientEntity - strPhoneNumber: {}", client.getStrPhoneNumber());
        logger.info("ClientEntity - strIdentificationType: {}", client.getStrIdentificationType());
        logger.info("ClientEntity - strIdentificationNum: {}", client.getStrIdentificationNum());
        logger.info("ClientEntity - strAddress: {}", client.getStrAddress());

        clientEntity.setStrFirstName(client.getStrFirstName());
        clientEntity.setStrLastName(client.getStrLastName());
        clientEntity.setStrEmail(client.getStrEmail());
        clientEntity.setStrPhoneNumber(client.getStrPhoneNumber());
        clientEntity.setStrIdentificationType(client.getStrIdentificationType());
        clientEntity.setStrIdentificationNum(client.getStrIdentificationNum());
        clientEntity.setStrAddress(clientEntity.getStrAddress());

        clientEntity.setAccount(accountEntity);
        clientEntity.setKey(keyEntity);

        logger.info("ClientEntity mapping completed.");

        return clientEntity;
    }
}
