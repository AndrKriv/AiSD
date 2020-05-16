#include <windows.h>
#include <iostream>
#include <fstream>
#include <ctime> 
using namespace std;
class Laba4n1 {//создание класса, в котором выполнится сортировка
	int N;//размерность массива, который юудем сортировать
	double mass[10000];//сам массив
public:
	Laba4n1(int N) {
		this->N = N;
	}
	friend istream& operator >> (istream& stream, Laba4n1& p) {//ввод из файла (чтение из файла)
		for (int i = 0; i < p.N; i++) {
			stream >> p.mass[i];
		}
		return stream;
	};
	
	void vibSort(ostream& out) {//работа сортировки
		int min, t, i;
		int countC=0,countSwap = 0;
		for (int i = 0; i < N; i++) {
			min = i;
			for (int j = i + 1; j < N; j++) {
				if (mass[j] < mass[min]) {
					min = j;
				}
				countC++;//количество перемещений (записано в excel)
			}
			t = mass[i];
			mass[i] = mass[min];
			mass[min] = t;
			countSwap++;//количество свапов (записано в excel)
		}
		cout << endl;
		cout << "Kol-vo perem: " << countC<<endl;
		cout << "Kol-vo swapow: " << countSwap<<endl;
	}
};
int main() {//основная main-функция
	unsigned int start = 0; // начальное время
	unsigned int end = 0; // конечное время
	setlocale(LC_ALL, "rus");
	int m, N;
	double mass[10000];//работа с созданием массива максимального размера (задается условием лабораторной)
	cout << "Введите количество элементов: " << endl;// определение количества элементов, сколько будет взято из массива
	cin >> N;
	while (N > 10000 && N < 1) {//проверка условия на требуемый введенный размер массива
		cout << "Ошибка: Некорректное значение. Пожалуйста, повторите ввод." << endl;
		cin >> N;
	}
	Laba4n1 answer(N);//возврат класса с сортировкой
	cout << "Как будут распологаться элементы: 1-по возрастанию, 2-убыванию, 3-в произвольном порядке: " << endl;//выбор какого вида будет массив
	cin >> m;
	while (m != 1 && m != 2 && m != 3)
	{
		cout << "Ошибка: Некорректное значение. Пожалуйста, повторите ввод." << endl;
		cin >> m;
	}
	if (m == 1) {
		ifstream in("up.txt");//файл, в котором содержится массив с элементами по возрастанию размерности 10000
		if (!in)
		{
			cout << "Ошибка: Не удалось открыть файл." << endl;
			system("pause");
			return 1;
		}
		else
		{
			in >> answer;
			cout << "Данные успешно считаны из файла." << endl;
		}
	}
	if (m == 2) {
		ifstream in("down.txt");//файл, в котором содержится массив с элементами по убыванию размерности 10000
		if (!in)
		{
			cout << "Ошибка: Не удалось открыть файл." << endl;
			system("pause");
			return 1;
		}
		else
		{
			in >> answer;

			cout << "Данные успешно считаны из файла." << endl;
		}
	}
	if (m == 3) {
		ifstream in("rand.txt");//файл, в котором содержится массив с элементами, расположенных рандомно, размерности 10000
		if (!in)
		{
			cout << "Ошибка: Не удалось открыть файл." << endl;
			system("pause");
			return 1;
		}
		else
		{
			in >> answer;

			cout << "Данные успешно считаны из файла." << endl;
		}
	}
	cout << "Каким способом вывести результат? 1 - в консоль, 2 - в файл." << endl;// выбор куда вывести результат сортировки
	cin >> m;
	while (m != 1 && m != 2)
	{
		cout << "Ошибка: Некорректное значение. Пожалуйста, повторите ввод." << endl;
		cin >> m;
	}
	if (m == 1)
	{
		start = clock();//засеканем время работы сортировки
		cout << "Ответ:";
		answer.vibSort(cout);//проведение сортировки
		cout << endl;
		end = clock();//время окончания сортировки
	}
	else
	{
		char u[30];
		cout << "Введите название файла, в который необходимо вывести данные." << endl;// если выбран файл, то выбрать в какой файл вывести результат
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
			start = clock();
			out << "Ответ:";
			answer.vibSort(out);//сортировка перед записью в файл
			out << endl;
			end = clock();
			cout << "Данные успешно записаны в указанный файл." << endl;
		}
	}
	unsigned int search = end - start; // искомое время
	cout << "TIME: " << search<<" mill sec";//время исполнения сортировки
	system("pause");
	return 0;
}