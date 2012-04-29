package kws.hotel.service;

import kws.hotel.domain.Reservation;
import kws.hotel.pgw.Payment;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 9:25 PM
 * To change this template use File | Settings | File Templates.
 */
public interface RoomReservationService {

    public void reserve(Reservation reservation, Payment payment);


}
