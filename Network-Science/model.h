#ifndef __MODEL_H__
#define __MODEL_H__

#include "graph.h"

#define INITIAL_NODES 3

class model {

  public:
  	int iterations;
  	Graph *graph;

  public:
    model(int i) {
      iterations = i;
      graph = new Graph(i+INITIAL_NODES);
      graph->addEdge(0,1);
      graph->addEdge(1,2);
      graph->addEdge(2,0);
    }
    int getIterations() {
      return iterations;
    }
    void clear() {
    	graph = new Graph(iterations+INITIAL_NODES);
      	graph->addEdge(0,1);
      	graph->addEdge(1,2);
      	graph->addEdge(2,0);
    }

    void albert_barabasi(int, double);
    void link_selection_model();
};

#endif