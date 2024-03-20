package server.employees;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MappedSuperclass;
import server.catalog.Producer;

import java.util.Objects;

@MappedSuperclass
public abstract class Employee {
    protected String name;
    protected Integer experience;
    protected Double baseSalary;

    @ManyToOne
    @JoinColumn(name = "producer_id")
    protected Producer producer;

    public Employee() {
        name = "";
        experience = 0;
        baseSalary = 0.0;
    }

    public Employee(String name, Integer experience, Double baseSalary, Producer producer) {
        this.name = name;
        this.experience = experience;
        this.baseSalary = baseSalary;
        this.producer = producer;
    }

    public abstract Double calculateSalary();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getExperience() {
        return experience;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name)
                && Objects.equals(experience, employee.experience)
                && Objects.equals(baseSalary, employee.baseSalary);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, experience, baseSalary);
    }
}
