package org.adaschool.Seguridad.API.REST.Domain;

import org.adaschool.Seguridad.API.REST.Domain.booking;
import org.adaschool.Seguridad.API.REST.Domain.bookingDto;
import org.adaschool.Seguridad.API.REST.Domain.user;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record bookingService(
        bookingRepository bookingRepository
) {
    public void createBooking(bookingDto bookingDto){
        booking booking = org.adaschool.Seguridad.API.REST.Domain.booking.builder()
                .id(bookingDto.id())
                .state(bookingDto.state())
                .quantity(bookingDto.quantity())
                .user(bookingDto.user())
                .build();
        bookingRepository.save(booking);
    }

    public List<booking> findAll(){return bookingRepository.findAll();}

    public void deleteBooking(String id){
        booking booking = bookingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Reservation not found"));
        bookingRepository.delete(booking);
    }

    public booking findBookingById(String id) {
        return bookingRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Reservation not found"));
    }

    public void updateBooking(bookingDto bookingDto){
        booking booking = bookingRepository.findById(bookingDto.id())
                .orElseThrow(()-> new RuntimeException("Reservation not found"));
        updateBookingDate(booking, bookingDto);
        bookingRepository.save(booking);
    }

    private void updateBookingDate(booking booking, bookingDto bookingDto) {

        booking.setUser(bookingDto.user());
        booking.setState(bookingDto.state());
        booking.setQuantity(bookingDto.quantity());

    }



}
