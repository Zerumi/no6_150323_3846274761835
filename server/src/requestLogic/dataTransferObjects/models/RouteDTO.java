package requestLogic.dataTransferObjects.models;

import java.io.Serializable;

/**
 * Model of Route. Main model of the program. Contains getters/setters of each class fields.
 * Some fields have restrictions. It's signed under every method of field.
 *
 * @author zerumi
 * @since 1.0
 */
public class RouteDTO implements Serializable {
    private String name;
    private CoordinatesDTO coordinates;
    private LocationDTO from;
    private LocationDTO to;
    private int distance;

    /**
     * Restrictions: Field cannot be null. String must not be empty.
     *
     * @return Value of field name
     */
    public String getName() {
        return name;
    }

    /**
     * Restrictions: Field cannot be null. String must not be empty.
     *
     * @param name Value of field name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @return Value of field coordinates
     */
    public CoordinatesDTO getCoordinates() {
        return coordinates;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @param coordinates Value of field coordinates
     */
    public void setCoordinates(CoordinatesDTO coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return Value of field from
     */
    public LocationDTO getFrom() {
        return from;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @param from Value of field from
     */
    public void setFrom(LocationDTO from) {
        this.from = from;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @return Value of field to
     */
    public LocationDTO getTo() {
        return to;
    }

    /**
     * Restrictions: Field can be null.
     *
     * @param to Value of field to
     */
    public void setTo(LocationDTO to) {
        this.to = to;
    }

    /**
     * Restrictions: The value of this field should be greater than 1.
     *
     * @return Value of field distance
     */
    public int getDistance() {
        return distance;
    }

    /**
     * Restrictions: The value of this field should be greater than 1.
     *
     * @param distance Value of field distance
     */
    public void setDistance(int distance) {
        this.distance = distance;
    }
}
