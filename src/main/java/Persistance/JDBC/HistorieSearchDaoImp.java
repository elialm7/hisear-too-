package Persistance.JDBC;

import Core.Repository.IHistorieSearchDAO;
import Entities.HistorieSearch;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public class HistorieSearchDaoImp implements IHistorieSearchDAO<HistorieSearch> {

    @Override
    public List<HistorieSearch> getHistorieSearchsByTitle(String title) {
        return List.of();
    }

    @Override
    public List<HistorieSearch> getHistorieSearchsByUrl(String url) {
        return List.of();
    }

    @Override
    public List<HistorieSearch> getHistorieSearchsByNotes(String notes) {
        return List.of();
    }

    @Override
    public List<HistorieSearch> getHistorieSearchsByIsRead(Boolean isRead) {
        return List.of();
    }

    @Override
    public List<HistorieSearch> getHistorieSeachByDateRange(Date now, Date distance) {
        return List.of();
    }

    @Override
    public List<HistorieSearch> getAll() {
        return List.of();
    }

    @Override
    public void update(HistorieSearch item) {

    }

    @Override
    public void remove(HistorieSearch item) {

    }

    @Override
    public void create(HistorieSearch item) {

    }
}
