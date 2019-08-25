package shortestPathAlgo;
import java.util.*;
public class dijkstra {
	
	String start;
	String end;
	graph g;
	HashMap<String,Integer>weightVertices = new HashMap<>();
	HashMap<String,Integer>edges;
	
	ArrayList<String>visited = new ArrayList<>();
	ArrayList<String>needToVisit = new ArrayList<>();
	ArrayList<String>touched = new ArrayList<>();
	ArrayList<String>path = new ArrayList<>();
	
	public dijkstra(graph g,String start, String end)
	{
		this.g = g;
		this.start = start;
		this.end = end;
		this.edges = g.getAllEdgeValues();
		ArrayList<String>temp = g.getVertices();
		
		//every vertex on the hashmap is set to -1 at default
		for(int i=0;i<temp.size();i++)
			weightVertices.put(temp.get(i), -1);
	}
	
	public void findPath()
	{
		//Giving initals 
		String currentVertex = start;
		weightVertices.put(start, 0);
		touched.add(start);
		path.add(start);
		

		while(!(currentVertex.equals(end)))
		{
			
			if(!(visited.contains(currentVertex)))
				visited.add(currentVertex);
			//grabbing all connection points for currentVertex
			String CVvertices[] = g.getVertexConnection(currentVertex);
			//clearing needToVisit
			needToVisit.clear();
			//filtering out any visited vertices
			for(int i=0;i<CVvertices.length;i++) //THE FILTER
			{
				if(isVisited(CVvertices[i])==false)
					needToVisit.add(CVvertices[i]);
			}
			

			//updating all connected Vertices with weighted paths, and marking them visited
			for(int i=0;i<needToVisit.size();i++)
			{
				String connectionPointV1 = currentVertex+","+needToVisit.get(i);
				String connectionPointV2 = needToVisit.get(i)+","+currentVertex;
				int connection;
				try
				{
					connection = edges.get(connectionPointV2);
				}
				catch(NullPointerException npex)
				{
					connection = edges.get(connectionPointV1);
				}
				
				//testing if it has the default value, or it has found a new lower distance for that vertex
				int testValue = weightVertices.get(currentVertex)+connection;
				if(weightVertices.get(needToVisit.get(i))==-1||testValue<weightVertices.get(needToVisit.get(i)))
				{
					touched.add(needToVisit.get(i));
					weightVertices.put(needToVisit.get(i),testValue);
				}
				else if(testValue<weightVertices.get(needToVisit.get(i)))
					weightVertices.put(needToVisit.get(i),testValue);
			}
			
			String lowest="None";
			
			for(int i=0;i<touched.size();i++)
			{
				if(!(touched.get(i).equals(lowest)))
				{
					boolean isVisit = isVisited(touched.get(i));
					if( ((!(lowest.equals("None")) && weightVertices.get(touched.get(i))< weightVertices.get(lowest)) || (lowest.equals("None")) ) && isVisit==false)
						lowest = touched.get(i);
				}
		   }
			currentVertex=lowest;
	    }
		
		System.out.println(currentVertex + " : "+weightVertices.get(currentVertex));
		
	}
	
	private boolean isVisited(String x)
	{
		for(int j=0;j<visited.size();j++)
		{
			if(x.equals(visited.get(j)))
			{
				return true;
			}
		}
		
		return false;
	}

}
