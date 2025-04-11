package co.com.semillero.mapper;

import co.com.semillero.model.Client;
import co.com.semillero.model.entity.AccountEntity;
import co.com.semillero.model.entity.ClientEntity;
import co.com.semillero.model.entity.KeyEntity;

public class ClientMapper {

    public ClientMapper(Client client){
        ClientEntity clientEntity = new ClientEntity();
        KeyEntity keyEntity = new KeyEntity();
        AccountEntity accountEntity = new AccountEntity();

        String id = clientEntity.getStrIdLlave().getStrIdLlave();
        clientEntity.setId(id);
        clientEntity.setSdk(id);
        clientEntity.setStrFirstName(client.getStrFirstName());
        clientEntity.setStrLastName(client.getStrLastName());
        clientEntity.setStrEmail(client.getStrEmail());
        clientEntity.setStrAddress(client.getStrAddress());
        clientEntity.setStrIdentificationType(client.getStrIdentificationType());
        clientEntity.setStrIdentificationNum(client.getStrIdentificationNum());

        keyEntity.setStrIdLlave();
        keyEntity.setStrIdLlave();
        clientEntity.

        accountEntity.setStrAccount(client.getStrAccount());
        accountEntity.



    }
}
