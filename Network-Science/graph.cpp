#include "graph.h"
#include <set>
#include <map>
#include <cmath>
#include <vector>
#include <algorithm>
#include <random>
#include "time.h"

//---------------------------------------------------------------------------

void Graph::compute_degree_distribution() {
	// prob(k) = #Nk / #N
	multiset<int> degrees;
	for (int i=0; i<N; i++)
		degrees.insert(getDegree(i));  // example: { 4, 4, 5, 1 }  --->  { (4, 0.5) (5, 0.25) (1, 0.25) }  
	for (int i=0; i<N; i++) {
		int count = degrees.count(i);
		if (count!=0) distribution.insert(std::pair<int,double>(i, 1.0*count/N));
	}
}

map<int,double> Graph::clustering_of_degree() { // n^2
	map<int,double> clust_of_degree;
	vector<double> clust_v = clustering_vector();

	for(int k=0; k<N; k++) {
		int count = 0;
		for(int n=0; n<N; n++) 
			if(getDegree(n)==k) {
				if(clust_of_degree[k]!=NULL)
					clust_of_degree[k] += clust_v[n];
				else
					clust_of_degree[k] = clust_v[n];
				count++;
			}
		if(count) 
			clust_of_degree[k] = clust_of_degree[k]/count;
	}

	return clust_of_degree;
}

vector<double> Graph::clustering_vector() { //n^4
	vector<double> clust_v(N);
	for(int k=0; k<N; k++){
		vector<int> sons = neighbours(k);
		int ci=0;
		int num_neighbours = getDegree(k);
		int max_density = (num_neighbours*(num_neighbours-1))/2;
		for (int i=0; i<num_neighbours; i++)
			for (int j=i+1; j<num_neighbours; j++)
				if (hasNeighbour(sons[i], sons[j]))
					ci += 1;
		clust_v[k]=1.0*ci/max_density;
	}
	return clust_v;
}

double Graph::average_clustering() {
	double sum_cluster=0;
	vector<double> clust_v = clustering_vector();
	for(auto ci: clust_v)
		sum_cluster += ci;
    return 1.0*sum_cluster/N; 
}

int Graph::nth_moment(int n) { // n=1, average_degree
	if(n==1) return (2*M)/N;
	int res;
	compute_degree_distribution();
	for (auto x : distribution) 
		res += pow(x.first,n) * x.second;
	return res;
}

int Graph::find(int x) {
	if (x != link[x])
		link[x]=find(link[x]);  // path compression
	return link[x];
}

void Graph::unite(int a, int b) {
	a = find(a);
	b = find(b);
	if (a!=b) {
		if (size[a] < size[b]) swap(a,b);
		size[a] += size[b];
		link[b] = a;
	}
}

bool Graph::same(int a, int b) {
	return find(a) == find(b);
}

int Graph::biggest_SCC() {
	int i;
	int biggest_SCC=0;
	link.clear();
	size.clear();
	for (i=0; i<N; i++) { link.push_back(i); size.push_back(1); }
	for (i=0; i<N; i++) for (auto x : neighbours(i)) unite(i, x);
	for (i=0; i<N; i++) if (size[i] > biggest_SCC) biggest_SCC=size[i];
	return biggest_SCC;
}

void Graph::kill_nodes_randomly(int num) {
	srand(time(NULL));
	for (int i=0; i<num; i++) {
		int random_node = (rand() % num);
		removeNode(random_node);
	}
}

void Graph::kill_nodes_targeted(int num) { //1-kill the node with the higher degree. 2-kill the node with the 2nd highest degree. (and so on)
	for (int i=0; i<num; i++)
		removeNode(getHighestDegreeNode());
}
