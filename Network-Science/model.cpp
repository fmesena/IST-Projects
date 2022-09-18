#include "model.h"
#include <vector>
#include <cmath>
#include <random>
#include "time.h"

void model::albert_barabasi(int m=2, double alfa=1) {
    
    default_random_engine generator(time(NULL));
    for(int i = 0; i < getIterations(); i++) {

    	vector<double> init;

        for(int j = 0; j<i+INITIAL_NODES; j++) {
            int degree = graph->getDegree(j);
            init.push_back(pow(degree, alfa));
        }

		discrete_distribution<int> distribution(init.begin(), init.end());
        int node1 = distribution(generator);

		int node2 = distribution(generator);
		while(node2==node1) node2 = distribution(generator);

        graph->addEdge(i+INITIAL_NODES,node1);
        graph->addEdge(i+INITIAL_NODES,node2);
    }
}

void model::link_selection_model() {
	vector<pair<int,int> > edgelist;
	edgelist.push_back(pair<int,int>(0, 1));
	edgelist.push_back(pair<int,int>(1, 2));
	edgelist.push_back(pair<int,int>(2, 0));
	int size = edgelist.size();
	pair<int,int> random_edge;
	srand(time(NULL));
	for (int i=size; i<getIterations()+INITIAL_NODES; i++) {
		random_edge = edgelist[(rand()+size)%size++];
		edgelist.push_back(pair<int,int>(i, random_edge.first));
		edgelist.push_back(pair<int,int>(i, random_edge.second));
		graph->addEdge(i, random_edge.first);
		graph->addEdge(i, random_edge.second);
	}
	return;
}