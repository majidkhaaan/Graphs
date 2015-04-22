package org.graph.majid;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
	private final int MAX_VERTS = 20;
	private Vertex vertexList[];
	private int adjMat[][];
	private int nVerts; // number of vertices

	public Graph() {
		vertexList = new Vertex[MAX_VERTS];
		adjMat = new int[MAX_VERTS][MAX_VERTS];
		nVerts = 0;
		for (int j = 0; j < MAX_VERTS; j++)
			for (int k = 0; k < MAX_VERTS; k++)
				adjMat[j][k] = 0;
	}

	public void addVertex(char lab) // argument is label
	{
		vertexList[nVerts++] = new Vertex(lab);
	}

	public void addEdge(int start, int end) {
		adjMat[start][end] = 1;
		adjMat[end][start] = 1;
	}

	public void displayVertex(int v) {
		System.out.print(vertexList[v].label);
	}
	
	public void DFS ( int startVertex ) {
		for(int i=0;i< nVerts ; i++)
			vertexList[i].wasVisited = false;
		dfs(startVertex);
		for(int i=0;i< nVerts ; i++)
			vertexList[i].wasVisited = false;	
	}
	private void dfs(int v) {
		System.out.print(" "+ vertexList[v].label);
		vertexList[v].wasVisited=true;
		for(int i=0;i<nVerts;i++)
			if(adjMat[v][i]!=0)
				if(!vertexList[i].wasVisited)
					dfs(i);
	}
	public void BFS(int startVertex) {
		Queue<Integer> queue = new LinkedList<Integer>();
		for(int i=0;i< nVerts ; i++)
			vertexList[i].wasVisited = false;
		queue.add(startVertex);
		vertexList[startVertex].wasVisited=true;
		
		while(!queue.isEmpty()) {
			int w=queue.remove();
			System.out.print(" "+ vertexList[w].label);
			for(int i=0;i< nVerts ; i++)
				if(adjMat[w][i]!=0) 
					if(!vertexList[i].wasVisited) {
						queue.add(i);
						vertexList[i].wasVisited=true;
					}
		}
		
		
	}

}
