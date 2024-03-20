package server.employees;


import jakarta.persistence.*;
import server.catalog.Producer;

@Entity
@Table(name = "quality_control_engineers")
public class QualityControlEngineer extends Employee {
    private final String SEQ_NAME = "quality_control_engineer_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    public QualityControlEngineer() {
        super();
    }

    public QualityControlEngineer(String name, Integer experience, Double baseSalary, Producer producer) {
        super(name, experience, baseSalary, producer);
    }

    @Override
    public Double calculateSalary() {
        return baseSalary + baseSalary * experience / 5.0;
    }

    @Override
    public String toString() {
        return "QualityControlEngineer{" +
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
