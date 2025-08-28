package eike.modeloprojetofinal.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import eike.modeloprojetofinal.users.dto.UserCreateDTO;
import eike.modeloprojetofinal.users.dto.UserResponseDTO;
import eike.modeloprojetofinal.users.dto.UserUpdateEmailDTO;
import eike.modeloprojetofinal.users.dto.UserUpdateNameDTO;
import eike.modeloprojetofinal.users.services.UserCreateService;
import eike.modeloprojetofinal.users.services.UserDeleteService;
import eike.modeloprojetofinal.users.services.UserQueryService;
import eike.modeloprojetofinal.users.services.UserUpdateService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/users")
public class UserController {
    private final UserCreateService userCreateService;
    private final UserQueryService userQueryService;
    private final UserUpdateService userUpdateService;
    private final UserDeleteService userDeleteService;



    @GetMapping("find-all")
    public ResponseEntity<List<UserResponseDTO>> getUserById(Long id) {
        return ResponseEntity.ok(userQueryService.findAll());
    }
    @GetMapping("find-by-name")
    public ResponseEntity<List<UserResponseDTO>> findUserByName(@RequestParam String name) {
        return ResponseEntity.ok(userQueryService.findAllByUsername(name));
    }
    @GetMapping("find-by-email")
    public ResponseEntity<List<UserResponseDTO>> findUserByEmail(@RequestParam String email) {
        return ResponseEntity.ok(userQueryService.findAllByEmail(email));
    }

    @PostMapping("/create")
    public ResponseEntity<UserResponseDTO> createUser(@RequestBody UserCreateDTO userCreateDTO) {
        return ResponseEntity.ok(userCreateService.createUser(userCreateDTO));
    }

    @DeleteMapping("{id}/delete")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        userDeleteService.deleteUserById(id);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/update-name")
    public ResponseEntity<Void> updateUserName(@PathVariable Long id, @RequestBody UserUpdateNameDTO dto) {
        userUpdateService.updateName(id, dto);
        return ResponseEntity.noContent().build();
    }

    @PatchMapping("{id}/update-email")
    public ResponseEntity<Void> updateUserEmail(@PathVariable Long id, @RequestBody UserUpdateEmailDTO dto) {
        userUpdateService.updateEmail(id, dto);
        return ResponseEntity.noContent().build();
    }
}
