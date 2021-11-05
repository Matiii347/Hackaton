
package com.ecommerce.java.Entity;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

@Data
@Entity
public class CashRegister {

@Id
@GeneratedValue(generator = "uuid")
@GenericGenerator(name = "uuid", strategy = "uuid2")
@Column(name = "id_cashRegister")
private String id;
@Column(name = "dv_status")
private Boolean status;	
}
