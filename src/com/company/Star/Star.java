package com.company.Star;

import com.company.point.RealPoint;

public class Star extends Figure{
    public Star() {

    }

    @Override
    public void addPoint(RealPoint p) {
        if(this.getSize() < 10) {
            super.addPoint(p);
        }
    }

}
