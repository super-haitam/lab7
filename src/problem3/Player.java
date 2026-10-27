package problem3;

import java.util.List;

public class Player implements ISaveable {
    private String name;
    private String weapon;
    private int hitPoints;
    private int strength;

    public Player(String name, int hitPoints, int strength) {
        this.name = name;
        this.hitPoints = hitPoints;
        this.strength = strength;
        this.weapon = "Sword";
    }

    // Getter and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getWeapon() {
        return weapon;
    }

    public void setWeapon(String weapon) {
        this.weapon = weapon;
    }

    public int getHitPoints() {
        return hitPoints;
    }

    public void setHitPoints(int hitPoints) {
        this.hitPoints = hitPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    // Interface methods
    public List<String> write() {
        return List.of(name, Integer.toString(hitPoints), Integer.toString(strength), weapon);
    }

    public void read(List<String> data) {
        if (data == null || data.isEmpty()) return;

        setName(data.get(0));
        setHitPoints(Integer.parseInt(data.get(1)));
        setStrength(Integer.parseInt(data.get(2)));
        setWeapon(data.get(3));
    }

    @Override
    public String toString() {
        return String.format("Player{name='%s', hitPoints=%d, strength=%d, weapon='%s'}", name, hitPoints, strength, weapon);
    }
}
