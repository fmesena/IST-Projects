#ifndef __GRAPH_H__
#define __GRAPH_H__

#include <vector>
#include <iostream>
#include <map>

using namespace std;

class Graph{
	
	private:
		int N;
		int M;
		vector<vector<int> > adjList;
		vector<int> degree;
		vector<int> link; // disjoint sets
		vector<int> size; // disjoint sets
		map<int, double> distribution; //degree distribution
 
	public:
		Graph(int V){
			N=V;
			M=0;
			for(int i=0; i<V; i++) degree.push_back(0);
			adjList.resize(V, vector<int>(0));
		}
		void addEdge(int u, int v) { // for undirected graphs
			adjList[u].push_back(v);
			adjList[v].push_back(u);
			degree[u]++;
			degree[v]++;
			M++;
		}
		void removeNode(int v) {
			for(auto n: neighbours(v))
				for(unsigned int i=0; i<adjList[n].size(); i++) {
					if(adjList[n][i]==v) {
						adjList[n].erase(adjList[n].begin()+i);
						degree[n]--;
						M--;
					}
				}
			adjList[v].clear();
			for(int i=v; i<N-1; i++) {
				adjList[i] = adjList[i+1];
				degree[i] = degree[i+1];
			}
			N--;
			for(int i=0; i<N; i++)
				for(unsigned int j=0; j<adjList[i].size(); j++) {
					if(adjList[i][j]>v) adjList[i][j]--;
				}
		}
		int getDegree(int v){
			return degree[v];
		}
		int getHighestDegreeNode(){
			int index=0;
			int max=0;
			for(unsigned int i=0; i<N; i++) 
				if (degree[i]>max) {
					index=i;
					max = degree[index];
				}
			return index;
		}
		vector<int> neighbours(int v){
			return adjList[v];
		}
		map<int, double> getDegreeDistribution() {
			return distribution;
		}
		bool hasNeighbour(int a, int b) {
			for (auto neighb : adjList[b])
				if (neighb == a) return true;
			return false;
		}
		void printDegree(){
			for(int i=0; i<N; i++){
				cout << "!!!!!";
				cout<<i<<"=>";
				cout<<degree[i];
				cout<<"\n";
			}
		}
		void printGraph(){
			for(int i=0;i<N;i++){
				cout<<i<<"=>";
				for(auto it:adjList[i])
					cout<<it<<",";
				cout<<"\n";
			}
		}

		int getNumNodes() {
			return N;
		}

		void compute_degree_distribution();
		int find(int);
		void unite(int, int);
		bool same(int, int);
		int nth_moment(int);
		vector<double> clustering_vector();
		double average_clustering();
		int biggest_SCC();
		void kill_nodes_randomly(int);
		void kill_nodes_targeted(int);
		map<int,double> clustering_of_degree();
};

#endif