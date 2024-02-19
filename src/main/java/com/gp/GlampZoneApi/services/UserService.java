package com.gp.GlampZoneApi.services;

import com.gp.GlampZoneApi.entities.Roles;
import com.gp.GlampZoneApi.entities.User;
import com.gp.GlampZoneApi.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User saveUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id, User user) {
        Optional<User> userToUpdate = userRepository.findById(id);
        if (userToUpdate.isPresent()) {
            try {
                User updatedUser = userToUpdate.get();
                updatedUser.setFirstName(user.getFirstName());
                updatedUser.setLastName(user.getLastName());
                updatedUser.setEmail(user.getEmail());
                updatedUser.setPassword(user.getPassword());
                updatedUser.setBirthDate(user.getBirthDate());
                updatedUser.setProfilePicture(user.getProfilePicture());
                updatedUser.setLocation(user.getLocation());
                updatedUser.setStatus(user.isStatus());

                return userRepository.save(updatedUser);
            } catch (Exception e) {
                // Manejar la excepción
                e.printStackTrace();
                throw new RuntimeException("Error al actualizar el usuario");
            }
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            throw new RuntimeException("Usuario no encontrado");
        }
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public boolean authenticateUser(String email, String password) {
        List<User> users = userRepository.findByEmail(email);
        if (!users.isEmpty()) {
            for (User user : users) {
                if (user.getPassword().equals(password)) {
                    return true;
                }
            }
        }
        return false;
    }
}

