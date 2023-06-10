package com.example.liftManagement1;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class LiftRepository {

    Map<Integer,Lift>liftData=new HashMap<>();
    Map<Integer,Passenger>passengerData=new HashMap<>();
    public Lift addlift(Lift lift) {

        liftData.put(lift.getLiftNo(), lift);

        return lift;
    }

    public void addpass(Passenger passenger) {

        passengerData.put(passenger.getPassengerId(),passenger);
    }

    public void deletepass(Integer passengerId) {

       // ArrayList<Passenger>pass=sadweda
        for(int key : passengerData.keySet())
        {
            if(key<5)
            passengerData.remove(key);
        }
        //return list;
    }

    public List<Passenger> findpeople() {
        //int count=0;
        List<Passenger> list = new ArrayList<>();
        for(int key : passengerData.keySet())
        {
            list.add(passengerData.get(key));
        }

        return list;
    }

    public Lift getlift(Integer  liftId) {
        Lift lift1= null;
        for(int key : liftData.keySet())
        {
            Lift currLift = liftData.get(key);
            if(currLift.getLiftNo() ==liftId)
            {
                //count = currGym.getMemberList().size();
                lift1 = currLift;
                break;
            }
        }
        return lift1;
    }
}
