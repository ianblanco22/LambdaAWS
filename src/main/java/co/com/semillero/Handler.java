package co.com.semillero;

import com.amazonaws.HttpMethod;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import co.com.semillero.repository.ParameterSotreRepository;
import co.com.semillero.service.DynamoServece;
import co.com.semillero.util.BuildResponseUtil;
import co.com.semillero.util.Util;
import lombok.extern.slf4j.Slf4j;
import co.com.semillero.model.Usuario;
import co.com.semillero.model.entity.ParameterStoreDto;
import co.com.semillero.repository.DynamoRepository;



@Slf4j
public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    ParameterSotreRepository parameterRepository = new ParameterSotreRepository();

    ParameterStoreDto parameterDto = parameterRepository.getParameter();

    DynamoRepository dynamoRepository = new DynamoRepository();

    DynamoDBMapper dynamoDBMapper = dynamoRepository.build(parameterDto); 

    DynamoServece dynamoServece = new DynamoServece();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {
        
        return BuildResponseUtil.buildSuccess(redirect(input));
    }

    public Object redirect(APIGatewayProxyRequestEvent input){
        try{
            log.info("body: "+input.getBody());
            if(input.getBody()!= null){
                log.info("servicio "+input.getHeaders().get("servicio"));
                if(input.getHeaders().get("servicio").equals("guardar") && input.getHttpMethod().equals(HttpMethod.POST)){
                    Usuario usuario = (Usuario) Util.string2object(input.getBody(),Usuario.class );
                    return dynamoServece.saveUsuario(dynamoDBMapper,usuario);
                }else if(input.getHeaders().get("servicio").equals("consultar") && input.getHttpMethod().equals(HttpMethod.GET)){
                    Usuario usuario = (Usuario) Util.string2object(input.getBody(),Usuario.class );
                    return dynamoServece.getUsuario(dynamoDBMapper,usuario);

                }else{
                    return "servicio np disponible";
                }
            }else{
                return "no tiene informacion";
            }            
        }catch (Exception e){
            return e;
        }
    }
}
