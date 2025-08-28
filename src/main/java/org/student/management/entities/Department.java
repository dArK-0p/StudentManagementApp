package org.student.management.entities;

import jakarta.persistence.*;
import org.student.management.entities.embeddables.AuditMetadata;

@Entity
@Table(name = "department", indexes = @Index(name = "idx_department_code", columnList = "code"))
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "code", nullable = false, length = 10, unique = true)
    private String code;

    @Column(name = "full_name", nullable = false, length = 200)
    private String fullName;

    @Embedded private AuditMetadata audit;

    private Department(
            Long id,
            String code,
            String fullName,
            AuditMetadata audit
    ) {
        this.id = id;
        this.code = code;
        this.fullName = fullName;
        this.audit = audit;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public AuditMetadata getAudit() {
        return audit;
    }

    public void setAudit(AuditMetadata audit) {
        this.audit = audit;
    }
}
