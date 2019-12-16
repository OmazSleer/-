package by.model.service;

import by.model.dao.BetDao;
import by.model.dao.XmlBetDao;

public class DaoFactory {

    private static final DaoFactory daoFactory = new DaoFactory();

    private final BetDao betDao = new XmlBetDao();

    public static DaoFactory getInstance() {
        return daoFactory;
    }

    public BetDao getBetDao() {
        return betDao;
    }

}
