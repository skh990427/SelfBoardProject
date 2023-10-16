package company.cslee.board.controller;

import company.cslee.board.dto.ResponseDto.BoardListResponseDto;
import company.cslee.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list/all")
    public List<BoardListResponseDto> boardListAll() {
        return boardService.boardListAll();
    }

}
