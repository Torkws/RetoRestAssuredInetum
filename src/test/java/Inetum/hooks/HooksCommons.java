package Inetum.hooks;


import io.cucumber.java.Before;
import net.serenitybdd.screenplay.actors.Cast;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class HooksCommons {
    @Before(order=0)
    public void setTheStage(){
        OnStage.setTheStage(Cast.ofStandardActors());
        System.out.println("Se ha configurado el escenario para los actores.");
    }

}
