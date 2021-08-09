#include <iostream>
#include <string>
#include <vector>
#include <algorithm>

using namespace std;

struct Person {
	int age;
	string name;
	int order;
};

bool compare(Person u, Person v) {
	if (u.age < v.age )
		return true;
	else if ( u.age == v.age ) 
		return u.order < v.order;
	else
		return false;	
}


int main (void) {

	int n;
	cin >> n;
	
	vector<Person> v(n);
		
	for (int i = 0; i < n ; i++ ) {
		cin >> v[i].age >> v[i].name;
		v[i].order = i;
	}	

	sort(v.begin(), v.end(), compare);

	for (int i = 0; i < n ; i++ ) {
		cout << v[i].age << " " << v[i].name << "\n";
	}	
	
	return 0;
}
