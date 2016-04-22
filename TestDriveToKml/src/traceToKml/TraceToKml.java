package traceToKml;

import com.google.earth.kml._2.*;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.List;

/**
 * Created by xsoroka on 4/20/2016.
 Write a script/program (using python or Java) to transform the attached test_drive.trace to a kml plot. (https://developers.google.com/kml/documentation/kml_tut)
 The kml plot should contain the route of the test drive as recorded in the test_drive_trace file.
 Between two points, the speed should be visualize in a color scale.
 Add an instruction guide to execute the program.
 The application should be executed in a Linux Environment with Java Version 1.7 or Python 2.7.3.

 args[0] - pass trace file with full or relative to Java project path
 args[1] - pass expected kml file name with full or relative to Java project path
 
 Speed measures  in m/s (meter per second) and there is a scale of
 speed < 16.66 - LOW speed (lower 60 km/h)
 16.66 < speed < 25 - NORMAL speed (lower 90 km/h)
 speed > 25 - HIGH speed (higher 90 km/h)
   
 */

public class TraceToKml {

	public static void main(String[] args) {
		String traceFile = null;
		String kmlFile = null;

		try {
			traceFile = args[0];
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println ("Default trace file is taken from src folder - test_drive.trace");
			traceFile = "test_drive.trace";    	 
		}

		try {
			kmlFile = args[1];    	 
		}
		catch (ArrayIndexOutOfBoundsException e)
		{
			System.out.println ("Default place and name for kml file is defined - same as jar file place");
			kmlFile = "test_drive.kml";
		}

		List<Trace> listOfPointsVisited = ReadTraceFileHelper.readFileWithPointsToList(traceFile);
		if (listOfPointsVisited.size() == 0)
		{
			System.out.println("Kml file won't be generated for empty traces");
			return;
		}
		generateKmlObjectForPoints(listOfPointsVisited, kmlFile);
	}

	static  void generateKmlObjectForPoints (List<Trace> listOfPointsVisited, String kmlFile) {
		ObjectFactory factory = new ObjectFactory();
		KmlType kml = new KmlType();
		JAXBElement<KmlType> body = factory.createKml(kml);

		DocumentType doc = new DocumentType();
		JAXBElement<DocumentType> docEl = factory.createDocument(doc);
		doc.setName("Path from trace file");
		doc.setDescription("The kml plot contains the route of the test drive as recorded in the test_drive_trace file.\n" +
				"Between two points, the speed visualized in a color scale.");
		docEl.setValue(doc);
		boolean addPoint = false;

		for (int i = 1; i < listOfPointsVisited.size(); i++) {
			String color = CalculationsHelper.defineSpeedBetweenPoints(listOfPointsVisited.get(i-1), listOfPointsVisited.get(i));
			if (i == 1)
			{
				color = "Start at " + listOfPointsVisited.get(i-1).getTimestamp() + "\n" + color;
				addPoint = true;
			}
			if (i == listOfPointsVisited.size() - 1) {
				color = "End at " + listOfPointsVisited.get(i).getTimestamp() + "\n" + color;
				addPoint = true;
			}

			PlacemarkType placeMark = PlaceMark.makeFromTrace(listOfPointsVisited.get(i-1), listOfPointsVisited.get(i), color, addPoint);
			JAXBElement<PlacemarkType> placeMarkEl = factory.createPlacemark(placeMark);
			placeMarkEl.setValue(placeMark);
			doc.getFeature().add(placeMarkEl);
			addPoint = false;
		}

		kml.setFeature(docEl);

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(KmlType.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			marshaller.setProperty("jaxb.formatted.output",Boolean.TRUE);
			//            marshaller.marshal (body,  new FileOutputStream("test_drive.kml"));
			marshaller.marshal (body,  new FileOutputStream(kmlFile));
		} catch (JAXBException e) {
			System.out.println("Kml file can't be generated");
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			System.out.println("Kml file is not found");
			e.printStackTrace();
		}
	}
}
