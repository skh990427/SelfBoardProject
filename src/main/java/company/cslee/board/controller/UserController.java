package company.cslee.board.controller;

import company.cslee.board.dto.UserRequestDto;
import company.cslee.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public void signUpUser(@RequestBody UserRequestDto userRequestDto) {
        userService.signUp(userRequestDto);
    }

}
