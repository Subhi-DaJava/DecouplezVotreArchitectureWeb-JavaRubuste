package com.oc.airbusiness.airbusinessmvc.entities;

import com.oc.airbusiness.airbusinessmvc.enums.Level;
import com.oc.airbusiness.airbusinessmvc.enums.SubSystem;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class MaintenanceIssue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private long id;
    @NotBlank(message = "Entry Date is mandatory")
    private String entered;

    private String fixed;

    @NotBlank(message = "Details are mandatory")
    private String details;
    //@Enumerated(EnumType.STRING)
    private SubSystem subSystem;
    //@Enumerated(EnumType.STRING)
    private Level level;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEntered() {
        return entered;
    }

    public void setEntered(String entered) {
        this.entered = entered;
    }

    public String getFixed() {
        return fixed;
    }

    public void setFixed(String fixed) {
        this.fixed = fixed;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public SubSystem getSubSystem() {
        return subSystem;
    }

    public void setSubSystem(SubSystem subSystem) {
        this.subSystem = subSystem;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }
}
