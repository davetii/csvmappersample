package software.daveturner.mapsample.mappers;

import software.daveturner.mapsample.model.ValueMapperResponse;
import software.daveturner.mapsample.model.ValuesMapperInput;

public class DefaultMapper implements FuncMapper {

    @Override
    public ValueMapperResponse map(ValueMapperResponse response, ValuesMapperInput input) {
        response.setBody("default mapper picked up");
        return response;
    }
}
