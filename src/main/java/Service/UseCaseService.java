package Service;

import Core.Repository.IHistorieSearchDAO;
import Entities.HistorieSearch;

public class UseCaseService {

    IHistorieSearchDAO<HistorieSearch> historySearchDao;

    public UseCaseService(IHistorieSearchDAO<HistorieSearch> historySearchDao) {
        this.historySearchDao = historySearchDao;
    }
}
