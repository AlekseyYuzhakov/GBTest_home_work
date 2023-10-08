from datetime import datetime
import os


class Note:
    def __init__(self, date, title, body):
        self.date = date
        self.title = title
        self.body = body

    def __repr__(self):
        return repr((self.date, self.title, self.body))

    def __lt__(self, other):
        try:
            return self.date < other.date
        except ValueError as err:
            print("Classes do not match " + err)


def convert_from_file_in_to_Note():
    return  # object of Note class to put it in list
    pass


def delite_note():
    fined_info_in_list(1)
    pass


def fined_info_in_list():
    return  # position of serching item
    pass


def read_file_note():
    convert_from_file_in_to_Note()
    return  # listofnotes
    pass


def write_in_file(somelist):
    pass


def add_note():
    title = str(input("Введите название заметки: "))
    body = str(input("Введите тело заметки: "))
    datenow = datetime.now()
    dt_string = datenow.strftime("%d/%m/%Y %H:%M:%S")
    temp = Note(dt_string, title, body)
    return temp


def start():
    noteList = []
    flag = True
    print(
        "Добавить заметку введите команду: add\nПосмотреть заметки введите команду: read\nУдалить заметку введите команду: del\nЗакончить работу программы введите команду: exit\n"
    )
    os.system("cls")
    while flag:
        menu_choise = str(input("Введите команду ")).lower()
        if menu_choise == "add":
            temp = add_note()
            noteList.append(temp)
        elif menu_choise == "read":
            print(noteList)
        elif menu_choise == "del":
            delite_note()
        elif menu_choise == "exit":
            write_in_file(noteList)
            break
