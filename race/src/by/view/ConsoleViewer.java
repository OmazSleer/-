package by.view;

import by.model.dao.BetDao;
import by.model.dao.DataSourceException;
import by.model.dao.XmlBetDao;
import by.model.entity.Bet;
import by.model.entity.Race;

import java.util.ArrayList;

public class ConsoleViewer implements View {
    @Override
    public void ShowWinners() {
        BetDao betDao = new XmlBetDao();
        ArrayList<Bet> bets = null;
        try {
            bets = betDao.getBets();
        } catch (DataSourceException e) {
            e.printStackTrace();
        }
        System.out.println("List of winners:");
        for (Bet bet :
                bets) {
            if (bet.isWin())
            {
                System.out.println("Bet: [" + bet + "]");
            }
        }
        System.out.println("========\nEnd of list");
    }

    @Override
    public void ShowRace(Race race) {
        System.out.println(race.toString());
    }
}
