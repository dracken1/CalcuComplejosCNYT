package Aplicacion;

public class Angle {

    double angle;

    public Angle(double angle){
        this.angle = convertAngleDoubleBetween0And360(angle);
    }

    /**
     * Converts an angle between 0 and 360 and converts it in radians
     * @param angle main.Angle
     * @return
     */
    public static double convertAngleDoubleBetween0And360(double angle){
        while(angle < 0 || angle > 360){
            if(angle<0){
                angle += 360;
            }else{
                angle -= 360;
            }
        }
        return (angle*180)/Math.PI;
    }

    public double getAngle() {
        return angle*Math.PI/180;
    }

    public void setAngle(double angel) {
        this.angle = convertAngleDoubleBetween0And360(angel);
    }


    @Override
    public String toString() {
        return "main.Angle{" +
                "angel=" + getAngle() +
                '}';
    }
}
