package kws.hotel.repo;

import kws.hotel.domain.Room;

import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ReservationRepository {

    List<Room> findAvailableRooms(Date startDate, Date endDate, int start, int batchSize);


}
