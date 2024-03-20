package server.employees;

import jakarta.persistence.*;
import server.catalog.Producer;

import java.util.Objects;

@Entity
@Table(name = "production_workers")
public class ProductionWorker extends Employee {
    private Float rate;
    private final String SEQ_NAME = "production_worker_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    public ProductionWorker() {
        super();
        rate = 1f;
    }

    public ProductionWorker(String name, Integer experience, Double baseSalary, Float rate, Producer producer) {
        super(name, experience, baseSalary, producer);
        this.rate = rate;
    }

    @Override
    public Double calculateSalary() {
        return rate * (baseSalary + baseSalary * experience / 5.0);
    }

    @Override
    public String toString() {
        return "ProductionWorker{" +
                "rate=" + rate +
                ", name='" + name + '\'' +
                ", experience=" + experience +
                ", baseSalary=" + baseSalary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProductionWorker employee = (ProductionWorker) o;
        return Objects.equals(name, employee.name)
                && Objects.equals(experience, employee.experience)
                && Objects.equals(baseSalary, employee.baseSalary)
                && Objects.equals(rate, employee.rate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, baseSalary, rate);
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
