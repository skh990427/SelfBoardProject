package company.cslee.board.model;

import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Board extends BaseEntity {
    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
