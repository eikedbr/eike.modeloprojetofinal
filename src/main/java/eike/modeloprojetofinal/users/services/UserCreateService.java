package eike.modeloprojetofinal.users.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import eike.modeloprojetofinal.users.dto.UserCreateDTO;
import eike.modeloprojetofinal.users.dto.UserResponseDTO;
import eike.modeloprojetofinal.users.entities.User;
import eike.modeloprojetofinal.users.repositories.UserRepository;
import eike.modeloprojetofinal.users.services.UserMapper.UserMapper;

@Service
@RequiredArgsConstructor
public class UserCreateService {

    private final UserRepository userRepository;

    public UserResponseDTO createUser(UserCreateDTO dto) {
        User user = UserMapper.toEntity(dto);
        return UserMapper.toResponseDTO(userRepository.save(user));
    }
}
