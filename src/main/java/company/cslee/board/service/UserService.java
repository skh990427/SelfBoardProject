package company.cslee.board.service;

import company.cslee.board.dto.UserRequestDto;
import company.cslee.board.model.User;
import company.cslee.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public void signUp(UserRequestDto userRequestDto) {
        Optional<User> findUser = userRepository.findByEmail(userRequestDto.getEmail());

        if (findUser.isPresent()) {
            throw new IllegalStateException("이미 존재하는 회원입니다.");
        }

        User user = User.builder()
                .email(userRequestDto.getEmail())
                .name(userRequestDto.getName())
                .password(userRequestDto.getPassword()) //Security 로직 추가
                .build();

        userRepository.save(user);
    }
}
