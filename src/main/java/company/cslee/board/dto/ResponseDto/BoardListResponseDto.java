package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String title;
    private String name;

    public BoardListResponseDto(Long id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }
}
