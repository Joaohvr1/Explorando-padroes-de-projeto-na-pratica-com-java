package dio.padroes.java.spring.entities;

import javax.persistence.*;

@Entity(name = "Distributors")
public class Distributors {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long idDistributor;
    private String name;
    private String comments;
    @ManyToOne
    private Address address;
    private Integer addressNumber;

    public Long getIdDistributor() { return idDistributor; }

    public void setIdDistributor(Long idDistributor) {
        this.idDistributor = idDistributor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Integer getAddressNumber() { return addressNumber; }

    public void setAddressNumber(Integer addressNumber) { this.addressNumber = addressNumber; }
}