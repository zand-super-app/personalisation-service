package ae.rak.entity;

import java.util.List;
import io.quarkus.hibernate.orm.panache.PanacheEntityBase;

import jakarta.persistence.*;

@Entity
public class ApplicationEntity extends PanacheEntityBase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long id;

    public String title;

    public String code;

    public String iconName;

    public String serviceType;

    public String location;

    public String serviceUrl;

    @ElementCollection
    public List<String> modules;
}
