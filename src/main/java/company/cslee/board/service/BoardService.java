package company.cslee.board.service;

import company.cslee.board.dto.RequestDto.BoardWriteRequestDto;
import company.cslee.board.dto.ResponseDto.BoardListResponseDto;
import company.cslee.board.dto.ResponseDto.BoardWriteResponseDto;
import company.cslee.board.model.Board;
import company.cslee.board.model.User;
import company.cslee.board.repository.BoardRepository;
import company.cslee.board.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    public List<BoardListResponseDto> boardListAll() {
        return boardRepository.findBoardListDto();
    }

    @Transactional
    public Optional<BoardWriteResponseDto> write(BoardWriteRequestDto boardWriteRequestDto) {
        Optional<User> findUser = userRepository.findById(boardWriteRequestDto.getUserId());

        if (findUser.isEmpty()) {
            return Optional.empty();
        }

        Board newBoard = Board.builder()
                .title(boardWriteRequestDto.getTitle())
                .content(boardWriteRequestDto.getContent())
                .user(findUser.get())
                .build();

        boardRepository.save(newBoard);
        return Optional.of(new BoardWriteResponseDto(newBoard.getId()));

    }
}
