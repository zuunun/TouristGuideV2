package org.example.touristguide.controller;

import org.example.touristguide.model.Tag;
import org.example.touristguide.model.TouristAttraction;
import org.example.touristguide.service.TouristService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
@RequestMapping("/attractions")
public class TouristController {
    private final TouristService touristService;

    public TouristController(TouristService touristService) {
        this.touristService = touristService;
    }

    @GetMapping("")
    public String getAttractions(Model model) {
        List<TouristAttraction> touristAttractions = touristService.getAllAttractions();
        model.addAttribute("attractions", touristAttractions);
        return "attractionList";
    }

    @GetMapping("/{name}")
    @ResponseBody // This returns a JSON response
    public TouristAttraction getAttractionByName(@PathVariable String name) {
        return touristService.getAttractionByName(name);
    }

    @GetMapping("/attractions/{name}/tags")
    public String getAttractionTags(@PathVariable String name, Model model) {
        TouristAttraction t = touristService.getAttractionByName(name);
        List<Tag> tags = touristService.getAttractionByName(name).getTags();
        model.addAttribute("attraction", t);
        model.addAttribute("tags", tags);
        return "tags";
    }


    @GetMapping("/add")
    public String addAttraction(Model model) {
        TouristAttraction t = new TouristAttraction();
        model.addAttribute("attraction", t);

        // Use a Set to avoid duplicates
        HashSet<String> uniqueTags = new HashSet<>(touristService.getTags());
        model.addAttribute("availableTags", uniqueTags);

        model.addAttribute("cities", touristService.getCities());
        return "addAttraction";
    }

    @PostMapping("/save")
    public String saveAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.saveAttraction(touristAttraction); // Save instead of get
        return "redirect:/attractions";
    }

    @GetMapping("/{name}/edit")
    public String editAttraction(@PathVariable String name, Model model) {
        TouristAttraction touristAttraction = touristService.getAttractionByName(name);
        model.addAttribute("attraction", touristAttraction);
        model.addAttribute("city", touristService.getCities());
        model.addAttribute("description", touristAttraction.getDescription());
        model.addAttribute("availableTags", touristService.getTags());
        return "editAttraction";
    }

    @PostMapping("/update")
    public String editAttraction(@ModelAttribute TouristAttraction touristAttraction) {
        touristService.updateAttraction(touristAttraction);
        return "redirect:/attractions";
    }

    @PostMapping("/delete/{name}")
    public String deleteAttraction(@ModelAttribute TouristAttraction touristAttraction, Model model) {
        touristService.deleteAttraction(touristAttraction.getName());
        model.addAttribute("attraction", touristAttraction);
        return "redirect:/attractions";
    }
}

