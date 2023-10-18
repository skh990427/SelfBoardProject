package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class BoardUpdateResponseDto {
    private Long id;
    private String title;

    public BoardUpdateResponseDto(Long id, String title) {
        this.id = id;
        this.title = title;
    }
}
