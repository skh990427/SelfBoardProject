package company.cslee.board.dto.RequestDto;

import lombok.Getter;

@Getter
public class BoardWriteRequestDto {
    private Long userId;
    private String title;
    private String content;
}
