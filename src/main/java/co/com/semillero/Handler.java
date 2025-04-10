package co.com.semillero;

import co.com.semillero.model.ParameterStoreDTO;
import co.com.semillero.repository.DynamoRepository;
import co.com.semillero.repository.ParameterStoreRepository;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;

public class Handler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {

    ParameterStoreRepository parameterRepository = new ParameterStoreRepository();

    ParameterStoreDTO parameterDTO = parameterRepository.getParameter();

    DynamoRepository dynamoRepository=new DynamoRepository();

    DynamoDBMapper dynamoDBMapper=dynamoRepository.build(parameterDTO);

    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent apiGatewayProxyRequestEvent, Context context) {
        return null;
    }

    public Object redirect(APIGatewayProxyRequestEvent input) {
        try {
            return null;
        } catch (Exception e) {
            return e;
        }
    }
}
