package by.model.service;

import by.model.dao.DataSourceException;
import by.model.dao.NotFoundException;
import by.model.entity.Bet;

import java.util.List;

public interface BetService {
    void addBet(Bet bet) throws DataSourceException;
    List<Bet> getBets() throws DataSourceException;
    void updateBet(int id, Bet bet) throws DataSourceException, NotFoundException;
    public void deleteBet(int id) throws DataSourceException;
    List<Bet> getByParticipant(int participantId) throws DataSourceException;
}
