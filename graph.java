package shortestPathAlgo;
import java.util.*;

public class graph {
	
	HashMap<String,Integer>edgeValues;
	ArrayList<vertex>vertices;
	ArrayList<String> edgeNames;
	
	public graph(HashMap<String,Integer>edgeValues,ArrayList<vertex>vertices, ArrayList<String>edgeNames)
	{
		this.edgeValues=edgeValues;
		this.vertices=vertices;
		this.edgeNames=edgeNames;
	}
	
	public ArrayList<String> getVertices()
	{
		ArrayList<String>temp = new ArrayList<>();
		for(int i=0;i<vertices.size();i++)
			temp.add(vertices.get(i).getName());
		return temp;
	}
	
	//returns the names of connections to that given string
	public String[] getVertexConnection(String name)
	{
		for(int i=0;i<vertices.size();i++)
		{
			if(vertices.get(i).getName().equals(name))
				return vertices.get(i).getConnected();
		}
		
		return null;
	}
	
	//returns an edge
	public int getEdgeValue(String edge)
	{
		return edgeValues.get(edge);
	}
	
	public HashMap<String,Integer> getAllEdgeValues()
	{
		return edgeValues;
	}
	
	public ArrayList<String> getEdgeNames()
	{
		return edgeNames;
	}
	
	

}
