package org.vitalvale.Game.Player;

public class Position {
    private float X;
    private float Y;
    private float Z;

    public Position()
    {
        this.X = 0;
        this.Y = 0;
        this.Z = 0;
    }
    public Position(float x, float y, float z)
    {
        this.X = x;
        this.Y = y;
        this.Z = z;
    }

    public float getX() {
        return X;
    }

    public float getY() {
        return Y;
    }

    public float getZ() {
        return Z;
    }

    public void setX(float x) {
        X = x;
    }

    public void setY(float y) {
        Y = y;
    }

    public void setZ(float z) {
        Z = z;
    }

    public String getString()
    {
        return getX() + "," + getY() + "," + getZ();
    }
}
