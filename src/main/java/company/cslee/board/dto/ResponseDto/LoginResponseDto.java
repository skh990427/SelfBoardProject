package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class LoginResponseDto {
    private Long id;
    private String Email;
    private String name;

    public LoginResponseDto(Long id, String email, String name) {
        this.id = id;
        Email = email;
        this.name = name;
    }
}
