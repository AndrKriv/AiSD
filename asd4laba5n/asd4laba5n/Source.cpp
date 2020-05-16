#include <windows.h>
#include <iostream>
#include <fstream>
#include <ctime> 
#include <string>
using namespace std;
int N;//����������� �������, ������� ����� �����������
int mass[10000];//��� ������
int countC = 0, countSwap = 0;
void merge(int l, int r) {//�������, � ������� ������ ����� ������ ����������
	if (r == l)
		return;
	if (r - l == 1) {
		if (mass[r] < mass[l])
			swap(mass[r], mass[l]);
		countSwap++;//���������� ������ (������ ����������� � excel)
		return;
	}
	int m = (r + l) / 2;//���������� ������� �� 2 ����������
	merge(l, m);
	merge(m + 1, r);
	int buf[10000];
	int xl = l;
	int xr = m + 1;
	int cur = 0;
	while (r - l + 1 != cur) {
		if (xl > m)
			buf[cur++] = mass[xr++];
		else if (xr > r)
			buf[cur++] = mass[xl++];
		else if (mass[xl] > mass[xr])
			buf[cur++] = mass[xr++];
		else buf[cur++] = mass[xl++];

	}
	for (int i = 0; i < cur; i++) {
		mass[i + l] = buf[i];
		countC++;//���������� ����������� (������ ����������� � excel)
	}
	
}

void makeMassYb() {//�������, ������� ��������� ������ ���������� �� ��������
	int min, t, i;
	for (int i = 0; i < N; i++) {
		min = i;
		for (int j = i + 1; j < N; j++) {
			if (mass[j] > mass[min]) {//po ybivaniu > ; po vozrast <
				min = j;
			}
		}
		t = mass[i];
		mass[i] = mass[min];
		mass[min] = t;
	}
}
void makeMassVoz() {//�������, ������� ��������� ������ ���������� �� �����������
	int min, t;
	for (int i = 0; i < N; i++) {
		min = i;
		for (int j = i + 1; j < N; j++) {
			if (mass[j] < mass[min]) {
				min = j;
			}
		}
		t = mass[i];
		mass[i] = mass[min];
		mass[min] = t;
	}
}
void printArray(int arr[], int size)//������� ������ �������
{
	int i;
	for (i = 0; i < size; i++)
		cout << arr[i] << " ";
	cout << endl;
}
int main() {
	srand(time(NULL));
	int num;
	unsigned int start = 0; //������ �������
	unsigned int end = 0;//����� �������
	setlocale(LC_ALL, "rus");
	int m;
	cout << "������� ���������� ���������: " << endl;
	cin >> N;//���� ����������� �������
	while (N > 10000 && N < 1) {//�������� �� ������������ ������� �������
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;
		cin >> N;
	}
	cout << "��� ����� ������������� ��������: 1-�� �����������, 2-��������, 3-� ������������ �������: " << endl;//����� ������������ ��������� � �������
	cin >> m;
	while (m != 1 && m != 2 && m != 3)
	{
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;
		cin >> m;
	}
	if (m == 1) {

		for (int i = 0; i < N; i++)
		{
			num = rand() % N + 1;//���������� ������� ���������� �������, ������� ������������ � ����������� �� N
			mass[i] = num;
		}
		makeMassVoz();// �������, ������� �� ����������� � ������������ ������
		cout << "������ ������� �������." << endl;

	}
	if (m == 2) {
		for (int i = 0; i < N; i++)
		{
			num = rand() % N + 1;//���������� ������� ���������� �������, ������� ������������ � ����������� �� N
			mass[i] = num;
		}
		makeMassYb();// �������, ������� �� ����������� � ��������� ������
		cout << "������ ������� �������." << endl;
	}
	if (m == 3) {
		for (int i = 0; i < N; i++)
		{
			num = rand() % N + 1;//���������� ������� ���������� �������, ������� ������������ � ����������� �� N
			mass[i] = num;
		}
		cout << "������ ������� �������." << endl;
	}
	cout << "����� �������� ������� ���������? 1 - � �������, 2 - � ����." << endl;//�������� ��, ���� ��������
	cin >> m;
	while (m != 1 && m != 2)
	{
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;
		cin >> m;
	}
	if (m == 1)
	{
		cout << "�����:";
		start = clock();//����� ������ ����������
		merge(0,N-1);//���������� ����������
		end = clock();//����� ��������� ����������
		printArray(mass, N);//����� �������
		cout << endl;
		cout << "Kol-vo perem: " << countC << endl;//����� ���������� �����������
		cout << "Kol-vo swapow: " << countSwap << endl;//����� ���������� ������
		cout << endl;
	}
	else
	{
		char u[30];
		cout << "������� �������� �����, � ������� ���������� ������� ������." << endl;//����� �����, ���� ������� ��������������� ������
		cin >> u;
		ofstream out(u);
		if (!out)
		{
			cout << "������: �� ������� ������� ����." << endl;
			system("pause");
			return 1;
		}
		else
		{
			start = clock();//����� ������ ����������
			out << "�����:";
			merge(0,N-1);//���������� ����������
			end = clock();//����� ��������� ����������
			printArray(mass, N);//����� �������
			out << endl;
			cout << "������ ������� �������� � ��������� ����." << endl;
		}
	}
	unsigned int search = end - start; // ������� ����� ������ ����������
	cout << "TIME: " << search << " mill sec" << endl;
	system("pause");
	return 0;
}