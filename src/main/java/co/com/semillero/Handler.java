package co.com.semillero;

import co.com.semillero.exception.ErrorResponse;
import co.com.semillero.mapper.ClientMapper;
import co.com.semillero.model.Client;
import co.com.semillero.model.ParameterStoreDTO;
import co.com.semillero.repository.DynamoRepository;
import co.com.semillero.repository.ParameterStoreRepository;
import co.com.semillero.service.DynamoService;
import co.com.semillero.util.BuildResponseUtil;
import co.com.semillero.util.Util;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    ParameterStoreRepository parameterRepository = new ParameterStoreRepository();
    ParameterStoreDTO parameterDTO = parameterRepository.getParameter();
    DynamoRepository dynamoRepository = new DynamoRepository();
    DynamoDBMapper dynamoDBMapper = dynamoRepository.build(parameterDTO);
    DynamoService service = new DynamoService();

    private static final Logger logger = LoggerFactory.getLogger(ClientMapper.class);

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {

        logger.info("Iniciando manejo de la solicitud...");
        try {
            logger.info("Redirigiendo la solicitud...");
            return BuildResponseUtil.buildSuccess(redirect(apiGatewayProxyRequestEvent));
        } catch (Exception e) {
            logger.error("Error al manejar la solicitud: {}", e.getMessage(), e);
            ErrorResponse errorResponse = new ErrorResponse(e);
            return BuildResponseUtil.buildError(errorResponse);
        }
    }

    public Object redirect(APIGatewayProxyRequestEvent input) throws Exception {
        logger.info("Iniciando redirección...");
        try {
            if (input.getBody() != null) {
                String servicio = input.getHeaders().get("servicio");
                logger.info("Servicio recibido: {}", servicio);

                if ("guardar".equals(servicio)) {
                    logger.info("Procesando servicio 'guardar'...");
                    Client client = (Client) Util.string2object(input.getBody(), Client.class);
                    return service.saveClient(dynamoDBMapper, client);
                } else if ("consultar".equals(servicio)) {
                    logger.info("Procesando servicio 'consultar'...");
                    Client client = (Client) Util.string2object(input.getBody(), Client.class);
                    return service.getClient(dynamoDBMapper, client);
                } else {
                    logger.warn("Servicio no disponible: {}", servicio);
                    throw new Exception("Servicio no disponible");
                }
            } else {
                logger.warn("No se encontró información en el cuerpo de la solicitud.");
                throw new Exception("No se encontró información");
            }
        } catch (Exception e) {
            logger.error("Error durante la redirección: {}", e.getMessage(), e);
            return e;
        } catch (ErrorResponse e) {
            logger.error("ErrorResponse capturado: {}", e.getMessage(), e);
            throw new RuntimeException(e);
        }
    }
}
