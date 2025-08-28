package org.student.management.entities;

import jakarta.persistence.*;
import org.student.management.entities.embeddables.AuditMetadata;
import org.student.management.entities.embeddables.PersonInfo;
import org.student.management.enums.StudentStatus;

@Entity
@Table(name = "student", indexes = {
        @Index(name = "idx_student_advisor_id", columnList = "advisor_id"),
        @Index(name = "idx_student_dept_id", columnList = "dept_id")
})
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uid", nullable = false, length = 20, unique = true)
    private String uid;

    // FK references Professor.id (PK)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "advisor_id", foreignKey = @ForeignKey(name = "fk_student_advisor"))
    private Professor advisor;

    // FK references Department.id (PK)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_id", nullable = false, foreignKey = @ForeignKey(name = "fk_student_dept"))
    private Department dept;

    @Column(name = "status", nullable = false, length = 10)
    @Enumerated(EnumType.STRING)
    private StudentStatus status;

    @Embedded private PersonInfo person;
    @Embedded private AuditMetadata audit;

    public Student(
            Long id,
            String uid,
            Professor advisor,
            Department dept,
            StudentStatus status,
            PersonInfo person,
            AuditMetadata audit
    ) {
        this.id = id;
        this.uid = uid;
        this.advisor = advisor;
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

    public Professor getAdvisor() {
        return advisor;
    }

    public void setAdvisor(Professor advisor) {
        this.advisor = advisor;
    }

    public Department getDept() {
        return dept;
    }

    public void setDept(Department dept) {
        this.dept = dept;
    }

    public StudentStatus getStatus() {
        return status;
    }

    public void setStatus(StudentStatus status) {
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
