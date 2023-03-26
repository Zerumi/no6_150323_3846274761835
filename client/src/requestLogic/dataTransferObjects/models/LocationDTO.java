package requestLogic.dataTransferObjects.models;

import java.io.Serializable;

public class LocationDTO implements Serializable {
    private float x;
    private Long y;
    private Long z;
    private String name;

    /**
     * No restrictions.
     *
     * @return Value of field x
     */
    public float getX() {
        return x;
    }

    /**
     * No restrictions.
     *
     * @param x Value of field x
     */
    public void setX(float x) {
        this.x = x;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @return Value of field y
     */
    public Long getY() {
        return y;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @param y Value of field y
     */
    public void setY(Long y) {
        this.y = y;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @return Value of field z
     */
    public Long getZ() {
        return z;
    }

    /**
     * Restrictions: Field cannot be null.
     *
     * @param z Value of field z
     */
    public void setZ(Long z) {
        this.z = z;
    }

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
}
