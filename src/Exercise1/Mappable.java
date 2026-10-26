package Exercise1;


public interface Mappable {
    String JSON_PROPERTY = "\"properties\": ";

    enum Geometry {
        LINE, POINT, POLYGON
    }

    static void mapIt(Mappable mappable) {
        System.out.println(mappable.toJSON());
    }

    default String toJSON() {
        return null;
    }

    String getLabel();
    String getMarker();
    Geometry getShape();
}
