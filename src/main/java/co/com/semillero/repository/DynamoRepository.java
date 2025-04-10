package co.com.semillero.repository;


import co.com.semillero.model.ParameterStoreDTO;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoRepository {


    //consultar y guardar información
    public DynamoDBMapper build(ParameterStoreDTO parameter){
        //configuración a que tabla se va a consumir
        DynamoDBMapperConfig config=new DynamoDBMapperConfig.Builder().withTableNameOverride(
                DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(parameter.getTable())).build();

        AmazonDynamoDB client=buidClient(parameter.getRegion(), parameter.getUrlDynamo());
        return new DynamoDBMapper(client, config);
    }

    //realiza la conexion a Dynamo de acuerdo a la url y region de la tabla
    public AmazonDynamoDB buidClient(String region, String url){
        return AmazonDynamoDBClient.builder().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(url,region)).build();
    }
}
