package io.github.greenwolf24.KMLmanage.Maker;

import io.github.greenwolf24.KMLmanage.Util.Position;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class PathMaker
{
	private static String filePath = "";
	
	public PathMaker(String filePathOut)
	{
		filePath = filePathOut;
		if(!filePath.endsWith("/"))
		{
			filePath = filePath + "/";
		}
	}
	
	/*
	public static void main(String[] args)
	{
		ArrayList<Position> positions = new ArrayList<Position>();
		positions.add(new Position(71, 50, 300));
		positions.add(new Position(75, 52, 3000));
		positions.add(new Position(77, 40, 6000));
		
		makePathLine(positions, "Test");
	}
	//*/
	
	// This is what I call a very dirty method.
	// This is not at all the proper way to do this, but it works really effin well.
	private static String makePathLine(ArrayList<Position> positions)
	{
		String path = "";
		for(int i = 0; i < positions.size(); i++)
		{
			path += positions.get(i).getLon() + "," + positions.get(i).getLat() + "," + positions.get(i).getAlt() + " ";
		}
		return path;
	}
	
	public static void makePathLine(ArrayList<Position> positions, String name)
	{
		String ret = hardCodeExampleFile();
		ret.replace("FILENAME",name);
		ret.replace("POSITIONS", makePathLine(positions));
		/*
		// get the example file
			No longer needed, Hard coded should work for now
		try
		{
			ArrayList<String> lines = new ArrayList<String>();
			File file = new File("data/Example.kml");
			BufferedReader br = new BufferedReader(new FileReader(file));
			String line;
			while((line = br.readLine()) != null)
			{
				lines.add(line);
			}
			br.close();
			for(int i = 0; i < lines.size(); i++)
			{
				if(lines.get(i).contains("FILENAME"))
				{
					lines.set(i, lines.get(i).replace("FILENAME", name));
				}
				if(lines.get(i).contains("POSITIONS"))
				{
					lines.set(i, lines.get(i).replace("POSITIONS", makePathLine(positions)));
				}
				ret += lines.get(i) + "\n";
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//*/
		
		try
		{
			File file = new File(filePath + name + ".kml");
			//file.createNewFile();
			FileWriter fw = new FileWriter(file);
			fw.write(ret);
			fw.close();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		//return ret;
	}
	
	// This might be useful for any kind of use case where
	// the example file is not carried with the running class
	private static String hardCodeExampleFile()
	{
		String ret =
				"<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
						"<kml xmlns=\"http://www.opengis.net/kml/2.2\" xmlns:gx=\"http://www.google.com/kml/ext/2.2\" xmlns:kml=\"http://www.opengis.net/kml/2.2\" xmlns:atom=\"http://www.w3.org/2005/Atom\">\n" +
						"<Document>\n" +
						"\t<name>FILENAME</name>\n" +
						"\t<Style id=\"inline\">\n" +
						"\t\t<LineStyle>\n" +
						"\t\t\t<color>ff0000ff</color>\n" +
						"\t\t\t<width>2</width>\n" +
						"\t\t</LineStyle>\n" +
						"\t\t<PolyStyle>\n" +
						"\t\t\t<fill>0</fill>\n" +
						"\t\t</PolyStyle>\n" +
						"\t</Style>\n" +
						"\t<Style id=\"inline0\">\n" +
						"\t\t<LineStyle>\n" +
						"\t\t\t<color>ff0000ff</color>\n" +
						"\t\t\t<width>2</width>\n" +
						"\t\t</LineStyle>\n" +
						"\t\t<PolyStyle>\n" +
						"\t\t\t<fill>0</fill>\n" +
						"\t\t</PolyStyle>\n" +
						"\t</Style>\n" +
						"\t<StyleMap id=\"inline1\">\n" +
						"\t\t<Pair>\n" +
						"\t\t\t<key>normal</key>\n" +
						"\t\t\t<styleUrl>#inline</styleUrl>\n" +
						"\t\t</Pair>\n" +
						"\t\t<Pair>\n" +
						"\t\t\t<key>highlight</key>\n" +
						"\t\t\t<styleUrl>#inline0</styleUrl>\n" +
						"\t\t</Pair>\n" +
						"\t</StyleMap>\n" +
						"\t<Placemark>\n" +
						"\t\t<name>Example</name>\n" +
						"\t\t<styleUrl>#inline1</styleUrl>\n" +
						"\t\t<LineString>\n" +
						"\t\t\t<tessellate>1</tessellate>\n" +
						"\t\t\t<altitudeMode>absolute</altitudeMode>\n" +
						"\t\t\t<coordinates>\n" +
						"\t\t\t\tPOSITIONS\n" +
						"\t\t\t</coordinates>\n" +
						"\t\t</LineString>\n" +
						"\t</Placemark>\n" +
						"</Document>\n" +
						"</kml>\n";
		return ret;
	}
}
