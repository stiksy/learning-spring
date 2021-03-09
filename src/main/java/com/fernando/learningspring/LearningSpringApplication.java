package com.fernando.learningspring;

import com.fernando.learningspring.data.entity.Guest;
import com.fernando.learningspring.data.entity.Reservation;
import com.fernando.learningspring.data.entity.Room;
import com.fernando.learningspring.data.repository.GuestRepository;
import com.fernando.learningspring.data.repository.ReservationRepository;
import com.fernando.learningspring.data.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.spi.ResolveResult;

@SpringBootApplication
public class LearningSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearningSpringApplication.class, args);
	}

}
