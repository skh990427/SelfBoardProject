package company.cslee.board.controller;

import company.cslee.board.dto.RequestDto.BoardWriteRequestDto;
import company.cslee.board.dto.ResponseDto.BoardListResponseDto;
import company.cslee.board.dto.ResponseDto.BoardWriteResponseDto;
import company.cslee.board.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/list/all")
    public List<BoardListResponseDto> boardListAll() {
        return boardService.boardListAll();
    }

    @PostMapping("/write")
    public Optional<BoardWriteResponseDto> boardWrite(@RequestBody BoardWriteRequestDto boardWriteRequestDto) {
        return boardService.write(boardWriteRequestDto);
    }

}
