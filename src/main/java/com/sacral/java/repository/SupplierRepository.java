
package com.sacral.java.repository;

import com.sacral.java.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.username = ?1")
    Supplier findByUsername(String username);

    @Query("SELECT s FROM Supplier s WHERE s.username = ?1 AND s.password = ?2")
    Supplier findByUsernameAndPassword(String username, String password);

    // Other custom queries and methods can be added here

}
