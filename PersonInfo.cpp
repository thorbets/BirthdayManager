// Lab_1.cpp : Этот файл содержит функцию "main". Здесь начинается и заканчивается выполнение программы.
//

#include "pch.h"
#include <iostream>
#include <fstream>
#include <clocale>
#include <iomanip>

using namespace std;

struct ticket
{
	char* fio; // пассажир
	char* point_from; // пункт отправления
	char* point_to; //пункт прибытия
	int price; //цена билета
};
struct ticket *t;
//функция считывания базы из файла
//возвращает количество билетов
int start(void)
{
	ifstream f("file.txt");
		char buff[30];
	int n = 0;
	f >> buff >> buff;
	f >> n;
	if (f.fail()) return 0;
	f >> buff >> buff >> buff >> buff >> buff >> buff >> buff;
	t = (struct ticket*)realloc(t, n * sizeof(struct ticket));
	for (int i = 0; i < n; i++)
	{
		f >> buff;
		t[i].fio = (char*)calloc(strlen(buff) + 1, sizeof(char));
		memcpy(t[i].fio, buff, strlen(buff));
		f >> buff;
		t[i].point_from = (char*)calloc(strlen(buff) + 1, sizeof(char));
		memcpy(t[i].point_from, buff, strlen(buff));
		f >> buff;
		t[i].point_to = (char*)calloc(strlen(buff) + 1, sizeof(char));
		memcpy(t[i].point_to, buff, strlen(buff));
		f >> t[i].price;
	}
	f.close();
	return n;
}
//печать того, что находится в файле
void printbase(int n)
{
	cout << "ФИО\tПункт отправления\tПункт прибытия\tЦена билета\n";
	for (int i = 0; i < 60; i++)
		cout << "-";
	cout << endl;
	for (int i = 0; i < n; i++)
		cout << setw(18) << left << t[i].fio << setw(18) << left << t[i].point_from << setw(18) << left << t[i].point_to << setw(18) << left << t[i].price << endl;
}
//проверка на ввод числа
int num(void)
{
	double buff;
	cin >> buff;
	while (cin.fail())
	{
		cin.clear();
		char c[30];
		cin >> c;
		cout << "Неверное значение, введите ещё раз:";
		cin >> buff;
	}
	return buff;
}
//создание новой строчки
void addnew(int n, char* fio, char* point_from, char* point_to, int price)
{
	static int c = 10;//расширение сруктуры для десятка новых строчек
	if (c == 10)//если этот десяток закончился, то добавим
	{
		t = (struct ticket*)realloc(t, (n + 10) * sizeof(struct ticket));
		c = 0;
	}
	c++;
	t[n].fio = (char*)calloc(strlen(fio) + 1, sizeof(char));
	strcpy_s(t[n].fio, strlen(fio) + 1, fio);
	t[n].point_from = (char*)calloc(strlen(point_from) + 1, sizeof(char));
	strcpy_s(t[n].point_from, strlen(point_from) + 1, point_from);
	t[n].point_to = (char*)calloc(strlen(point_to) + 1, sizeof(char));
	strcpy_s(t[n].point_to, strlen(point_to) + 1, point_to);
	t[n].price = price;
}
//запрос и создание нового элемента
int add(int n)
{
	char bfio[30];
	char bpoint_from[30];
	char bpoint_to[30];
	struct ticket tr;
	cout << "Введите ФИО: ";
	cin >> bfio;
	tr.fio = bfio;
	cout << "Введите пункт отправления: ";
	cin >> bpoint_from;
	tr.point_from = bpoint_from;
	cout << "Введите пункт прибытия: ";
	cin >> bpoint_to;
	tr.point_to = bpoint_to;
	cout << "Введите цену билета: ";
	tr.price = num();
	addnew(n, bfio, bpoint_from, bpoint_to, tr.price); //создание нового элемента
	n++;
	return n;
}
//поиск билета по ФИО
char search_ticket(char *fio, int n)
{
	int k = 0; //для единождого вывода шапки таблицы
	int count = 0;//для проверки на наличие данного пассажира
	for (int i = 0; i < n; ++i)
	{
		int flag;
		char *p_tek; // текущий указатель
		p_tek = t[i].fio;
		flag = strcmp(fio, p_tek);
		if (flag == 0)
		{
			while (k == 0)
			{
				cout << "Фио\tПункт отправления\tПункт прибытия\tЦена билета\n";
				for (int i = 0; i < 60; i++)
					cout << "-";
				cout << endl;
				k++;
			};
			cout << setw(18) << left << t[i].fio << setw(18) << left << t[i].point_from << setw(18) << left << t[i].point_to << setw(18) << left << t[i].price << endl;
			k++;
			count++;
		}
	}
	if (count == 0) cout << "Такого пассажира нет" << endl;
	return 0;
}
//сортировка билетов по алфавиту (пункт отправления)
void sort(int n)
{
	for (int i = 0; i < n - 1; i++)
	{
		for (int j = i + 1; j < n; j++)
		{
			if (strcmp(t[i].point_from, t[j].point_from)>0)
			{
				swap(t[i], t[j]);
			}
		}
	}
}
//фильтр по цене
void filter(int d, int n)
{
	int k = 0;
	int count = 0;
	for (int i = 0; i < n; i++)
	{
		if (t[i].price > d)
		{
			while (k == 0)
				{
				cout << "Фио\tПункт отправления\tПункт прибытия\tЦена билета\n";
				for (int i = 0; i < 60; i++)
					cout << "-";
				cout << endl;
				k++;
				}
			cout << setw(18) << left << t[i].fio << setw(18) << left << t[i].point_from << setw(18) << left << t[i].point_to << setw(18) << left << t[i].price << endl;
			k++;
			count++;
		}
	}
	if (count == 0) cout << "Такого пассажира нет" << endl;
}
//записывание данных в файл, очищeние памяти
void end(int n)
{
	ofstream f("file.txt");
	f << "Количество товаров: " << n << endl << "ФИО\tПункт отправления\tПункт прибытия\tЦена билета" << endl;
	for (int i = 0; i < n; i++)
		f << setw(18) << left << t[i].fio << setw(18) << left << t[i].point_from << setw(18) << left << t[i].point_to << setw(18) << left << t[i].price << endl;
	f.close();
	free(t);
}
int main()
{
	setlocale(0, "Russian");
	int n; //количество пассажиров
	n = start(); //считывание из файла
	bool cont = 0;
	do {
		int choose;
		cout << "Выберите действие:\n" << "Печать всех элементов базы.........1 \n" << "Добавить новый элемент.............2 \n" << "Поиск по ФИО.......................3 \n" << "Сортировка по алфавиту.............4 \n" << "Фильтр по цене.....................5 \n" << "Запись элементов в файл............6 \n...................................." << endl;
		cout << "Введите номер функции: ";
		cin >> choose;
		while (cin.fail())
		{
			cin.clear();
			char c[30];
			cin >> c;
			cout << "Неверное значение, введите ещё раз:";
			cin >> choose;
		};
		cout << "Количество билетов в базе: ";
		cout << n << endl;
		switch (choose)
		{
		case 1: 
		{
			printbase(n);//печать базы
			cout << endl << endl;
			break;
		};
		case 2: 
		{
			n = add(n);
			cout << endl << endl;
			break;
		};
		case 3: 
		{
			char fio[30];
			cout << "Введите ФИО пассажира: ";
			cin >> fio;
			search_ticket(fio, n);
			cout << endl << endl;
			break;
		};
		case 4: 
		{
			sort(n);
			printbase(n);
			cout << endl << endl;
			break;
		};
		case 5:
		{
			int d;
			cout << "Введите минимальную цену: ";
			cin >> d;
			filter(d, n);
			cout << endl << endl;
			break;
		}
		case 6: end(n);
			break;
		default: cout << "Нет такого действия " << endl;
		};
		cout << "Хотите продолжить? (ДА - 1; НЕТ - 0) ";
		cin >> cont;
	} while (cont == 1);
	system("pause");
	return 0;
}

