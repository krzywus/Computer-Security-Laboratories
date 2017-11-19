package com.krzywus.bkl4.services;

import com.krzywus.bkl4.model.Transfer;

import java.util.List;
import java.util.Optional;

public interface TransferService {
    Optional<Transfer> findTransferById(int id);
    Transfer saveTransfer(Transfer transfer);
    List<Transfer> findAll(String username);
}
