package org.example.touristguide.controller;

import org.example.touristguide.model.TouristAttraction;
import org.example.touristguide.service.TouristService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;


@WebMvcTest(TouristController.class)
class TouristControllerTest {
    private TouristAttraction touristAttraction = new TouristAttraction();

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TouristService touristService;


    @Test
    void getAttractions() throws Exception {
        mockMvc.perform(get("/attractions"))
                .andExpect(status().isOk())
                .andExpect(view().name("attractionList"));
    }

//    @Test
//    void getAttractionByName() throws Exception {
//        mockMvc.perform(get("/attractions/LEGOLAND"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("attractionDetails"))
//                .andExpect((ResultMatcher) content().string(containsString("LEGOLAND")));
//    }
//
//    @Test
//    void getAttractionTags() throws Exception {
//        mockMvc.perform(get("/attractions/LEGOLAND/tags"))
//                .andExpect(status().isOk())
//                .andExpect(view().name("tags"));
//
//    }

    @Test
    void addAttraction() throws Exception {
        mockMvc.perform(get("/attractions/add"))
                .andExpect(status().isOk())
                .andExpect(view().name("addAttraction"));
    }


    @Test
    void saveAttraction() throws Exception {
        mockMvc.perform(post("/attractions/save").sessionAttr("touristAttraction", this.touristAttraction))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/attractions"));
    }

//    @Test
//    void editAttraction() throws Exception {
//        mockMvc.perform(get("/attractions/edit/1"))  // Her redigerer vi attraktionen med ID 1
//                .andExpect(status().isOk())
//                .andExpect(view().name("editAttraction"));
//    }


    @Test
    void deleteAttraction() throws Exception {
        mockMvc.perform(post("/attractions/delete/1"))
                .andExpect(status().is3xxRedirection())  // Forventer en redirect efter sletning
                .andExpect(view().name("redirect:/attractions"));
    }

}