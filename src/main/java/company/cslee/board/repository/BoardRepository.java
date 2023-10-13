package company.cslee.board.repository;

import company.cslee.board.dto.ResponseDto.BoardListDto;
import company.cslee.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {

    @Query("select new company.cslee.board.dto.ResponseDto.BoardListDto(b.id, b.title, u.name) from Board b join b.user u")
    List<BoardListDto> findBoardListDto();
}
