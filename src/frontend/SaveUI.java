package frontend;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.xml.sax.SAXException;

import controller.Controller;



public class SaveUI {
	  Document doc;
	
	  public Document getFile(String fileName) throws ParserConfigurationException, SAXException, IOException {
		    File fXmlFile = new File(fileName);
		    DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		    DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
		    Document doc = dBuilder.parse(fXmlFile);
		    return doc;
	}
	  
	  
	  
	  private void setNode(String name,double result) {
		  Node curr = doc.getElementsByTagName(name).item(0);
		
		  curr.setTextContent(Double.toString(result));
		  
	  }
		
		
		
		public void save(Controller myController) {
		
			try {
				
				
				
				String filepath="lib/SavedData.xml";
				
				doc=getFile(filepath);
				
				setNode("turtleX",myController.getXCor());
				setNode("turtleY",myController.getYCor());
				setNode("turtleTheta",myController.getTheta());
				setNode("turtleVis",myController.getTurtleVis());

		
				
				// write the content into xml file
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result = new StreamResult(new File(filepath));
				transformer.transform(source, result);

				

			   } catch (ParserConfigurationException pce) {
				pce.printStackTrace();
			   } catch (TransformerException tfe) {
				tfe.printStackTrace();
			   } catch (IOException ioe) {
				ioe.printStackTrace();
			   } catch (SAXException sae) {
				sae.printStackTrace();
			   }
			}
		
		
		public double getNode(String tagName) {
			String curr = doc.getElementsByTagName(tagName).item(0).getTextContent();
			return Double.parseDouble(curr);
			
		}
			
		public DisplayTurtle getBack(){
			
			  try {
				   
				    Document doc = getFile("SavedData.xml");
					doc.getDocumentElement().normalize();
					double turtleX = getNode("turtleX");
					double turtleY = getNode("turtleY");
					double turtleTheta = getNode("turtleTheta");
					double turtleVis = getNode("turtleVis");
			
					
				    } catch (Exception e) {
					e.printStackTrace();
				    }
//					return finalParams;
		     
			
		
		}
			
			
		

}
