
// CSES C++ Template (GNU++17)
// - Fast I/O
// - Common aliases + helpers
// - Debug macro (disabled on CSES)
// - Optional: ordered_set (policy-based DS)
#include <bits/stdc++.h>
using namespace std;
#include <cmath>

using ll = long long;
using ull = unsigned long long;
using ld = long double;

using pii = pair<int,int>;
using pll = pair<ll,ll>;

#define all(x) (x).begin(), (x).end()

// ---------- Fast I/O ----------
static inline void fast_io() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
}

// ---------- Constants ----------
const ll INFLL = (ll)4e18;
const int INF = (int)1e9;
const ll MOD = 1000000007LL; // change if needed

// ---------- Debug (off on judge) ----------
#ifdef LOCAL
template <class T> void _print(const T& x) { cerr << x; }
template <class A, class B> void _print(const pair<A,B>& p) { cerr << "("; _print(p.first); cerr << ","; _print(p.second); cerr << ")"; }
template <class T> void _print(const vector<T>& v) { cerr << "["; for (size_t i=0;i<v.size();++i){ if(i) cerr<<","; _print(v[i]); } cerr << "]"; }
template <class T> void _print(const set<T>& s) { cerr << "{"; bool f=0; for (auto &x:s){ if(f) cerr<<","; f=1; _print(x);} cerr << "}"; }
template <class K, class V> void _print(const map<K,V>& m) { cerr << "{"; bool f=0; for (auto &kv:m){ if(f) cerr<<","; f=1; _print(kv);} cerr << "}"; }
#define dbg(x) cerr << #x << " = ", _print(x), cerr << "\n"
#else
#define dbg(x) ((void)0)
#endif

// ---------- Optional: Policy-based DS (ordered_set) ----------
// Uncomment if needed.
// #include <ext/pb_ds/assoc_container.hpp>
// #include <ext/pb_ds/tree_policy.hpp>
// using namespace __gnu_pbds;
// template <class T>
// using ordered_set = tree<T, null_type, less<T>, rb_tree_tag, tree_order_statistics_node_update>;
// usage:
// os.order_of_key(x) -> # of elements < x
// *os.find_by_order(k) -> k-th element (0-indexed)

// ---------- Helpers ----------
template <class T>
bool chmin(T &a, const T &b) { if (b < a) { a = b; return true; } return false; }

template <class T>
bool chmax(T &a, const T &b) { if (a < b) { a = b; return true; } return false; }

ll mod_pow(ll a, ll e, ll mod=MOD) {
    ll r = 1 % mod;
    a %= mod;
    while (e > 0) {
        if (e & 1) r = (ll)((__int128)r * a % mod);
        a = (ll)((__int128)a * a % mod);
        e >>= 1;
    }
    return r;
}

// ---------- Solve ----------
void solve() {
    ll n;
    if !(cin << n) return;

    for (ll i=0;i<n;i++){
        ll p,q;
        cin >> p >> q;

        while ((p!= 0) || (q!=1)){
            if (3 * p == 2 * q){
                cout << "Bob";
                break;
            }
            if (p > 0){
                p--;
            }
            if (q > 1){
                q--;
            }
        }
        cout << "Alice";
    }

    }


int main() {
    fast_io();

    // Most CSES problems: single test.
    solve();

    // If you have multiple tests (rare in CSES), use:
    // int T; cin >> T;
    // while (T--) solve();

    return 0;
}

