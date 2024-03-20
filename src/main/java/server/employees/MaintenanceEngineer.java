package server.employees;

import jakarta.persistence.*;
import server.catalog.Producer;

@Entity
@Table(name = "maintenance_engineers")
public class MaintenanceEngineer extends Employee {
    private final String SEQ_NAME = "maintenance_engineer_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    public MaintenanceEngineer() {
        super();
    }

    public MaintenanceEngineer(String name, Integer experience, Double baseSalary, Producer producer) {
        super(name, experience, baseSalary, producer);
    }

    @Override
    public Double calculateSalary() {
        return baseSalary + (baseSalary * experience) / 5.0;
    }

    @Override
    public String toString() {
        return "MaintenanceEngineer{" +
                "name='" + name + '\'' +
                ", experience=" + experience +
                ", baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
