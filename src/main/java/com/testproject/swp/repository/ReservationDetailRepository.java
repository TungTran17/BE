package com.testproject.swp.repository;

import com.testproject.swp.entity.ReservationDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationDetailRepository extends JpaRepository<ReservationDetail, Integer> {

        @Query("SELECT count(r) FROM  ReservationDetail r  " +
                        "WHERE r.beginTime=:date AND (r.docterID=:docterID OR r.nurseID=:nurseID) AND r.slot=:slot")
        public int checkReservationDetail(Date date, int docterID, int nurseID, int slot);

        @Query("SELECT r FROM  ReservationDetail r  " +
                        "WHERE r.reservation.reservationID =:ReservationIs")
        public List<ReservationDetail> getReservationDetailByReservationIs(int ReservationIs);
}
