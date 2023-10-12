package ae.rak.entity;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

@Entity
public class ProfileEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String fullName;
    public String userName;
    public String company;
    public String profilePicUrl;

    @ElementCollection
    public List<String> roles;

    @ElementCollection
    public List<String> favourites;

    public List<String> banners;

    @OneToMany(cascade = CascadeType.ALL)
    public List<ApplicationEntity> applications;

    // public void setId (Long id) {
    //     this.id =id;
    // }

    // public Long getId () {
    //     return this.id;
    // }
}
