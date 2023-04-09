package dataTransferObjects.models;

import java.io.Serializable;

public class CoordinatesDTO implements Serializable {
    private double x;
    private Float y;

    /**
     * Restrictions: The value of this field should be greater than -107.
     *
     * @return Value of field x
     */
    public double getX() {
        return x;
    }

    /**
     * Restrictions: The value of this field should be greater than -107.
     *
     * @param x Value of field x
     */
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Restrictions: Field cannot be null and the value of this field should be greater than -39.
     *
     * @return Value of field y
     */
    public Float getY() {
        return y;
    }

    /**
     * Restrictions: Field cannot be null and the value of this field should be greater than -39.
     *
     * @param y Value of field y
     */
    public void setY(Float y) {
        this.y = y;
    }
}
