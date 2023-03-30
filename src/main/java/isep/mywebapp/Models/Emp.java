package isep.mywebapp.Models;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name="emp", schema = "TP1SCHEMA")
@Data

public class Emp {
    @Id
    @GeneratedValue
    private Long empno;
    @Column(name = "ename")
    private String ename;
    @Column(name = "efirst")
    private String efirst;
    @Column(name = "job")
    private String job;
    @Column(name = "mgr")
    private Long mgr;
    @Column(name = "sal")
    private Long sal;

}