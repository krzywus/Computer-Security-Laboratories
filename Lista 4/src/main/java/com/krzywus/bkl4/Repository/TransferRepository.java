package com.krzywus.bkl4.Repository;

import com.krzywus.bkl4.model.Transfer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TransferRepository extends JpaRepository<Transfer, Long> {
    Optional<Transfer> findByTransferId(int id);
    Page<Transfer> findAll(Pageable pageable);
    List<Transfer> findAllByUsername(String username);
}
