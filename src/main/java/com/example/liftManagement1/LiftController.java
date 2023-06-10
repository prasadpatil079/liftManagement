package com.example.liftManagement1;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/lift")
public class LiftController {


    @Autowired
    LiftService liftService ;
    public LiftController(){
        System.out.println("in controller");
    }
    //System.out.print("asd");
    @PostMapping("/add")
    public Lift addLift(@RequestBody Lift lift)
    {
        Lift lift1=liftService.addLift(lift);
        return lift1;
    }

   @DeleteMapping("/Delete-ids")
   public String deletePassenger(@RequestParam("PassengerId")Integer passengerId){
       liftService.deletepass(passengerId);
       return "Success";
   }
   @GetMapping("/number-of-people-greater")
   public int  numberOfPeopleGreater()
   {
      int ans= liftService.NoOfPeople();
      return ans;
   }
    @GetMapping("/number-of-peopleWeight-in-lift")
    public int numberOfMaxPeopleByWeight(@RequestParam("LiftId") Integer lift,@RequestParam("weight") Integer weight){
        int ans= liftService.NoOfPeopleByWeight(lift,weight);
        return ans;
    }

}
