package com.ecommerce.java.Entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Data
public class Ticket {

    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    @Column(name = "id_order")
    private String id;
    @Column(name = "dv_status")
    private Boolean status;
    @Column(name = "dv_delivery")
    private Boolean delivery;
    @Column(name = "dv_payment")
    private Boolean payment;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_load")
    private Date load;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "dv_edit")
    private Date edit;

    @ManyToOne
    private Client client;

    @ManyToOne
    private CashRegister cashRegister;

    @OneToMany
    private List<Product> product;

}
