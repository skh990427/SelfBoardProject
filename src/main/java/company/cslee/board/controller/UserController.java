package company.cslee.board.controller;

import company.cslee.board.dto.RequestDto.LoginRequestDto;
import company.cslee.board.dto.RequestDto.UserRequestDto;
import company.cslee.board.dto.ResponseDto.LoginResponseDto;
import company.cslee.board.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/signup")
    public void signUpUser(@RequestBody UserRequestDto userRequestDto) {
        userService.signUp(userRequestDto);
    }

    @PostMapping("/login")
    public Optional<LoginResponseDto> login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse httpServletResponse) {
        System.out.println("loginRequestDto = " + loginRequestDto.getEmail());
        Optional<LoginResponseDto> loginUser = userService.login(loginRequestDto);

        if (loginUser.isPresent()) {
            Cookie cookie = new Cookie("user_id", String.valueOf(loginUser.get().getId()));
            httpServletResponse.addCookie(cookie);

            return loginUser;
        } else {
            return Optional.empty();
        }
    }

}
