package co.com.semillero;

import co.com.semillero.exception.ErrorResponse;
import co.com.semillero.model.Client;
import co.com.semillero.model.ParameterStoreDTO;
import co.com.semillero.repository.DynamoRepository;
import co.com.semillero.repository.ParameterStoreRepository;
import co.com.semillero.service.DynamoService;
import co.com.semillero.util.BuildResponseUtil;
import co.com.semillero.util.Util;
import com.amazonaws.HttpMethod;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    ParameterStoreRepository parameterRepository = new ParameterStoreRepository();
    ParameterStoreDTO parameterDTO = parameterRepository.getParameter();
    DynamoRepository dynamoRepository = new DynamoRepository();
    DynamoDBMapper dynamoDBMapper = dynamoRepository.build(parameterDTO);
    DynamoService service = new DynamoService();

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        try {
            return BuildResponseUtil.buildSuccess(redirect(apiGatewayProxyRequestEvent));
        } catch (Exception e) {
            // Crear un objeto ErrorResponse y devolverlo como respuesta
            ErrorResponse errorResponse = new ErrorResponse(e);
            return BuildResponseUtil.buildError(errorResponse);
        }
    }

    public Object redirect(APIGatewayProxyRequestEvent input) throws Exception{
        try {
            if (input.getBody() != null){
                if (input.getHeaders().get("servicio").equals("guardar")){
                    Client client = (Client) Util.string2object(input.getBody(), Client.class);
                    return service.saveClient(dynamoDBMapper, client);
                } else if (input.getHeaders().get("servicio").equals("consultar")){
                    Client client = (Client) Util.string2object(input.getBody(), Client.class);
                    return service.getClient(dynamoDBMapper, client);
                } else {
                    throw new Exception("Servicio no disponible");
                }
            } else {
                throw new Exception("No se encontró información");
            }

        } catch (Exception e) {
            return e;
        }
    }
}
