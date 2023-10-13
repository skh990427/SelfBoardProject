package company.cslee.board.controller;

import company.cslee.board.dto.ResponseDto.BoardListDto;
import company.cslee.board.model.Board;
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
    public List<BoardListDto> boardListAll() {
        return boardService.boardListAll();
    }

}
