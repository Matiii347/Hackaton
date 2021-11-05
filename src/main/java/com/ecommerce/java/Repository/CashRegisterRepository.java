package com.ecommerce.java.Repository;

import com.ecommerce.java.Entity.CashRegister;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CashRegisterRepository extends JpaRepository<CashRegister, String> {

    @Query("SELECT a FROM CashRegister a WHERE a.status=true")
    public List<CashRegister> findTrue();

    @Query("SELECT a FROM CashRegister a WHERE a.status=false")
    public List<CashRegister> findFalse();
}
