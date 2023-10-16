package company.cslee.board.dto.ResponseDto;

import lombok.Getter;

@Getter
public class BoardWriteResponseDto {
    private Long id;

    public BoardWriteResponseDto(Long id) {
        this.id = id;
    }
}
