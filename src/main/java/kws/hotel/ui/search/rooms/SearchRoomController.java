package kws.hotel.ui.search.rooms;

import kws.hotel.domain.Room;
import kws.hotel.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 9:20 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
public class SearchRoomController {

    @Autowired
    private ReservationRepository reservationRepository;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.setValidator(new SearchRoomFormValidator());
    }

    @RequestMapping(value = "/hotel/rooms/search.html", method = RequestMethod.POST)
    public String searchRoomsInDateRange(Model model, @ModelAttribute("searchRoomForm") @Valid SearchRoomForm searchRoomForm, BindingResult result){
        if(result.hasErrors()) {
            System.out.println("There are errors");
            model.addAttribute("searchRoomForm", searchRoomForm);
            return "/hotel/rooms/search";
        }
        Date startDate = searchRoomForm.getStartDate();
        Date endDate = searchRoomForm.getEndDate();

        System.out.println("Search Form " + searchRoomForm);
        List<Room> rooms = reservationRepository.findAvailableRooms(startDate, endDate, 0, 100);
        model.addAttribute("rooms", rooms);
        return "/hotel/rooms/browse";
    }

    @RequestMapping(value = "/hotel/rooms/search.html", method = RequestMethod.GET)
    public String searchRooms(Model model){
        SearchRoomForm searchRoomForm = new SearchRoomForm();
        model.addAttribute("searchRoomForm", searchRoomForm);
        return "/hotel/rooms/search";
    }

}

class SearchRoomFormValidator implements Validator {

    @Override
    public boolean supports(Class<?> aClass) {
        return aClass.equals(SearchRoomForm.class);
    }

    @Override
    public void validate(Object o, Errors errors) {
        SearchRoomForm searchRoomForm = (SearchRoomForm) o;
        Date startDate = searchRoomForm.getStartDate();
        Date endDate = searchRoomForm.getEndDate();

        if(startDate == null) {
            errors.rejectValue("startDate", "search.rooms.start.date.should.select");
            return;
        }
        if(endDate == null) {
            errors.rejectValue("endDate", "search.rooms.end.date.should.select");
            return;
        }

        if(startDate.getTime() > endDate.getTime()) {
            errors.rejectValue("endDate", "search.rooms.end.date.should.be.after.start.date");
        }
    }
}
