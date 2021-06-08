package com.company;

import java.util.Objects;

public class Jumper {
     int startPoint;
     int endPoint;

    public Jumper(int startPoint, int endPoint) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        this.startPoint = startPoint;
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        this.endPoint = endPoint;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Jumper)) return false;
        Jumper jumper = (Jumper) o;
        return getStartPoint() == jumper.getStartPoint() && getEndPoint() == jumper.getEndPoint();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getStartPoint(), getEndPoint());
    }
}
