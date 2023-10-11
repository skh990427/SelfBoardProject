package company.cslee.board.model;

import lombok.Getter;
import org.springframework.web.bind.annotation.Mapping;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Table(name = "user")
public class User extends BaseEntity{

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "user")
    private List<Board> boards = new ArrayList<>();
}
