package co.com.semillero.repository;

import co.com.semillero.model.entity.ParameterStoreDto;
import co.com.semillero.util.ParameterStoreUtil;

import java.util.Map;

public class ParameterStoreRepository {

    public ParameterStoreDto getParameterStoreDto() {
        ParameterStoreDto parameter = new ParameterStoreDto();

        Map<String, String> parameterSemillero = ParameterStoreUtil.getParameters("");

        parameter.setTabla(parameterSemillero.get(""));
        parameter.setRegion(parameterSemillero.get(""));
        parameter.setUrlDynamo(parameterSemillero.get(""));
        parameter.setArnSecret(parameterSemillero.get(""));

        return parameter;
    }

}
