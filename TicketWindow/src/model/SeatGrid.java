package model;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Singleton;
import javax.ejb.Startup;

@Singleton
@Startup
public class SeatGrid {
	private List<List<Seat>> seats;
    
	private int rows = 3;
	private int cols = 4;
	
	public SeatGrid() {
		System.out.println("SeatGrid started");
		this.seats = new ArrayList<List<Seat>>(rows);

		for (int i=0; i< rows; i++) {
			List<Seat> row = new ArrayList<Seat>(cols);

			for (int j = 0; j < cols; j++) {
				row.add(new Seat(i,j));
			}

			this.seats.add(row);
		}		
	}

	public int getCols() {
		return cols;
	}

	public List<List<Seat>> getSeats() {
		return seats;
	}
	
	public Seat getSeatAt(int row, int col) {
		return this.seats.get(row).get(col);
	}
}
