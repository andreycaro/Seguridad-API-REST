package org.adaschool.Seguridad.API.REST.Domain;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public record userService(
        userRepository userRepository
) {
    public void createUser(userDto userDto){
        user user = org.adaschool.Seguridad.API.REST.Domain.user.builder()
                .id(userDto.id())
                .firstName(userDto.firstName())
                .lastName(userDto.lastName())
                .age(userDto.age())
                .email(userDto.email())
                .build();
        userRepository.save(user);
    }


    public List<user> userList(){
        return userRepository.findAll();
    }

    public user findUserById(String id){
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found..."));
    }

    public void deleteUser(String id) {
        user user = userRepository.findById(id).orElseThrow(() -> new RuntimeException("User not found..."));
        userRepository.delete(user);
    }

    public void updateUser(userDto userDto){
        user user = userRepository.findById(userDto.id())
                .orElseThrow(() -> new RuntimeException("Doctor not found..."));
        updateUserData(user, userDto);
        userRepository.save(user);
    }

    public void updateUserData(user user, userDto userDto){
        user.setFirstName(userDto.firstName());
        user.setLastName(userDto.lastName());
        user.setAge(userDto.age());
        user.setEmail(userDto.email());
    }

}
