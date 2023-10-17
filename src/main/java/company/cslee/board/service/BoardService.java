package company.cslee.board.service;

import company.cslee.board.dto.RequestDto.BoardDeleteRequestDto;
import company.cslee.board.dto.RequestDto.BoardWriteRequestDto;
import company.cslee.board.dto.ResponseDto.BoardDeleteResponseDto;
import company.cslee.board.dto.ResponseDto.BoardDetailResponseDto;
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

    public Optional<BoardDetailResponseDto> boardDetail(Long id) {
//        Optional<BoardDetailResponseDto> findBoard = boardRepository.findBoardDetailById(id);
//        if (findBoard.isEmpty()) {
//            Optional.empty();
//        }

        Optional<Board> findBoard = boardRepository.findById(id);
        if (findBoard.isEmpty()) {
            return Optional.empty();
        }

        BoardDetailResponseDto result = new BoardDetailResponseDto(findBoard.get().getTitle(), findBoard.get().getContent(), findBoard.get().getUser().getName(), findBoard.get().getUser().getId());

        return Optional.of(result);

    }

    @Transactional
    public Optional<BoardDeleteResponseDto> deleteBoard(Long id, BoardDeleteRequestDto boardDeleteRequestDto) {
        Optional<Board> findBoard = boardRepository.findById(id);
        if (findBoard.isEmpty()) {
            return Optional.empty();
        }

        if (findBoard.get().getUser().getId() == boardDeleteRequestDto.getUserId()) {
            boardRepository.deleteById(id);
            return Optional.of(new BoardDeleteResponseDto(findBoard.get().getId(), findBoard.get().getTitle(), "삭제가 완료되었습니다."));
        }

        return Optional.empty();
    }
}
