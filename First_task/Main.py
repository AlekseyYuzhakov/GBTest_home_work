import csv
from datetime import datetime
import os


def filter_by_data(list_of_list, search):
    for sublist in list_of_list:
        for elem in sublist:
            if elem.count(search) > 0:
                print(sublist)
                inner_menu()
                menu_choise = str(input("Введите команду: ")).lower()
                if menu_choise == "del":
                    list_of_list = delite_note(list_of_list, sublist)
                    return list_of_list
                elif menu_choise == "edit":
                    list_of_list.remove(sublist)
                    temp = add_note()
                    list_of_list.append(temp)
                    list_of_list.sort()
                    return list_of_list
                elif menu_choise == "main":
                    return list_of_list
    return list_of_list


def sorting_list_of_note(list_of_list):
    temp = []
    for i in range(len(list_of_list) - 1):
        for j in range(len(list_of_list) - 1 - i):
            if datetime.strptime(
                list_of_list[j][0], "%d/%m/%Y %H:%M:%S"
            ) < datetime.strptime(list_of_list[j + 1][0], "%d/%m/%Y %H:%M:%S"):
                temp = list_of_list[j]
                list_of_list[j] = list_of_list[j + 1]
                list_of_list[j + 1] = temp
    return list_of_list


def delite_note(list_of_list, elem):
    for sublist in list_of_list:
        if sublist.count(elem) > 0:
            print(sublist)
            print("Хотите удалить заметку ? ")
            user_choise = str(input("y или n: ")).lower()
            if user_choise == "y":
                list_of_list.remove(sublist)
            else:
                break
    return list_of_list


def read_file_note():
    somelist = []
    with open("notebook.csv", "r", newline="") as csvfile:
        spamreader = csv.reader(csvfile)
        for row in spamreader:
            somelist.append(row)
    return somelist


def write_in_file(data):
    with open("notebook.csv", "w", encoding="utf - 8", newline="") as f:
        writer = csv.writer(f)
        for elem in data:
            writer.writerow(elem)


def add_note():
    somelist = []
    title = "title: " + str(input("Введите название заметки: ")) + ";"
    body = "body: " + str(input("Введите тело заметки: ")) + ";"
    datenow = datetime.now()
    dt_string = datenow.strftime("%d/%m/%Y %H:%M:%S") + ";"
    somelist.append(dt_string)
    somelist.append(title)
    somelist.append(body)
    return somelist


def start():
    noteList = read_file_note()
    noteList = sorting_list_of_note(noteList)
    flag = True
    menu()
    while flag:
        menu_choise = str(input("Введите команду: ")).lower()
        if menu_choise == "add":
            temp = add_note()
            noteList.append(temp)
        elif menu_choise == "read":
            print("Number:  Date:   Title:   Body:")
            for i, elem in enumerate(noteList):
                print(i + 1, ":", *elem)
        elif menu_choise == "search":
            search = str(input("Введите значение для поиска "))
            noteList = filter_by_data(noteList, search)
        elif menu_choise == "exit":
            write_in_file(noteList)
            break
    os.system("cls")


def menu():
    print(
        "Добавить заметку введите команду: add\nПосмотреть заметки введите команду: read\nЧто бы произвести отбор заметки введите команду: search\nЗакончить работу программы введите команду: exit\n"
    )

def inner_menu():
    print(
        "Редактировать заметки введите команду: edit\nУдалить заметку введите команду: del\nЧто бы вернуться в общее меню введите команду: main\n"
    )

start()
