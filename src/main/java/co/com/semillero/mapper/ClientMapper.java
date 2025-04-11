package co.com.semillero.mapper;

import co.com.semillero.model.Client;
import co.com.semillero.model.entity.AccountEntity;
import co.com.semillero.model.entity.ClientEntity;
import co.com.semillero.model.entity.KeyEntity;

public class ClientMapper {

    public ClientEntity ClientMapper(Client client){
        ClientEntity clientEntity = new ClientEntity();
        AccountEntity accountEntity=new AccountEntity();
        KeyEntity keyEntity=new KeyEntity();

        accountEntity.setStrAccount(client.getStrAccount());
        accountEntity.setStrBank(client.getStrBank());

        keyEntity.setStrIdLlave(client.getStrIdLlave());
        keyEntity.setStrTypeLlave(client.getStrTypeLlave());

        String id = keyEntity.getStrIdLlave();
        clientEntity.setId(id);
        clientEntity.setSdk(id);
        clientEntity.setStrFirstName(client.getStrFirstName());
        clientEntity.setStrLastName(client.getStrLastName());
        clientEntity.setStrEmail(client.getStrEmail());

        clientEntity.setAccount(accountEntity);
        clientEntity.setKey(keyEntity);

        return clientEntity;
    }
}
