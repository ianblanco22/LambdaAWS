package co.com.semillero.service;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;

import co.com.semillero.mapper.UsuarioMapper;
import co.com.semillero.model.Usuario;
import co.com.semillero.model.entity.UsuarioEntity;
import co.com.semillero.repository.DynamoMapperRepository;

public class DynamoServece implements IDynamoService{

    DynamoMapperRepository repository = new DynamoMapperRepository();

    UsuarioMapper usuarioMapper = new UsuarioMapper();

    @Override
    public String saveUsuario(DynamoDBMapper mapper, Usuario usuario) {
        UsuarioEntity usuarioEntity = usuarioMapper.mappingUser(usuario);
        repository.save(mapper, usuarioEntity);
        return "Usuario guardado con exito";
    }

    @Override
    public UsuarioEntity getUsuario(DynamoDBMapper mapper, Usuario usuario){
        String id = usuario.getTipoDocumento() + "_"+usuario.getNuemroDocumento();
        UsuarioEntity response = repository.load(mapper, id);

        return response;
    }
}
