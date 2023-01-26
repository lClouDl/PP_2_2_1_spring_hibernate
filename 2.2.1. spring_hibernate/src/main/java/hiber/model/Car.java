package hiber.model;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;

//Создал сущность для бд cars. Зависимость OneToOne из бд User установил на поле id
@Entity
@Table(name = "cars")
public class Car implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(mappedBy = "car")
    @JoinColumn(name = "id")
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    private User user;

    @Column(name = "model")
    private String model;

    @Column(name = "series")
    private int series;

    public  Car(){

    }

    public  Car(String model, int series) {
        this.model = model;
        this.series = series;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }



    @Override
    public String toString() {
        return "Car " +
                "model = " + model + ", car series = " + series;
    }
}
