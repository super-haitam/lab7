package Exercise1;

public class Main {
    public static void main(String[] args) {
        Building b = new Building(
                "Sydney Town Hall",
                UsageType.GOVERNMENT,
                Color.RED,
                PointMarkers.STAR
        );

        UtilityLine u = new UtilityLine(
                "College St",
                UtilityType.FIBER_OPTIC,
                Color.GREEN,
                LineMarkers.DOTTED
        );

        Mappable.mapIt(b);
        Mappable.mapIt(u);
    }
}
