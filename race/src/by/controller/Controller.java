package by.controller;

import by.model.dao.BetDao;
import by.model.dao.DataSourceException;
import by.model.dao.NotFoundException;
import by.model.dao.XmlBetDao;
import by.model.entity.*;
import by.view.ConsoleViewer;
import by.model.entity.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Controller {
    Race race;
    int lastBetId = 0;

    public void Execute()
    {
        int command = 1;
        while (command != 0) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("1 - register bet\n2 - show result of race\n0 - exit");
            command = scanner.nextInt();
            switch (command) {
                case 0:
                    System.out.println("Good Bye!");
                    break;
                case 1:
                    registerBet();
                    break;
                case 2:
                    finishRace(race, race.getHorses().get(0));
                    ConsoleViewer console = new ConsoleViewer();
                    console.ShowWinners();
                    break;
            }
        }
    }

    public void addMoney(Participant participant, double money) {
        double oldBalance = participant.getMoney();
        participant.setMoney(money + oldBalance);
    }

    public void decMoney(Participant participant, double money) {
        double oldBalance = participant.getMoney();
        participant.setMoney(oldBalance - money);
    }

    public void updateBalances(Race race) {
        //TODO update participants balances
    }

    public Race createRace() {
        race = new Race();
        return race;
    }

    public Participant registerParticipant(String name) {
        return new Participant(name);
    }

    public boolean registerBet() {
        BetType betType = BetType.WIN;

        ConsoleViewer consoleViewer = new ConsoleViewer();
        consoleViewer.ShowRace(race);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter money to bet");
        double money = scanner.nextDouble();
        System.out.println("Enter horse's id");
        int horseId = scanner.nextInt();
        Bet bet =  new Bet(lastBetId++, betType, money, 1, horseId);
        XmlBetDao xmlBetDao = new XmlBetDao();
        try
        {
            xmlBetDao.addBet(bet);
        }
        catch (DataSourceException e) {
            e.printStackTrace();
        }
        System.out.println("Registered!");
        return race.addBet(bet);
    }

    public ArrayList<Bet> finishRace(Race race, Horse winner) {
        race.setWinner(winner);
        ArrayList<Bet> winners = new ArrayList<>();
        ArrayList<Bet> bets = null;
        BetDao betDao = new XmlBetDao();
        try {
            bets = betDao.getBets();
        } catch (DataSourceException e) {
            e.printStackTrace();
        }
        for (Bet bet :
                bets) {
            if (bet.getHorseId() == race.getWinner().getId()) {
                try{
                    Bet newBet = new Bet();
                    newBet.setWin(true);
                    newBet.setWinMoney(bet.getWinMoney());
                    newBet.setMoney(bet.getMoney());
                    newBet.setCoefficient(bet.getCoefficient());
                    newBet.setHorseId(bet.getHorseId());
                    newBet.setBetType(bet.getBetType());
                    newBet.setParticipantId(bet.getParticipantId());
                    betDao.updateBet(bet.getId(), newBet);
                } catch (DataSourceException e) {
                    e.printStackTrace();
                } catch (NotFoundException e) {
                    e.printStackTrace();
                }
                winners.add(bet);
            }
            race.setCompleted(true);
        }
        return winners;
    }

    public void registerHorse(Race race, Horse horse, int weight, String jockey, Date lastRun, int age) {
        horse.setAge(age);
        horse.setJockey(jockey);
        horse.setLastRun(lastRun);
        horse.setWeight(weight);
        race.addHorse(horse);
    }

    public ArrayList<Bet> getWinners(Race race) {
        ArrayList<Bet> winners = new ArrayList<Bet>();
        if (race.isCompleted()) {
            for (Bet bet :
                    race.getBets()) {
                if (race.getWinner().equals(bet.getHorseId())) {
                    winners.add(bet);
                }
            }
        }
        return winners;
    }

}
