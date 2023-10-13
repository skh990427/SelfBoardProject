package company.cslee.board.service;

import company.cslee.board.dto.RequestDto.LoginRequestDto;
import company.cslee.board.dto.RequestDto.UserRequestDto;
import company.cslee.board.dto.ResponseDto.LoginResponseDto;
import company.cslee.board.model.User;
import company.cslee.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public void signUp(UserRequestDto userRequestDto) {
        Optional<User> findUser = userRepository.findByEmail(userRequestDto.getEmail());

        if (findUser.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        User user = User.builder()
                .email(userRequestDto.getEmail())
                .name(userRequestDto.getName())
                .password(passwordEncoder.encode(userRequestDto.getPassword())) //Security 암호화 적용
                .build();

        userRepository.save(user);
    }

    public Optional<LoginResponseDto> login(LoginRequestDto loginRequestDto) {
        Optional<User> findUser = userRepository.findByEmail(loginRequestDto.getEmail());
        if (findUser.isEmpty())
            return Optional.empty();

        if (passwordEncoder.matches(loginRequestDto.getPassword(), findUser.get().getPassword())) {
            LoginResponseDto loginResponseDto = new LoginResponseDto(findUser.get().getId(), findUser.get().getEmail(), findUser.get().getName());
            return Optional.of(loginResponseDto);
        } else {
            return Optional.empty();
        }
    }
}
