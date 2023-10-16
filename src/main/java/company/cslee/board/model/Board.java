package company.cslee.board.model;

import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Entity
@Getter
public class Board extends BaseEntity {
    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    protected Board() {

    }

    @Builder
    protected Board(String content, String title, User user) {
        this.content = content;
        this.title = title;
        this.user = user;
    }
}
