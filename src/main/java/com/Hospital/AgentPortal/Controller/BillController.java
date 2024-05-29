package com.Hospital.AgentPortal.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Hospital.AgentPortal.Entity.Bill;
import com.Hospital.AgentPortal.Service.BillService;

@RestController
@RequestMapping("/api/bills")
public class BillController {

    @Autowired
    private BillService billService;

    @PostMapping
    public Bill generateBill(@RequestBody Bill bill) {
        return billService.generateBill(bill);
    }

    @GetMapping("/patient/{patientId}")
    public List<Bill> getBillsByPatientId(@PathVariable Long patientId) {
        return billService.getBillsByPatientId(patientId);
    }

    @PutMapping("/{billId}/payment")
    public ResponseEntity<Bill> updateBillPaymentStatus(@PathVariable Long billId, @RequestParam Boolean isPaid) {
        Bill updatedBill = billService.updateBillPaymentStatus(billId, isPaid);
        return ResponseEntity.ok(updatedBill);
    }
}
