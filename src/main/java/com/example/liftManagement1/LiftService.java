package com.example.liftManagement1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class LiftService {

    @Autowired
    LiftRepository liftRepository;

    public LiftService(){
        System.out.println("in service");
    }
    public Lift addLift(Lift lift) {

        return liftRepository.addlift(lift);

    }

    public void addpass(Passenger passenger) {
        liftRepository.addpass(passenger);
    }

    public void  deletepass(Integer passengerId) {

        liftRepository.deletepass(passengerId);
    }

    public int NoOfPeople() {
        int count=0;
        List<Passenger>list= liftRepository.findpeople();
        for(Passenger pass:list){
            if(pass.getWeight()>50){
                count++;
            }
        }
        return count;
    }

    public int NoOfPeopleByWeight(Integer liftId, Integer weight) {

        Lift lift=liftRepository.getlift(liftId);
        int count=0;
        int maxWeight=lift.getCapacityInWeight();
        int currW=0;
        List<Passenger>pList=lift.getPassangerList();
        //Collections.sort(pList);
        for(Passenger pass:pList){

//            if(pass.getWeight()==weight)//
            if(pass.getWeight()<weight){//to check if weight is 10 and passenger weight is 50;
                {
                    currW += pass.getWeight();
                    count++;
                }
}
            if(currW>=maxWeight){
                break;
            }

        }

        return count;
    }
}
