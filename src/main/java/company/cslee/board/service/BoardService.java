package company.cslee.board.service;

import company.cslee.board.dto.ResponseDto.BoardListDto;
import company.cslee.board.model.Board;
import company.cslee.board.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<BoardListDto> boardListAll() {
        return boardRepository.findBoardListDto();
    }
}
