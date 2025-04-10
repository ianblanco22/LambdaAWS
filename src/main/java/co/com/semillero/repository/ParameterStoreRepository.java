package co.com.semillero.repository;

import co.com.semillero.model.ParameterStoreDTO;
import co.com.semillero.util.ParameterStoreUtil;

import java.util.Map;

public class ParameterStoreRepository {
    public ParameterStoreDTO getParameter(){
        String path="/Semillero/Capacitacion-semillero/";
        ParameterStoreDTO parameter=new ParameterStoreDTO();

        Map<String, String> parameterSemillero= ParameterStoreUtil.getParameters(path);

        parameter.setTable(parameterSemillero.get(path+"nombreTabla"));
        parameter.setRegion(parameterSemillero.get(path+"region"));
        parameter.setArnSecre(parameterSemillero.get(path+"arnSecret"));
        parameter.setUrlDynamo(parameterSemillero.get(path+"dynamoEndpoint"));

        return parameter;
    }
}
