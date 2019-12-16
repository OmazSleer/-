package by.model.service;

import by.model.dao.BetDao;
import by.model.dao.DataSourceException;
import by.model.dao.NotFoundException;
import by.model.entity.Bet;

import java.util.List;

public class BetUserService implements BetService {

    private final DaoFactory daoFactory = DaoFactory.getInstance();
    private final BetDao betDao = daoFactory.getBetDao();

    @Override
    public void addBet(Bet bet) throws DataSourceException {
        betDao.addBet(bet);
    }

    @Override
    public List<Bet> getBets() throws DataSourceException {
        return betDao.getBets();
    }

    @Override
    public void updateBet(int id, Bet bet) throws DataSourceException, NotFoundException {
        betDao.updateBet(id, bet);
    }

    @Override
    public void deleteBet(int id) throws DataSourceException {
        betDao.deleteBet(id);
    }

    @Override
    public List<Bet> getByParticipant(int participantId) throws DataSourceException {
        return betDao.getByParticipant(participantId);
    }
}
