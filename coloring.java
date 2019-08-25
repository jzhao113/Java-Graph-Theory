package shortestPathAlgo;
import java.util.*;

public class coloring 
{
	
	ArrayList<String> vertices;
	HashMap<String,String> vertexColors = new HashMap<>();
	graph g;
	
	public coloring(graph g)
	{
		this.g = g;
		vertices = g.getVertices();
	}
	
	public HashMap<String,String> colorIt()
	{
		int colorType = 0;
		String color = "color";
		ArrayList<String> colors = new ArrayList<>();
		
		for(int i=0;i<vertices.size();i++)
		{
			boolean flag=false;
			//testing to see if any of the previous colors work
			for(int j=0;j<colors.size();j++)
			{
				if(test(vertices.get(i),colors.get(j)))
				{
					vertexColors.put(vertices.get(i), colors.get(j));
					flag=true;
					break;
				}
			}
			
			if(flag==false)
			{
				String temp = color+colorType;
				vertexColors.put(vertices.get(i),temp);
				colors.add(temp);
				colorType++;
			}
		}
		
		return vertexColors;
	}
	
	private boolean test(String vertex, String color)
	{
		String [] connectedTo = g.getVertexConnection(vertex);
		for(int i=0;i<connectedTo.length;i++)
		{
			String vertexColor=vertexColors.get(connectedTo[i]);
			if(vertexColor==null)
				vertexColor="None";
			if(vertexColor.equals(color))
				return false;
		}
		
		return true;
		
	}
}
