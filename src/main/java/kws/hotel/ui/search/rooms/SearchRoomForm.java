package kws.hotel.ui.search.rooms;

import java.util.Date;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 9:58 PM
 * To change this template use File | Settings | File Templates.
 */
public class SearchRoomForm {
    
    private Date startDate;
    private Date endDate;

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "SearchRoomForm{" +
                "startDate=" + startDate +
                ", endDate=" + endDate +
                '}';
    }
}
