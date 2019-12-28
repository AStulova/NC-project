package bsys.controller;

import bsys.model.Bill;
import bsys.service.bill.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
public class BillController {
    private BillService billService;

    @Autowired
    public void setClientService(BillService billService) {
        this.billService = billService;
    }

    @GetMapping(value = "/bill")
    public ModelAndView allBills() {
        List<Bill> bill = billService.allBills();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BillInfo");
        modelAndView.addObject("billList", bill);
        return modelAndView;
    }

    @GetMapping(value = "/edit-bill/{id}")
    public ModelAndView editBillPage(@PathVariable int id) {
        Bill bill = billService.getById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BillEdit");
        modelAndView.addObject("bill", bill);
        return modelAndView;
    }

    @PostMapping(value = "/edit-bill")
    public ModelAndView editBill(@ModelAttribute("bill") Bill bill) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        billService.editBill(bill);
        return modelAndView;
    }

    @GetMapping(value = "/add-bill")
    public ModelAndView addBillPage() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("BillEdit");
        return modelAndView;
    }

    @PostMapping(value = "/add-bill")
    public ModelAndView addBill(@ModelAttribute("bill") Bill bill) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        billService.addBill(bill);
        return modelAndView;
    }

    @GetMapping(value = "/delete-bill/{id}")
    public ModelAndView deleteBill(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("redirect:/bill");
        Bill bill = billService.getById(id);
        billService.deleteBill(bill);
        return modelAndView;
    }
}