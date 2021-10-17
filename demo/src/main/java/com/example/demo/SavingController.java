package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
public class SavingController {

    @Autowired
    private SavingManagerImpl savingManager;

    @PostMapping("/saving-calculation")
    private ResponseEntity<Object> savingCalculation(@RequestBody Saving input){
        BaseResponse response = new BaseResponse();
        double calculation = savingManager.calculateSaving(input);
        if(calculation > 0){
            response.setMessage("SUCCESS");
            response.setSavingCalculation(String.valueOf(calculation));
            return new ResponseEntity<Object>(response, HttpStatus.OK );
        } else {
            response.setMessage("INVALID INPUT");
            return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST );
        }

    }

    @PostMapping("/create-saving")
    private ResponseEntity<Object>  createSaving(@RequestBody Saving input){
        BaseResponse response = new BaseResponse();
        Saving savingData = new Saving();
        savingData = savingManager.saveSaving(input);
        if(savingData != null){
            response.setMessage("SUCCESS");
            return new ResponseEntity<Object>(response, HttpStatus.CREATED );
        } else {
            response.setMessage("INVALID INPUT");
            return new ResponseEntity<Object>(response, HttpStatus.BAD_REQUEST );
        }

    }

    @GetMapping("/get-all-saving")
    private ResponseEntity<Object> getAllSavingData(){
        BaseResponse response = new BaseResponse();
        response.setListSaving(savingManager.getAllSavingData());
        if(response.getListSaving() != null){
            response.setMessage("SUCCESS");
            return new ResponseEntity<Object>(response, HttpStatus.OK );
        } else {
            response.setMessage("DATA NOT FOUND");
            return new ResponseEntity<Object>(response, HttpStatus.NO_CONTENT );
        }
    }

    @GetMapping("/get-saving-by-id/{savingId}")
    private ResponseEntity<Object>  getSavingDataById(@PathVariable String savingId){
        BaseResponse response = new BaseResponse();
        response.setSaving(savingManager.getSavingDataById(savingId));
        if(response.getSaving() != null){
            response.setMessage("SUCCESS");
            return new ResponseEntity<Object>(response, HttpStatus.OK );
        } else {
            response.setMessage("DATA NOT FOUND");
            return new ResponseEntity<Object>(response, HttpStatus.NO_CONTENT );
        }
    }

}
