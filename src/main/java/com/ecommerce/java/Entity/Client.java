package com.ecommerce.java.Entity;

import java.util.Date;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Client {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_client")
    private String id;
    @Column(name = "dv_name")
    private String name;
    @Column(name = "dv_lastname")
    private String lastname;
    @Column(name = "dv_document")
    private Long document;
    @Column(name = "dv_phoneNumber")
    private String phoneNumber;
    @Column(name = "dv_address")
    private String address;
    @Column(name = "dv_email")
    private String email;
    @Column(name = "dv_password")
    private String password;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_load")
    private Date load;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_edit")
    private Date edit;
    @Column(name = "dv_statusClient")
    private Boolean statusClient;
    @Column(name = "dv_rol")
    private Rol rol;

    @OneToOne
    private Photo photo;

}
