package org.adaschool.Seguridad.API.REST.Controller;

import org.adaschool.Seguridad.API.REST.Domain.userDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.adaschool.Seguridad.API.REST.Domain.userService;

@RestController
@RequestMapping("/api/v1/user")
public record userController(
        userService userService
) {
    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody userDto userDto){
        userService.createUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/userList")
    public ResponseEntity<?> searchAll() {
        return new ResponseEntity<>(userService.userList(), HttpStatus.OK);
    }

    @DeleteMapping("/deleted/{id}")

    public ResponseEntity<?> deleteUser (@PathVariable("id") String id) {
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateDoctor(@RequestBody userDto userDto){
        userService.updateUser(userDto);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
