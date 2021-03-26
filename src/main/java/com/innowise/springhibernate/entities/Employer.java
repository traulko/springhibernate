package com.innowise.springhibernate.entities;

import com.innowise.springhibernate.dto.EmployerDto;
import lombok.*;

import javax.persistence.*;

@NamedNativeQuery(
        name = "PostDtoNativeQuery",
        query = "SELECT e.id AS id, e.name AS name, e.company AS company FROM employer e",
        resultSetMapping = "PostDtoMapping"
)

@SqlResultSetMapping(
        name = "PostDtoMapping",
        classes = @ConstructorResult(
                targetClass = EmployerDto.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "name"),
                        @ColumnResult(name = "company")
                }
        )
)
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "employer")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employer extends Person {
    @Column(name = "company")
    private String company;

    public Employer(Employer employer) {
        super(employer.getName());
        this.company = employer.getCompany();
    }
}
