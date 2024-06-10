package software.daveturner.mapsample.model;

public enum MapFields {

    NOTIFY_TYPE(0),
    DELIVERY_TYPE(1),
    LOCALE(2),
    LANG(3),
    COUNTRYCODE(4),
    EMAIL_SUPPORT(5),
    SUBJECT_LINE(6),
    MAPFUNC(7);

    private final int value;
    MapFields(int position) { this.value = position; }

    public int value() {
        return value;
    }


}
