package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SavingManagerImpl implements SavingManager {
    @Autowired
    private SavingRepository savingRepository;

    public double calculateSaving(Saving input){
        double grandTotalDeposit = input.getFirstDeposit() + input.getMonthlyDeposit()*input.getSavingTenor();
        double hasilKalkulasi = ((input.getSavingTenor() * 0.06)/100) * grandTotalDeposit + grandTotalDeposit;
        return hasilKalkulasi;
    }

    public Saving saveSaving(Saving input){
        return  savingRepository.save(input);
    }

    public List<Saving> getAllSavingData(){
        return (List<Saving>) savingRepository.findAll();
    }

    public Saving getSavingDataById(String savingId){
        return savingRepository.findBySavingId(savingId);
    }

}
