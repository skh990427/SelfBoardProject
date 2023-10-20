package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class BoardModifyLoadResponseDto {
    private Long userId;
    private String title;
    private String content;

    public BoardModifyLoadResponseDto(Long userId, String title, String content) {
        this.userId = userId;
        this.title = title;
        this.content = content;
    }
}
