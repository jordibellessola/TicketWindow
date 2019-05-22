package controller;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import model.Seat;
import model.SeatGrid;


@ManagedBean(name="ticketWindowBackingBean")
@RequestScoped
public class TicketWindowBackingBean {

		@EJB private SeatGrid seatGrid;
		
		
		public TicketWindowBackingBean() {
			System.out.println("TicketWindow Backing Bean started!!!");
		}
		
		public SeatGrid getSeatGrid() {
			return this.seatGrid;
		}
		
		public List<List<Seat>> getSeats(){
			return this.getSeatGrid().getSeats();
		}
		
		public int getTotalSold() {
			int  count = 0;
			for(List<Seat> lSeat : this.getSeats()) {
				for(Seat seat : lSeat) {
					if(seat.isSold()) {
						count+=1;
					}
				}
			}
			return count;
		}
		
		public int getTotalAvailable() {
			int  count = 0;
			for(List<Seat> lSeat : this.getSeats()) {
				for(Seat seat : lSeat) {
					if(!seat.isSold()) {
						count+=1;
					}
				}
			}
			return count;
		}
		
}
