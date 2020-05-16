#include <windows.h>
#include <iostream>
#include <fstream>
#include <ctime> 
using namespace std;
int N;//����������� �������, ������� ����� �����������
int mass[10000];//��� ������
int countC = 0, countSwap = 0;
void qsort(int b, int e)//�������, � ������� ������ ����� ������ ����������
{
	int l = b, r = e;
	int piv = mass[(l + r) / 2]; //����������� ��������� ��� ������� ������ �������
	while (l <= r)
	{
		while (mass[l] < piv) {
			l++;
			countC++;//���������� ����������� (������ ����������� � excel)
		}
		countC++;
		while (mass[r] > piv) {
			r--;
			countC++;//���������� ����������� (������ ����������� � excel)
		}
		countC++;
		if (l <= r) {
			swap(mass[l++], mass[r--]);
			countSwap++;//���������� ������ (������ ����������� � excel)
		}
	}
	if (b < r)
		qsort(b, r);
	if (e > l)
		qsort(l, e);
}
void makeMassYb() {//�������, ������� ��������� ������ ���������� �� ��������
	int min, t;
	for (int i = 0; i < N; i++) {
		min = i;
		for (int j = i + 1; j < N; j++) {
			if (mass[j] > mass[min]) {
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
	while (N > 10000 && N < 1) {
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;//�������� �� ������������ ������� �������
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
		qsort( 0, N - 1);//���������� ����������
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
			out << "�����:";
			start = clock();//����� ������ ����������
			qsort(0, N - 1);//���������� ����������
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