package person.management.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import static javax.persistence.FetchType.LAZY;

@Getter
@Setter
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode
@Table(name = "address")
public class Address extends AbstractEntity {

    private static final long serialVersionUID = 1L;

    @NotNull
    @Column(name = "street", length = 60, nullable = false)
    private String street;

    @NotNull
    @Column(name = "city", length = 20, nullable = false)
    private String city;

    @NotNull
    @Column(name = "state", length = 20, nullable = false)
    private String state;

    @NotNull
    @Size(max = 10)
    @Column(name = "postal_code",length = 10)
    private String postalCode;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "person_id")
    private Person person;
}
