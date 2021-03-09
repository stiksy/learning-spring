package com.fernando.learningspring.web;

import com.fernando.learningspring.data.business.domain.RoomReservation;
import com.fernando.learningspring.data.business.service.GuestService;
import com.fernando.learningspring.data.business.service.ReservationService;
import com.fernando.learningspring.data.entity.Guest;
import com.fernando.learningspring.data.web.DateUtils;
import com.fernando.learningspring.data.web.GuestWebController;
import com.fernando.learningspring.data.web.RoomReservationWebController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.core.StringContains.containsString;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(GuestWebController.class)
public class GuestWebControllerTest {

    @MockBean
    private GuestService guestService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getReservations() throws Exception {
        List<Guest> guests = new ArrayList<>();
        Guest guest = new Guest();
        guest.setLastName("Unit");
        guest.setFirstName("JUnit");
        guest.setEmailAddress("test@junit.org");
        guest.setGuestId(1);
        guest.setPhoneNumber("555-1234");
        guests.add(guest);

        given(guestService.getGuests()).willReturn(guests);

        this.mockMvc.perform(get("/guests"))
                .andExpect(status().isOk())
                .andExpect(content().string(containsString("Unit, JUnit")));
    }
}
