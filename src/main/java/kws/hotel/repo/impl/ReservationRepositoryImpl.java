package kws.hotel.repo.impl;

import kws.hotel.domain.*;
import kws.hotel.repo.ReservationRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: uchan
 * Date: 4/19/12
 * Time: 10:48 PM
 * To change this template use File | Settings | File Templates.
 */
public class ReservationRepositoryImpl implements ReservationRepository{

    private static final Logger logger = LoggerFactory.getLogger(ReservationRepositoryImpl.class);

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Room> findAvailableRooms(Date startDate, Date endDate, int start, int batchSize) {
        logger.debug("Search Available rooms between {} and {}", startDate ,endDate);
        Query query = entityManager.createQuery("select r from Room r where r not in (" +
                "select r from Room r ,Reservation res where r member of res.rooms and (res.startTime >= :startTime and res.endTime <= :endTime and res.status in (:tempBooked, :booked)))");
        query.setFirstResult(start);
        query.setMaxResults(batchSize);
        query.setParameter("startTime", startDate);
        query.setParameter("endTime", endDate);
        query.setParameter("tempBooked", ReservationStatus.TEMP_BOOKED);
        query.setParameter("booked", ReservationStatus.BOOKED);
        return query.getResultList();
    }

    @Override
    @Transactional
    public void update(Reservation reservation) {
        Reservation merged = entityManager.merge(reservation);
        reservation.setId(merged.getId());
    }
}
