package com.Hospital.AgentPortal.Service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Hospital.AgentPortal.Entity.Bill;
import com.Hospital.AgentPortal.Entity.BillItem;
import com.Hospital.AgentPortal.Reository.BillRepository;

@Service
public class BillService {

    @Autowired
    private BillRepository billRepository;

    public Bill generateBill(Bill bill) {
        bill.setDate(new Date());
        bill.setTotalAmount(bill.getItems().stream().mapToDouble(BillItem::getAmount).sum());
        bill.setIsPaid(false);
        return billRepository.save(bill);
    }

    public List<Bill> getBillsByPatientId(Long patientId) {
        return billRepository.findByPatientId(patientId);
    }

    public Bill updateBillPaymentStatus(Long billId, Boolean isPaid) {
        Bill bill = billRepository.findById(billId).orElseThrow(() -> new RuntimeException("Bill not found"));
        bill.setIsPaid(isPaid);
        return billRepository.save(bill);
    }
}