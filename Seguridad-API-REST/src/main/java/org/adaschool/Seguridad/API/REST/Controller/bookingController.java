package org.adaschool.Seguridad.API.REST.Controller;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.adaschool.Seguridad.API.REST.Domain.bookingService;
import org.adaschool.Seguridad.API.REST.Domain.bookingDto;

@RestController
@RequestMapping("/api/v1/booking")
public record bookingController(
        bookingService bookingService
) {
    @PostMapping
    public ResponseEntity<?> createBookingooking(@RequestBody bookingDto bookingDto) {
        bookingService.createBooking(bookingDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<?> searchAll(){return new ResponseEntity<>(bookingService.findAll(),
            HttpStatus.OK);
    }

    @GetMapping("/search/{id}")
    public ResponseEntity<?> searchBooking(@PathVariable("id") String id) {
        return new  ResponseEntity<>(bookingService.findBookingById(id), HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteBooking(@PathVariable("id") String id) {
        bookingService.deleteBooking(id);
        return new  ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateBooking(@RequestBody bookingDto bookingDto){
        bookingService.updateBooking(bookingDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

