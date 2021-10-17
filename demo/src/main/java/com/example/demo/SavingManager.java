package com.example.demo;

import java.util.List;

public interface SavingManager {

    public List<Saving> getAllSavingData();

    public Saving getSavingDataById(String savingId);

    public double calculateSaving(Saving input);

    public Saving saveSaving(Saving input);
}
