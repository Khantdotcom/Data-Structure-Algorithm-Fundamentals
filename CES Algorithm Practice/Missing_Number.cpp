#include <iostream>
#include <vector>

using namespace std;

int main(){
	long long n;
	cin >> n;

	vector<long long>v(n-1);
	for (int i = 0;i< n-1;i++){
		cin >> v[i];
	}

	long long expected = n * (n+1)/2;
	long long actual = 0;

	for (long long x : v){
		actual += x;
	}

	cout << expected - actual;
}