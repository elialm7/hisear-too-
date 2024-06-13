package Service;

import dao.IHistorieSearchDAO;
import Entities.HistorieSearch;

public class UseCaseService {

    private IHistorieSearchDAO<HistorieSearch> historySearchDao;

    public UseCaseService(IHistorieSearchDAO<HistorieSearch> historySearchDao) {
        this.historySearchDao = historySearchDao;
    }
}
