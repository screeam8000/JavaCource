package annotation;


@ControllerObject(name = "bisk",def=14)
public class Coockies {

@ControllerObject(name = "Color", def = 34)
public String color;

    @StartObject
    public void CreatedCookie(){

    }

    @StopObject
    public void StopCookie(){}

    public void setColor(String color) {
        this.color = color;
    }
}
