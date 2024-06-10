package software.daveturner.mapsample.mappers;


public enum FuncMapperFactory {
    DEFAULT_MAPPER("default"),
    INVOICE_MAPPER("invoiceMapper");

    private final String value;

    FuncMapperFactory(String value) {
        this.value = value;
    }

    public String value() {
        return this.value;
    }

    public static FuncMapper getMapper(String t) {
        if (t.equals(INVOICE_MAPPER.value)) {
            return new InvoiceMapper();
        }
        return new DefaultMapper();
    }
}