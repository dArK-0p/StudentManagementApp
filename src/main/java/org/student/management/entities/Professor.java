package org.student.management.entities;


import jakarta.persistence.*;
import org.student.management.entities.embeddables.AuditMetadata;
import org.student.management.entities.embeddables.PersonInfo;
import org.student.management.enums.ProfessorStatus;

@Entity
@Table(name = "professor", indexes = @Index(name = "idx_professor_dept_id", columnList = "dept_id"))
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid", nullable = false, length = 20, unique = true)
    private String uid;

    // FK references Department.id (PK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_id", nullable = false, foreignKey = @ForeignKey(name = "fk_professor_dept"))
    private Department dept;

    @Column(name = "status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProfessorStatus status;

    @Embedded private PersonInfo person;
    @Embedded private AuditMetadata audit;

    private Professor(
            Long id,
            String uid,
            Department dept,
            ProfessorStatus status,
            PersonInfo person,
            AuditMetadata audit
    ) {
        this.id = id;
        this.uid = uid;
        this.dept = dept;
        this.status = status;
        this.person = person;
        this.audit = audit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public ProfessorStatus getStatus() {
        return status;
    }

    public void setStatus(ProfessorStatus status) {
        this.status = status;
    }

    public PersonInfo getPerson() {
        return person;
    }

    public void setPerson(PersonInfo person) {
        this.person = person;
    }

    public AuditMetadata getAudit() {
        return audit;
    }

    public void setAudit(AuditMetadata audit) {
        this.audit = audit;
    }
}
