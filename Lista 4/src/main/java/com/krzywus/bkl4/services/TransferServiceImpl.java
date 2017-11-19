package com.krzywus.bkl4.services;

import com.krzywus.bkl4.Repository.TransferRepository;
import com.krzywus.bkl4.model.Transfer;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor(onConstructor = @_(@Autowired))
@NoArgsConstructor
public class TransferServiceImpl implements TransferService {
    private TransferRepository transferRepository;

    @Override
    public Optional<Transfer> findTransferById(int id) {
        return transferRepository.findByTransferId(id);
    }

    @Override
    public Transfer saveTransfer(Transfer transfer) {
        return transferRepository.save(transfer);
    }

    @Override
    public List<Transfer> findAll(String username) {
        return transferRepository.findAllByUsername(username);
    }
}
