package kws.hotel.repo;

import kws.hotel.domain.Room;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 9:24 PM
 * To change this template use File | Settings | File Templates.
 */

public interface RoomRepository {

    public Room findById(Long roomNumber);
}
