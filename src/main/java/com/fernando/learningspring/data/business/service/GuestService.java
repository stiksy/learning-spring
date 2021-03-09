package com.fernando.learningspring.data.business.service;

import com.fernando.learningspring.data.entity.Guest;
import com.fernando.learningspring.data.repository.GuestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class GuestService {
    private final GuestRepository guestRepository;

    @Autowired
    public GuestService(GuestRepository guestRepository) {
        this.guestRepository = guestRepository;
    }

    public List<Guest> getGuests() {
        Iterable<Guest> guestsIterable = guestRepository.findAll();
        List<Guest> guests = new ArrayList<>();
        guestsIterable.forEach(guests::add);
        guests.sort(new Comparator<Guest>() {
            @Override
            public int compare(Guest g1, Guest g2) {
                if (g1.getLastName().equals(g2.getLastName())) {
                    return g1.getFirstName().compareTo(g2.getFirstName());
                }
                return g1.getLastName().compareTo(g2.getLastName());
            }
        });
        return guests;
    }
}
