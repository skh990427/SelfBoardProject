package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class BoardDetailResponseDto {
    private String title;
    private String content;
    private String name;
    private Long userId;

    public BoardDetailResponseDto(String title, String content, String name, Long userId) {
        this.title = title;
        this.content = content;
        this.name = name;
        this.userId = userId;
    }
}


