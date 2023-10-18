package company.cslee.board.dto.RequestDto;

import lombok.Getter;

@Getter
public class BoardUpdateRequestDto {
    private Long id;
    private String title;
    private String content;
}
