package io.github.greenwolf24.KMLmanage.Util;

public class Position
{
	public double lat;
	public double lon;
	public int alt;
	
	public Position(double lat, double lon, int alt)
	{
		this.lat = lat;
		this.lon = lon;
		this.alt = alt;
	}
	
	public double getLat()
	{
		return lat;
	}
	
	public double getLon()
	{
		return lon;
	}
	
	public int getAlt()
	{
		return alt;
	}
	
	public String toString()
	{
		return "(" + lat + ", " + lon + ", " + alt + ")";
	}
}
