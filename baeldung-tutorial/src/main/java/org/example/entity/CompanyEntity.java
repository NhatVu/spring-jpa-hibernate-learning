package org.example.entity;

import lombok.Data;
import org.example.constant.SchemaConstant;
import org.example.entity.embeded.ContactPerson;

import javax.persistence.*;

@Entity
@Table(name="company", schema = SchemaConstant.PRIMARY_SCHEMA)
@Data
public class CompanyEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "company_id_seq")
    @SequenceGenerator(name = "company_id_seq", sequenceName = SchemaConstant.PRIMARY_SCHEMA + ".company_id_seq", allocationSize = 1)
    private Integer id;
    private String name;
    private String address;
    private String phone;
    @Embedded
    private ContactPerson contactPerson;
}
