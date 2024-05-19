package Core.Repository;

import java.util.Date;
import java.util.List;

public interface IHistorieSearchDAO<T> extends IDAO<T> {
    List<T> getHistorieSearchsByTitle(String title);
    List<T> getHistorieSearchsByUrl(String url);
    List<T> getHistorieSearchsByNotes(String notes);
    List<T> getHistorieSearchsByIsRead(Boolean isRead);
    List<T> getHistorieSeachByDateRange(Date now, Date distance);
}