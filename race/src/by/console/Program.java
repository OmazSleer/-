package by.console;

import by.controller.Controller;
import by.model.entity.Horse;
import by.model.entity.Participant;
import by.model.entity.Race;

import java.util.Date;

public class Program {
    public static void main (String[] args) {
        Controller controller = new Controller();
        Race myFirstRace = controller.createRace();
        Participant igor = controller.registerParticipant("Igor");
        igor.setMoney(200);

        Horse zelda = new Horse("Zelda");
        zelda.setId(0);
        Horse misha = new Horse("Misha");
        misha.setId(1);
        Horse jora = new Horse("Jora");
        jora.setId(2);
        controller.registerHorse(myFirstRace, zelda, 380, "Michael King", new Date(12412412), 12);
        controller.registerHorse(myFirstRace, misha, 400, "Michael Kong", new Date(124124521), 13);
        controller.registerHorse(myFirstRace, jora, 400, "Vitya King", new Date(1241223561), 13);

        controller.Execute();;
    }
}
