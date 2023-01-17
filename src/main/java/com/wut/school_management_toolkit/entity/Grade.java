package com.wut.school_management_toolkit.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Check;

import java.io.Serializable;
import java.sql.Date;

@Entity
@Table(name = "grades")
@Check(constraints = "value between 1 and 10")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Grade implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "grade_id", nullable = false)
    private Long gradeId;

    @Column(name = "value", nullable = false)
    private Double value;

    @Column(name = "date", nullable = false)
    private Date date;

    @ManyToOne
    @JoinColumns({
            @JoinColumn(name = "student_id", referencedColumnName = "student_id", nullable = false),
            @JoinColumn(name = "course_id", referencedColumnName = "course_id", nullable = false)
    })
    private Enrollment enrollment;
}
