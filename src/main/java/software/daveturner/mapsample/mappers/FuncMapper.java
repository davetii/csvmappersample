package software.daveturner.mapsample.mappers;

import software.daveturner.mapsample.model.ValueMapperResponse;
import software.daveturner.mapsample.model.ValuesMapperInput;

public interface FuncMapper {
    public ValueMapperResponse map(ValueMapperResponse response, ValuesMapperInput input);
}
