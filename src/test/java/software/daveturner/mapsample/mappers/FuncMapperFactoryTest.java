package software.daveturner.mapsample.mappers;

import org.junit.Test;
import static org.junit.jupiter.api.Assertions.*;
import static software.daveturner.mapsample.mappers.FuncMapperFactory.*;

public class FuncMapperFactoryTest {

    @Test
    public void ensureRandomMapperReturnsDefault() {
        FuncMapper mapper = getMapper("bob");
        assertEquals(mapper.getClass().getName(), DefaultMapper.class.getName());
    }

    @Test
    public void ensureInvoiceMapperReturnsExpected() {
        FuncMapper mapper = getMapper(INVOICE_MAPPER.value());
        assertEquals(mapper.getClass().getName(), InvoiceMapper.class.getName());
    }

}