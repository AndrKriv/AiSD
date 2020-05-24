#include <iostream>
#include <iomanip>
#include <windows.h>
using namespace std;

int main() {
    SetConsoleCP(1251);
    int n, m, sum = 0;
    cout << "Enter n rows: " << endl;
    cin >> n;//stroka
    cout << "Enter m columns: " << endl;
    cin >> m;//stolbech
    cout << endl;
    int** a = new int* [n];// a - matrix chisel
    int** p = new int* [n];// p - matrix puti
    for (int i = 0; i < n; i++) {// create **m and **p matrix
        a[i] = new int[m];
        p[i] = new int[m];
    }
    for (int i = 0; i < n; i++) {// zapolnyaem m - matrix
        for (int j = 0; j < m; j++) {
            cout << "Matrix [" << i << ", " << j << "]: ";
            cin >> a[i][j];
            p[i][j] = 0;
        }
    }
    cout << endl;
    for (int i = 0; i < n; i++) {// vvivod matrix na ekran
        for (int j = 0; j < m; j++) {
            cout << a[i][j] << " ";
        }
        cout << endl;
    }
    cout << endl;
    p[0][0] = 1;// nachalo puti 
    int i2 = 0, j2 = 0; // mi idem po i2 and j2
    while (i2 != n && j2 != m) {// cikl ne zavershitsyua poka mi ne prishli v i2==n and j2==m
        if (i2 == n - 1) {//ecli mi stuknulis v dno mi idi v ->, j2++
            j2++;
        }
        else {//esli mi kogda shli stuknulis v stenka mi idem vnis i2++;
            if (j2 == m - 1) {
                i2++;
            }
            else {//proverka (\/ or >) 
                if (a[i2 + 1][j2] < a[i2][j2 + 1]) {
                    p[i2 + 1][j2] = 1;
                    i2++;//znachit tuda \/
                }
                else {
                    p[i2][j2 + 1] = 1;
                    j2++;//znachit tuda >
                }
            }
        }
        p[i2][j2] = 1;//set kuda udti
    }
    for (int i = 0; i < n; i++) {//show nash put
        for (int j = 0; j < m; j++) {
            cout << p[i][j] << " ";
        }
        cout << endl;
    }
    system("pause");
    return 0;
}