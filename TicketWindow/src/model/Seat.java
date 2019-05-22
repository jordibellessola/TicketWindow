package model;

public class Seat {
	private State state;
	private int row;
	private int col;
	
	public Seat(int row, int col) {
		this.state = State.AVAILABLE;
		this.row = row;
		this.col = col;
	}
	
	public void switchState() {
		System.err.println("aqui");
		this.state = (this.state == State.AVAILABLE) ? State.SOLD : State.AVAILABLE;
	}

	public boolean isSold() {
		return (this.state == State.SOLD);
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public String toString() {
		return "Seat "+ this.getCol() + " in row " + this.getRow() + " is " + (this.isSold() ? "sold" : "available");
	}
}
