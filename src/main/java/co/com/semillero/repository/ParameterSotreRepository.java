package co.com.semillero.repository;

import java.util.Map;

import co.com.semillero.model.entity.ParameterStoreDto;
import co.com.semillero.util.ParameterStoreUtil;

public class ParameterSotreRepository {
    
    public ParameterStoreDto getParameter(){
        ParameterStoreDto parameter = new ParameterStoreDto();

        Map<String, String> parameterSemillero = ParameterStoreUtil.getParameters("/semillero/capacitacion-semillero/");

        parameter.setTabla(parameterSemillero.get("/semillero/capacitacion-semillero/nombreTabla"));
        parameter.setRegion(parameterSemillero.get("/semillero/capacitacion-semillero/region"));
        parameter.setUrlDynamo(parameterSemillero.get("/semillero/capacitacion-semillero/DynamoEnpoint"));
        parameter.setArnSecre("/semillero/capacitacion-semillero/arnSecret");
        return parameter;
    }
}
