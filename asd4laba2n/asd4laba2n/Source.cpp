#include <windows.h>
#include <iostream>
#include <fstream>
#include <ctime> 
using namespace std;
class Laba4n2 {//�������� ������, � ������� ���������� ����������
	int N;//����������� �������, ������� ����� �����������
	double mas[10000];//��� ������
public:
	Laba4n2(int N) {
		this->N = N;
	}
	friend istream& operator >> (istream& stream, Laba4n2& p) {
		for (int i = 0; i < p.N; i++) {
			stream >> p.mas[i];
		}
		return stream;
	}
	int i, j, key = 0, temp = 0;
	void InsertSort(ostream& out) //���������� ���������
	{//������ ����������
		int countC = 0, countSwap = 0;
		for (i = 0; i < N - 1; i++)
		{
			key = i + 1;
			temp = mas[key];
			for (j = i + 1; j > 0; j--)
			{
				if (temp < mas[j - 1])
				{
					mas[j] = mas[j - 1];
					key = j - 1;
				}
				countC++;//���������� ����������� (�������� � excel)
			}
			mas[key] = temp;
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
	cout << "������� ���������� ���������: " << endl;// ����������� ���������� ���������, ������� ����� ����� �� �������
	cin >> N;
	while (N > 10000 && N < 1) {//�������� ������� �� ��������� ��������� ������ �������
		cout << "������: ������������ ��������. ����������, ��������� ����." << endl;
		cin >> N;
	}
	Laba4n2 answer(N);//������� ������ � �����������
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
		start = clock();//��������� �������
		cout << "�����:";
		answer.InsertSort(cout);//���������� ����������
		cout << endl;
		end = clock();//����� ��������� ����������
	}
	else
	{
		char u[30];
		cout << "������� �������� �����, � ������� ���������� ������� ������." << endl;// ���� ������ ����, �� ������� � ����� ���� ������� ���������
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
			start = clock();
			out << "�����:";
			answer.InsertSort(out);//���������� ����� ������� � ����
			out << endl;
			end = clock();
			cout << "������ ������� �������� � ��������� ����." << endl;
		}
	}
	unsigned int search = end - start; // ������� �����
	cout << "TIME: " << search << " mill sec"<<endl;
	system("pause");
	return 0;
}