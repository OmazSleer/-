package by.model.dao;

import by.model.entity.Bet;

import java.util.ArrayList;

public interface BetDao {
    void addBet(Bet bet) throws DataSourceException;
    ArrayList<Bet> getBets() throws DataSourceException;
    void updateBet(int id, Bet bet) throws DataSourceException, NotFoundException;
    void deleteBet(int id) throws DataSourceException;
    ArrayList<Bet> getByParticipant(int participantId) throws DataSourceException;
}
