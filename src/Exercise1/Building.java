package Exercise1;

public class Building implements Mappable {
    private String name;
    private UsageType type;
    private Color color;
    private PointMarkers point_marker;

    public Building(String name, UsageType type, Color color, PointMarkers point_marker) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.point_marker = point_marker;
    }


    @Override
    public String toJSON() {
        return String.format("\"properties\": {\"type\": \"POINT\", \"label\": \"%s\", \"marker\": \"%s\", \"name\": \"%s\", \"usage\": \"%s\"}", getLabel(), getMarker(), name, type.name());
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, type);
    }

    @Override
    public String getMarker() {
        return String.format("%s %s", color.name(), point_marker.name());
    }

    @Override
    public Geometry getShape() {
        return Geometry.POINT;
    }
}
