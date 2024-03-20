package server.product;


import jakarta.persistence.*;

@Entity
@Table(name = "prices")
public class Price {
    private Double totalPrice;
    private Double basePrice;
    private Integer percentageDiscount;
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    private static final String SEQ_NAME = "price_seq";
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQ_NAME)
    @SequenceGenerator(name = SEQ_NAME, sequenceName = SEQ_NAME, allocationSize = 1)
    private Long id;

    public Price(Double basePrice, Integer percentageDiscount, Product product) {
        this.basePrice = basePrice;
        this.percentageDiscount = percentageDiscount;
        totalPrice = calculateTotalPrice();
        this.product = product;
    }

    public Price() {

    }

    private Double calculateTotalPrice() {
        return basePrice - (basePrice * percentageDiscount) / 100.0;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(Double basePrice) {
        this.basePrice = basePrice;
    }

    public Integer getPercentageDiscount() {
        return percentageDiscount;
    }

    public void setPercentageDiscount(Integer percentageDiscount) {
        this.percentageDiscount = percentageDiscount;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
