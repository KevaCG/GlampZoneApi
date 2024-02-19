package com.gp.GlampZoneApi.services;

import com.gp.GlampZoneApi.entities.User;
import com.gp.GlampZoneApi.exceptions.MyException;
import com.gp.GlampZoneApi.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class UserService {

    @Autowired
    UserRepository usersRepository;

    public List<User> getUsers(){
        return usersRepository.findAll();
    }

    public Optional<User> getUser(Long userId){
        return usersRepository.findById(userId);
    }

    @Transactional
    public void postUser(Long idUser, String firstName, String lastName, Integer numberPhone, String email,
                         String password, Date birthDate, LocalDate registerDate, String profilePicture,
                         String location, boolean status) throws MyException{

        validar(firstName, lastName, numberPhone, email, password, birthDate, location);

        User user = new User();


        user.setIdUser(idUser);
        user.setFirstName(firstName);
        user.setLastName(lastName);
        user.setNumberPhone(numberPhone);
        user.setEmail(email);
        user.setPassword(password);
        user.setLocation(location);
        user.setBirthDate(birthDate);
        user.setRegisterDate(registerDate);
        user.setProfilePicture(profilePicture);
        user.setStatus(status);


        usersRepository.save(user);
    }

    @Transactional
    public void putUser(Long idUser, String firstName, String lastName, Integer numberPhone, String email,
                        String password, Date birthDate, LocalDate registerDate, String profilePicture, String location,
                        boolean status) throws MyException{

        validar(firstName, lastName, numberPhone, email, password, birthDate, location);

        Optional<User> response = usersRepository.findById(idUser);

        if (response.isPresent()){
            User user = response.get();

            user.setIdUser(idUser);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setNumberPhone(numberPhone);
            user.setEmail(email);
            user.setPassword(password);
            user.setLocation(location);
            user.setBirthDate(birthDate);
            user.setRegisterDate(registerDate);
            user.setProfilePicture(profilePicture);
            user.setStatus(status);

            usersRepository.save(user);
        }
    }

    @Transactional
    public void deleteUser(Long userId){
        usersRepository.deleteById(userId);
    }

    public void validar(String firstName, String lastName, Integer numberPhone, String email,
                        String password, Date birthDate, String location) throws MyException{

        if(firstName.isEmpty()){
            throw new MyException("El Nombre no puede ser nulo");
        }

        if(lastName.isEmpty()){
            throw new MyException("El Apellido no puede ser nulo");
        }

        if(numberPhone == null){
            throw new MyException("El Numero de telefono no puede ser nulo");
        }

        if(email.isEmpty()){
            throw new MyException("El Email no puede ser nulo");
        }

        if(birthDate == null){
            throw new MyException("La Fecha de Nacimiento no puede ser nula");
        }

        if(password.isEmpty()){
            throw new MyException("La Contraseña no puede ser nulo");
        }

        if(location.isEmpty()){
            throw new MyException("La Locacion no puede ser nulo");
        }
    }
}
