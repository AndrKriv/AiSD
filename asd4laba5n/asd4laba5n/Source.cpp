#include <windows.h>
#include <iostream>
#include <fstream>
#include <ctime> 
#include <string>
using namespace std;
int N;//размерность массива, который юудем сортировать
int mass[10000];//сам массив
int countC = 0, countSwap = 0;
void merge(int l, int r) {//функция, в которой описан метод работы сортировки
	if (r == l)
		return;
	if (r - l == 1) {
		if (mass[r] < mass[l])
			swap(mass[r], mass[l]);
		countSwap++;//количество свапов (данные расположены в excel)
		return;
	}
	int m = (r + l) / 2;//разделение массива на 2 подмассива
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
		countC++;//количество перемещений (данные расположены в excel)
	}
	
}

void makeMassYb() {//функция, которая заполняет массив элементами по убыванию
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
void makeMassVoz() {//функция, которая заполняет массив элементами по возрастанию
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
void printArray(int arr[], int size)//функция вывода массива
{
	int i;
	for (i = 0; i < size; i++)
		cout << arr[i] << " ";
	cout << endl;
}
int main() {
	srand(time(NULL));
	int num;
	unsigned int start = 0; //начало времени
	unsigned int end = 0;//конец времени
	setlocale(LC_ALL, "rus");
	int m;
	cout << "Введите количество элементов: " << endl;
	cin >> N;//ввод размерности массива
	while (N > 10000 && N < 1) {//проверка на корректность размера массива
		cout << "Ошибка: Некорректное значение. Пожалуйста, повторите ввод." << endl;
		cin >> N;
	}
	cout << "Как будут распологаться элементы: 1-по возрастанию, 2-убыванию, 3-в произвольном порядке: " << endl;//выбор расположения элементов в массиве
	cin >> m;
	while (m != 1 && m != 2 && m != 3)
	{
		cout << "Ошибка: Некорректное значение. Пожалуйста, повторите ввод." << endl;
		cin >> m;
	}
	if (m == 1) {

		for (int i = 0; i < N; i++)
		{
			num = rand() % N + 1;//заполнение массива рандомными числами, которые определяются в зависимости от N
			mass[i] = num;
		}
		makeMassVoz();// функция, которая их преобразует в возрастающий массив
		cout << "Данные успешно считаны." << endl;

	}
	if (m == 2) {
		for (int i = 0; i < N; i++)
		{
			num = rand() % N + 1;//заполнение массива рандомными числами, которые определяются в зависимости от N
			mass[i] = num;
		}
		makeMassYb();// функция, которая их преобразует в убывающий массив
		cout << "Данные успешно считаны." << endl;
	}
	if (m == 3) {
		for (int i = 0; i < N; i++)
		{
			num = rand() % N + 1;//заполнение массива рандомными числами, которые определяются в зависимости от N
			mass[i] = num;
		}
		cout << "Данные успешно считаны." << endl;
	}
	cout << "Каким способом вывести результат? 1 - в консоль, 2 - в файл." << endl;//проверка то, куда выводить
	cin >> m;
	while (m != 1 && m != 2)
	{
		cout << "Ошибка: Некорректное значение. Пожалуйста, повторите ввод." << endl;
		cin >> m;
	}
	if (m == 1)
	{
		cout << "Ответ:";
		start = clock();//время старта сортировки
		merge(0,N-1);//выполнение сортировки
		end = clock();//время окончания сортировки
		printArray(mass, N);//вывод массива
		cout << endl;
		cout << "Kol-vo perem: " << countC << endl;//вывод количества перемещений
		cout << "Kol-vo swapow: " << countSwap << endl;//вывод количества свапов
		cout << endl;
	}
	else
	{
		char u[30];
		cout << "Введите название файла, в который необходимо вывести данные." << endl;//выбор файла, куда вывести отсортированный массив
		cin >> u;
		ofstream out(u);
		if (!out)
		{
			cout << "Ошибка: Не удалось открыть файл." << endl;
			system("pause");
			return 1;
		}
		else
		{
			start = clock();//время старта сортировки
			out << "Ответ:";
			merge(0,N-1);//выполнение сортировки
			end = clock();//время окончания сортировки
			printArray(mass, N);//вывод массива
			out << endl;
			cout << "Данные успешно записаны в указанный файл." << endl;
		}
	}
	unsigned int search = end - start; // искомое время работы сортировки
	cout << "TIME: " << search << " mill sec" << endl;
	system("pause");
	return 0;
}