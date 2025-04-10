package co.com.semillero.repository;

import co.com.semillero.model.entity.ParameterStoreDto;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapperConfig;

public class DynamoRepository {
    public DynamoDBMapper build (ParameterStoreDto parameter) {
        DynamoDBMapperConfig config = DynamoDBMapperConfig.builder()
                .withTableNameOverride(DynamoDBMapperConfig.TableNameOverride.withTableNameReplacement(parameter.getTabla())).build();

        AmazonDynamoDB client = buildClient(parameter.getRegion(), parameter.getUrlDynamo());
        return new DynamoDBMapper(client, config);
    }

    public AmazonDynamoDB buildClient(String region, String url) {
        return AmazonDynamoDBClient.builder().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(url, region)).build();
    }
}
