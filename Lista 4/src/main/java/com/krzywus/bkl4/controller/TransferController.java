package com.krzywus.bkl4.controller;

import com.krzywus.bkl4.model.Transfer;
import com.krzywus.bkl4.services.TransferService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @_(@Autowired))
@RequestMapping("transfer")
public class TransferController {

    TransferService transferService;

    @GetMapping(value ={"/id"})
    public Transfer getTransferById(@RequestParam("id") int id){
        return this.transferService.findTransferById(id).get();
    }

    @GetMapping(value={"/all"}, produces = "application/json")
    public List<Transfer> transferList(@RequestParam("username") String username){
        return this.transferService.findAll(username);
    }

    @PostMapping(produces = "application/json")
    public int receiveNewTransfer(@RequestBody Transfer transfer,
                                  @RequestParam String username){
        transfer.setUsername(username);
        return this.transferService
                .saveTransfer(transfer)
                .getTransferId();
    }
}
