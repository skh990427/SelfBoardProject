package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class BoardModifyLoadResponseDto {
    private String title;
    private String content;

    public BoardModifyLoadResponseDto(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
