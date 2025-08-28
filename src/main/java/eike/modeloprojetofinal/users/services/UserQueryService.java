package eike.modeloprojetofinal.users.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import eike.modeloprojetofinal.users.dto.UserResponseDTO;
import eike.modeloprojetofinal.users.repositories.UserRepository;
import eike.modeloprojetofinal.users.services.UserMapper.UserMapper;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserQueryService {
    private final UserRepository userRepository;

    public List<UserResponseDTO> findAll() {
        return userRepository.findAll()
                .stream()
                .map(UserMapper::toResponseDTO)
                .toList();
    }

    public List<UserResponseDTO> findAllByUsername(String name) {
        return userRepository.findByNameLikeIgnoreCase(name)
                .stream()
                .map(UserMapper::toResponseDTO)
                .toList();
    }

    public List<UserResponseDTO> findAllByEmail(String email) {
        return userRepository.findByEmailLikeIgnoreCase(email)
                .stream()
                .map(UserMapper::toResponseDTO)
                .toList();
    }
}
