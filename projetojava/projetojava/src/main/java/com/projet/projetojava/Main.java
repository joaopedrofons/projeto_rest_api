package com.projet.projetojava;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.projet.projetojava.entity.Airline;
import com.projet.projetojava.entity.Airplane;
import com.projet.projetojava.entity.Flight;
import com.projet.projetojava.entity.Passenger;
import com.projet.projetojava.repository.AirlineRepository;
import com.projet.projetojava.repository.AirplaneRepository;
import com.projet.projetojava.repository.FlightRepository;
import com.projet.projetojava.repository.PassengerRepository;

import java.time.LocalDate;

@SpringBootApplication
public class Main implements CommandLineRunner {

    @Autowired
    private AirlineRepository airlineRepository;

    @Autowired
    private AirplaneRepository airplaneRepository;

    @Autowired
    private FlightRepository flightRepository;

    @Autowired
    private PassengerRepository passengerRepository;

	public static void main(String[] args) {
		SpringApplication.run(Main.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        Airline redLine = 	new Airline("Red");
        airlineRepository.save(redLine);

      
    }

   private void addAirplanesToAirline(Airline airline, String model, int maxCapacity, int quantity) {
       for (int i = 0; i < quantity; i++) {
           Airplane airplane = new Airplane(model, maxCapacity, airline);
           airplaneRepository.save(airplane);
       }
   }

   private void addFlights(Airline airline, String airplaneModel, String origin, String destination, String departureTime, String arrivalTime) {
       Flight flight = new Flight(airline, airplaneModel, origin, destination, departureTime, arrivalTime);
       flightRepository.save(flight);
   }

   private void addPassengers(String name, String cpf, String passportNumber, String flightTime, LocalDate birthDate) {
       Passenger passenger = new Passenger(name, cpf, passportNumber, flightTime, birthDate);
       passengerRepository.save(passenger);
   }
}
