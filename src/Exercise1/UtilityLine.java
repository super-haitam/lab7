package Exercise1;

public class UtilityLine implements Mappable {
    private String name;
    private UtilityType type;
    private Color color;
    private LineMarkers line_marker;

    public UtilityLine(String name, UtilityType type, Color color, LineMarkers line_marker) {
        this.name = name;
        this.type = type;
        this.color = color;
        this.line_marker = line_marker;
    }

    @Override
    public String toJSON() {
        return String.format("\"properties\": {\"type\": \"LINE\", \"label\": \"%s\", \"marker\": \"%s\", \"name\": \"%s\", \"utility\": \"%s\"}", getLabel(), getMarker(), name, type.name());
    }

    @Override
    public String getLabel() {
        return String.format("%s (%s)", name, type.name());
    }

    @Override
    public String getMarker() {
        return String.format("%s %s", color.name(), line_marker.name());
    }

    @Override
    public Geometry getShape() {
        return Geometry.LINE;
    }
}