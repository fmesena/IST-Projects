#include "graph.h"
#include "model.h"
#include <iostream>
#include <fstream>

int main() {

	int iterations, generated_graphs;
	cin >> iterations >> generated_graphs;

	std::cout << "############## Running\n";
	std::cout << "############## Generating graphs. Computing degree distribution\n";
	
	model *LSM_model;
	model *BA_model;
	vector<map<int, double> > distributions_LSM;
	vector<map<int, double> > distributions_BA;
	vector<map<int, double> > clustering_distr_LSM;
	vector<map<int, double> > clustering_distr_BA;

	for (int i=0; i<generated_graphs; i++) {
		LSM_model  = new model(iterations);
		BA_model = new model(iterations);
		LSM_model->link_selection_model();
		BA_model->albert_barabasi(2, 1);
		LSM_model->graph->compute_degree_distribution();
		BA_model->graph->compute_degree_distribution();
		distributions_LSM.push_back(LSM_model->graph->getDegreeDistribution());
		distributions_BA.push_back(BA_model->graph->getDegreeDistribution());
		clustering_distr_LSM.push_back(LSM_model->graph->clustering_of_degree());
		clustering_distr_BA.push_back(BA_model->graph->clustering_of_degree());
	}
	
	map<int,double> avg_distr_LSM;
	for (auto distribution : distributions_LSM)
		for (auto k_probk : distribution) {
			std::map<int,double>::iterator it=avg_distr_LSM.find(k_probk.first);
			if (it == avg_distr_LSM.end()) avg_distr_LSM.insert(std::pair<int,double>(k_probk.first, k_probk.second));
			else it->second += k_probk.second;
		}
	map<int,double> avg_distr_BA;
	for (auto distribution : distributions_BA)
		for (auto k_probk : distribution) {
			std::map<int,double>::iterator it=avg_distr_BA.find(k_probk.first);
			if (it == avg_distr_BA.end()) avg_distr_BA.insert(std::pair<int,double>(k_probk.first, k_probk.second));
			else it->second += k_probk.second;
		}

	ofstream myfile;
	myfile.open ("P_k_LSM.txt");
	//normalize probabilities
	for (auto k_probk : avg_distr_LSM) {
		std::map<int,double>::iterator it=avg_distr_LSM.find(k_probk.first);
		if (it != avg_distr_LSM.end()) {
			it->second = it->second/generated_graphs;
			myfile << it->first << " " << it->second << "\n";
		}
		else cerr << "error\n";
	}
  	myfile.close();

	myfile.open ("P_k_BA.txt");
	//normalize probabilities
	for (auto k_probk : avg_distr_BA) {
		std::map<int,double>::iterator it=avg_distr_BA.find(k_probk.first);
		if (it != avg_distr_BA.end()) {
			it->second = it->second/generated_graphs;
			myfile << it->first << " " << it->second << "\n";
		}
		else cerr << "error\n";
	}
  	myfile.close();

  	std::cout << "############## Computing clustering distribution in function of the degrees\n";
	map<int,double> avg_clust_distr_LSM;
	for (auto distribution : clustering_distr_LSM)
		for (auto k_probk : distribution) {
			std::map<int,double>::iterator it=avg_clust_distr_LSM.find(k_probk.first);
			if (it == avg_clust_distr_LSM.end()) avg_clust_distr_LSM.insert(std::pair<int,double>(k_probk.first, k_probk.second));
			else it->second += k_probk.second;
		}

	map<int,double> avg_clust_distr_BA;
	for (auto distribution : clustering_distr_BA)
		for (auto k_probk : distribution) {
			std::map<int,double>::iterator it=avg_clust_distr_BA.find(k_probk.first);
			if (it == avg_clust_distr_BA.end()) avg_clust_distr_BA.insert(std::pair<int,double>(k_probk.first, k_probk.second));
			else it->second += k_probk.second;
		}
	
  	myfile.open ("clustering_degree_LSM.txt");
	for (auto k_probk : avg_clust_distr_LSM) {
		std::map<int,double>::iterator it=avg_clust_distr_LSM.find(k_probk.first);
		if (it != avg_clust_distr_LSM.end()) {
			it->second = it->second/generated_graphs;
			myfile << it->first << " " << it->second << "\n";
		}
		else cerr << "error\n";
	}
	myfile.close();
  	myfile.open ("clustering_degree_BA.txt");
	for (auto k_probk : avg_clust_distr_BA) {
		std::map<int,double>::iterator it=avg_clust_distr_BA.find(k_probk.first);
		if (it != avg_clust_distr_BA.end()) {
			it->second = it->second/generated_graphs;
			myfile << it->first << " " << it->second << "\n";
		}
		else cerr << "error\n";
	}
	myfile.close();

	std::cout << "############## Killing nodes\n";

	double step = 0.1;
	int N = iterations+3;
	int num = N * step;
	int ola = N / num;

	vector<int> killRandom_LSM(ola,0);
	vector<int> killRandom_BA(ola,0);

	for (int i=0; i<generated_graphs; i++) {
		LSM_model = new model(iterations);
		BA_model = new model(iterations);
		LSM_model->link_selection_model();
		BA_model->albert_barabasi(2, 1);


		for(int j = 0; j<ola; j++) {
			LSM_model->graph->kill_nodes_randomly(num); 
			BA_model->graph->kill_nodes_randomly(num);
			killRandom_LSM[j] += LSM_model->graph->biggest_SCC();
			killRandom_BA[j] += BA_model->graph->biggest_SCC();
		}
	}

	myfile.open ("ConComp_kill_random_LSM.txt");
	for (int i=0; i<ola; i++)
		myfile << 10*(i+1) << " " << killRandom_LSM[i]/generated_graphs << "\n";
	myfile.close();

	myfile.open ("ConComp_kill_random_BA.txt");
	for (int i=0; i<ola; i++)
		myfile << 10*(i+1) << " " << killRandom_BA[i]/generated_graphs << "\n";
	myfile.close();


	step = 0.1;
	N = iterations+3;
	num = N * step;
	ola = N / num;

	vector<int> killTargeted_LSM(ola,0);
	vector<int> killTargeted_BA(ola,0);

	for (int i=0; i<generated_graphs; i++) {
		LSM_model  = new model(iterations);
		BA_model = new model(iterations);
		LSM_model->link_selection_model();
		BA_model->albert_barabasi(2, 1);

		for(int j=0; j<ola; j++) {
			LSM_model->graph->kill_nodes_targeted(num); 
			BA_model->graph->kill_nodes_targeted(num);
			killTargeted_LSM[j] += LSM_model->graph->biggest_SCC();
			killTargeted_BA[j] += BA_model->graph->biggest_SCC();
		}
	}

	myfile.open ("ConComp_kill_targeted_LSM.txt");
	for (int i=0; i<ola; i++)
		myfile << 10*(i+1) << " " << killTargeted_LSM[i]/generated_graphs << "\n";
	myfile.close();

	myfile.open ("ConComp_kill_targeted_BA.txt");
	for (int i=0; i<ola; i++)
		myfile << 10*(i+1) << " " << killTargeted_BA[i]/generated_graphs << "\n";
	myfile.close();

  	std::cout << "############## Bye\n";
	return 0;
}
