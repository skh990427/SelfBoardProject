package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class BoardDeleteResponseDto {
    private Long id;
    private String title;
    private String message;

    public BoardDeleteResponseDto(Long id, String title, String message) {
        this.id = id;
        this.title = title;
        this.message = message;
    }
}
