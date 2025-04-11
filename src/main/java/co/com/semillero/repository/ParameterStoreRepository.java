package co.com.semillero.repository;

import co.com.semillero.constants.ParameterKey;
import co.com.semillero.model.ParameterStoreDTO;
import co.com.semillero.util.ParameterStoreUtil;

import java.util.Map;

public class ParameterStoreRepository {
    public ParameterStoreDTO getParameter(){
        
        ParameterStoreDTO parameter=new ParameterStoreDTO();

        Map<String, String> parameterSemillero = ParameterStoreUtil.getParameters(ParameterKey.BASE_PATH);

        parameter.setTable(parameterSemillero.get(ParameterKey.NOMBRE_TABLA.getFullKey()));
        parameter.setRegion(parameterSemillero.get(ParameterKey.REGION.getFullKey()));
        parameter.setArnSecre(parameterSemillero.get(ParameterKey.ARN_SECRET.getFullKey()));
        parameter.setUrlDynamo(parameterSemillero.get(ParameterKey.URL_DYNAMO.getFullKey()));

        return parameter;
    }
}
