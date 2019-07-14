package pl.biuropodrozy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import pl.biuropodrozy.entity.trip.Trip;
import pl.biuropodrozy.services.TripService;

import java.util.HashSet;
import java.util.Set;

//rozporzadza przekierowaniami
@Controller
public class TripController {

    @GetMapping()
    @ResponseBody //niech sie cos wewnatrz wywietli
    public String hello() {
        return "mainpage";
    }

    Set<Trip> trip = new HashSet<>();
    private TripService tripService;

    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }

    @GetMapping("/trips")
    public ModelAndView getMain() {
        ModelAndView m = new ModelAndView();
        m.setViewName("index");
        m.addObject("trips", tripService.findAll());
        return m;
    }

}