package software.daveturner.mapsample.mappers;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import software.daveturner.mapsample.model.ValueMapperResponse;

import static org.junit.jupiter.api.Assertions.*;

public class DefaultMapperTest {

    @Test
    public void ensureBodyReturnsExpected() {
        ValueMapperResponse r = new ValueMapperResponse();
        DefaultMapper mapper = new DefaultMapper();
        mapper.map(r,null);
        Assertions.assertEquals(r.getBody(), "default mapper picked up");
    }

}