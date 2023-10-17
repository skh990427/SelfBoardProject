package company.cslee.board.repository;

import company.cslee.board.dto.ResponseDto.BoardDetailResponseDto;
import company.cslee.board.dto.ResponseDto.BoardListResponseDto;
import company.cslee.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select new company.cslee.board.dto.ResponseDto.BoardListResponseDto(b.id, b.title, u.name) from Board b join b.user u")
    List<BoardListResponseDto> findBoardListDto();

    @Query("select new company.cslee.board.dto.ResponseDto.BoardDetailResponseDto(b.title, b.content, u.name, u.id) from Board b join b.user u")
    Optional<BoardDetailResponseDto> findBoardDetailById(Long id);
}
