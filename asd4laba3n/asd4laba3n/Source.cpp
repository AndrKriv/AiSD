#include <windows.h>
#include <iostream>
#include <fstream>
#include <ctime>
using namespace std;
class Laba4n3 {//�������� ������, � ������� ���������� ����������
	int N;//����������� �������, ������� ����� �����������
	double mass[10000];//��� ������
public:
	Laba4n3(int N) {
		this->N = N;
	}
	friend istream& operator >> (istream& stream, Laba4n3& p) {//���� �� ����� (������ �� �����)
		for (int i = 0; i < p.N; i++) {
			stream >> p.mass[i];
		}
		return stream;
	};

	void bubbleSort(ostream& out)//������ ����������
	{
		int min, t, i;
		int countC = 0, countSwap = 0;
		// ��� ���� ���������
		for (int i = 0; i < N - 1; i++)
		{
			for (int j = (N - 1); j > i; j--) // ��� ���� ��������� ����� i-���
			{
				if (mass[j - 1] > mass[j]) // ���� ������� ������� ������ �����������
				{
					countC++;//���������� ����������� (�������� � excel)
					int temp = mass[j - 1]; // ������ �� �������
					mass[j - 1] = mass[j];
					mass[j] = temp;
				}
			}
			countSwap++;//���������� ������ (�������� � excel)
		}
		cout << endl;
		cout << "Kol-vo perem: " << countC << endl;
		cout << "Kol-vo swapow: " << countSwap << endl;
	}
};
int main() {//�������� main-�������
	unsigned int start = 0; // ��������� �����
	unsigned int end = 0; // �������� �����
	setlocale(LC_ALL, "rus");
	int m, N;
	double mass[10000];//������ � ��������� ������� ������������� ������� (�������� �������� ������������)
	cout << "������� ���������� ���������: " << endl;
	cin >> N;// ����������� ���������� ���������, ������� ����� ����� �� �������
	while (N > 10000 && N < 1) {//�������� ������� �� ��������� ��������� ������ �������
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;
		cin >> N;
	}
	Laba4n3 answer(N);//������� ������ � �����������
	cout << "��� ����� ������������� ��������: 1-�� �����������, 2-��������, 3-� ������������ �������: " << endl;//����� ������ ���� ����� ������
	cin >> m;
	while (m != 1 && m != 2 && m != 3)
	{
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;
		cin >> m;
	}
	if (m == 1) {
		ifstream in("up.txt");//����, � ������� ���������� ������ � ���������� �� ����������� ����������� 10000
		if (!in)
		{
			cout << "������: �� ������� ������� ����." << endl;
			system("pause");
			return 1;
		}
		else
		{
			in >> answer;
			cout << "������ ������� ������� �� �����." << endl;
		}
	}
	if (m == 2) {
		ifstream in("down.txt");//����, � ������� ���������� ������ � ���������� �� �������� ����������� 10000
		if (!in)
		{
			cout << "������: �� ������� ������� ����." << endl;
			system("pause");
			return 1;
		}
		else
		{
			in >> answer;

			cout << "������ ������� ������� �� �����." << endl;
		}
	}
	if (m == 3) {
		ifstream in("rand.txt");//����, � ������� ���������� ������ � ����������, ������������� ��������, ����������� 10000
		if (!in)
		{
			cout << "������: �� ������� ������� ����." << endl;
			system("pause");
			return 1;
		}
		else
		{
			in >> answer;

			cout << "������ ������� ������� �� �����." << endl;
		}
	}
	cout << "����� �������� ������� ���������? 1 - � �������, 2 - � ����." << endl;// ����� ���� ������� ��������� ����������
	cin >> m;
	while (m != 1 && m != 2)
	{
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;
		cin >> m;
	}
	if (m == 1)
	{
		start = clock();//��������� ����� ������ ����������
		cout << "�����:";
		answer.bubbleSort(cout);
		end = clock();//����������� ���� �������
		cout << endl;
	}
	else
	{
		char u[30];
		cout << "������� �������� �����, � ������� ���������� ������� ������." << endl;
		cin >> u;// ���� ������ ����, �� �������� �������� �����, � ������� ������� ���������
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
			answer.bubbleSort(out);//���������� ����� ������� � ����
			out << endl;
			cout << "������ ������� �������� � ��������� ����." << endl;
		}
	}
	unsigned int search = end - start; // ������� �����
	cout << "TIME: " << search << " mill sec" << endl;
	system("pause");
	return 0;
};