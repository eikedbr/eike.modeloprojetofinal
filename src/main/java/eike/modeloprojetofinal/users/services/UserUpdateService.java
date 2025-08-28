package eike.modeloprojetofinal.users.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import eike.modeloprojetofinal.users.dto.UserUpdateEmailDTO;
import eike.modeloprojetofinal.users.dto.UserUpdateNameDTO;
import eike.modeloprojetofinal.users.entities.User;
import eike.modeloprojetofinal.users.repositories.UserRepository;

@Service
@RequiredArgsConstructor
public class UserUpdateService {

    private final UserRepository userRepository;

    public void updateEmail(Long id, UserUpdateEmailDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        user.setEmail(dto.email());
        userRepository.save(user);
    }

    public void updateName(Long id, UserUpdateNameDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("User not found"));
        user.setName(dto.name());
        userRepository.save(user);
    }
}
