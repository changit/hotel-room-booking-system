package kws.hotel.ui;

import kws.hotel.domain.Reservation;
import kws.hotel.pgw.Payment;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReservationController {

    @RequestMapping(value = "/hotel/rooms/reserve.html", method = RequestMethod.POST)
    private String reserve(Model model, Reservation reservation, Payment payment) {
        return null;
    }

    @RequestMapping(value = "/hotel/rooms/reserve.html", method = RequestMethod.GET)
    private String reserve(Model model) {
        return null;
    }

}
