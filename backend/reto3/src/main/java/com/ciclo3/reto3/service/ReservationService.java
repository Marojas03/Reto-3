package com.ciclo3.reto3.service;

import com.ciclo3.reto3.model.Reservation;
import com.ciclo3.reto3.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return  reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation p){
        if(p.getIdReservation() == null){
            return reservationRepository.save(p);
        }else{
            Optional<Reservation> reservationOptional = reservationRepository.getReservation(p.getIdReservation());
            if(reservationOptional.isEmpty()){
                return reservationRepository.save(p);
            }else{
                return p;
            }
        }
    }
}
