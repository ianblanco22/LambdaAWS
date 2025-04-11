package co.com.semillero.mapper;

import co.com.semillero.model.Client;
import co.com.semillero.model.entity.ClientEntity;

public class ClientMapper {

    public ClientMapper(Client client){
        ClientEntity clientEntity = new ClientEntity();

        String id = clientEntity.getStrIdLlave().getStrIdLlave();
        clientEntity.setId(id);
        clientEntity.setSdk(id);
        clientEntity.setStrFirstName(client.getStrFirstName());
        clientEntity.setStrLastName(client.getStrLastName());
        clientEntity.setStrEmail(client.getStrEmail());

    }
}
