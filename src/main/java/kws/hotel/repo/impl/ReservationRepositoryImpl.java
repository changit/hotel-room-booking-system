package kws.hotel.repo.impl;

import kws.hotel.domain.Room;
import kws.hotel.domain.RoomSize;
import kws.hotel.domain.RoomType;
import kws.hotel.repo.ReservationRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReservationRepositoryImpl implements ReservationRepository{
    
    @Override
    public List<Room> findAvailableRooms(Date startDate, Date endDate, int start, int batchSize) {
        List<Room> roomList = new ArrayList<Room>();

        Room room1 = new Room();

        RoomSize roomSize = new RoomSize();
        roomSize.setDescription("Large room");
        roomSize.setName("Large");
        room1.setRoomSize(roomSize);

        RoomType roomType = new RoomType();
        roomType.setName("Deplex");
        room1.setRoomType(roomType);
        room1.setId(5L);



        Room room2 = new Room();

        RoomSize roomSize2 = new RoomSize();
        roomSize2.setDescription("Smal room");
        roomSize2.setName("Very Small");
        room2.setRoomSize(roomSize2);

        RoomType roomType2 = new RoomType();
        roomType2.setName("Sigle");
        room2.setRoomType(roomType2);
        room2.setId(6L);


        roomList.add(room1);
        roomList.add(room2);

        return roomList;
    }
}
