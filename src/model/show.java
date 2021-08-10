package model;

public class show {
	private int showid;
	private String show_title;
	private String gengre;
	private double length;
	private int movie;
	private int series;
	private int proco_id;
	private int year;
	
	public show() {
		
	}
	
	public show(int showid,String show_title,String gengre,double length,int movie,int series,int proco_id,int year) {
		this.showid = showid;
		this.show_title = show_title;
		this.gengre = gengre;
		this.length = length;
		this.movie = movie;
		this.series = series;
		this.proco_id = proco_id;
		this.year = year;
	}
	
	public int getShowid() {
		return showid;
	}
	public void setShowid(int showid) {
		this.showid = showid;
	}
	public int getMovie() {
		return movie;
	}
	public void setMovie(int movie) {
		this.movie = movie;
	}
	public int getSeries() {
		return series;
	}
	public void setSeries(int series) {
		this.series = series;
	}
	public int getProco_id() {
		return proco_id;
	}
	public void setProco_id(int proco_id) {
		this.proco_id = proco_id;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getShow_title() {
		return show_title;
	}
	public void setShow_title(String show_title) {
		this.show_title = show_title;
	}
	
	public String getGengre() {
		return gengre;
	}
	public void setGhow_title(String gengre) {
		this.gengre = gengre;
	}
	
	public double getLength() {
		return length;
	}
	public void setLength(double length) {
		this.length = length;
	}
}
