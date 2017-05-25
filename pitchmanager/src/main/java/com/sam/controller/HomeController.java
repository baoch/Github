package com.sam.controller;

import com.google.gson.Gson;
import com.sam.entity.Bill;
import com.sam.entity.Customer;
import com.sam.entity.Pitch;
import com.sam.entity.SlotReserve;
import com.sam.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by vieth on 5/16/2017.
 */
@RestController
public class HomeController {

    @Autowired
    private PitchRepository pitchRepository;

    @Autowired
    private TimeFrame_PitchTypeRepository timeFrame_pitchTypeRepository;

    @Autowired
    private PitchTypeRepository pitchTypeRepository;

    @Autowired
    private SlotReserveRepository slotReserveRepository;

    @Autowired
    private SlotRepository slotRepository;

    @Autowired
    private BillRepository billRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @RequestMapping("/")
    public ModelAndView init(){
        ModelAndView mav = new ModelAndView("home");
        return mav;
    }

    @PostMapping("/save-pitch")
    public void savePitch(@RequestBody Pitch pitch){
        pitchRepository.add(pitch);
    }

                                  @RequestMapping("/get-reference-price")
    public String getReferencePrice(){
        return new Gson().toJson(timeFrame_pitchTypeRepository.getReferencePrice());
    }

    @RequestMapping("/pitch")
    public ModelAndView redirectPitch(){
        ModelAndView mav = new ModelAndView("pitch");
        mav.addObject("listPitchType", pitchTypeRepository.getListPitchType());
        return mav;
    }

    @PostMapping("/get-list-pitch")
    public String getListPitch(){
        return new Gson().toJson(pitchRepository.findAll());
    }

    @RequestMapping("/pitch-reserve")
    public ModelAndView redirectPitchReserve(){
        ModelAndView mav = new ModelAndView("pitch-reservation");
        mav.addObject("listSlot", slotRepository.findAll());
        mav.addObject("listPitch", pitchRepository.findAll());
        return mav;
    }

    @PostMapping("/save-reservation")
    public String saveReservation(@RequestParam("date") String reserveDate,
                                  @RequestParam("fromSlot") int fromSlot,
                                  @RequestParam("toSlot") int toSlot,
                                  @RequestParam("pitchId") int pitchId,
                                  @RequestParam("customerName") String fullname,
                                  @RequestParam("phone") String phone){

        Date date = Date.valueOf(reserveDate);
        if(fromSlot > toSlot){
            return "Please select the slot Again";
        }
        if(slotReserveRepository.isAvailableAt(pitchId, fromSlot, toSlot, date)){
            return "This time is already existed";
        }
        Customer customer = new Customer();
        customer.setPhone(phone);
        customer.setFullname(fullname);
        int customerId = customerRepository.add(customer);
        customer.setCustomerId(customerId);
        Bill bill = new Bill();
        bill.setCustomerId(customer.getCustomerId());
        bill.setFullyPaid(false);
        int billId = billRepository.add(bill);
        List<SlotReserve> listSlotReserve = new ArrayList<>();
        SlotReserve slot;
        for(int i = fromSlot; i <= toSlot; i++){
            slot = new SlotReserve();
            slot.setBillId(billId);
            slot.setDate(date);
            slot.setPitchId(pitchId);
            slot.setSlotId(i);
            listSlotReserve.add(slot);
        }
        slotReserveRepository.addMutipleSlotReserve(listSlotReserve);
        return "Saved";
    }

}
