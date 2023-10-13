package company.cslee.board.dto.ResponseDto;

import company.cslee.board.model.User;
import lombok.Getter;

@Getter
public class BoardListDto {
    private Long id;
    private String title;
    private String name;

    public BoardListDto(Long id, String title, String name) {
        this.id = id;
        this.title = title;
        this.name = name;
    }
}
