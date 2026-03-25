# Тема 4. Задание №2: Размеры типов
## Описание
Используя оператор `sizeof`, выведите на экран размеры в байтах для типов `char`, `int`, `long` и `long long`.
## Теория
[cppreference: sizeof operator](https://en.cppreference.com/w/c/language/sizeof)
## Требования к решению
1. Использовать `sizeof` для каждого типа.
2. Вывести результаты с помощью `printf`, используя спецификатор `%zu` для типа `size_t`.
## Тестовые примеры
Запуск: `./a.out` (вывод для 64-битной системы)
Вывод:
Size of char: 1 bytes
Size of int: 4 bytes
Size of long: 8 bytes
Size of long long: 8 bytes
## Описание решения
`sizeof` — это оператор времени компиляции, который возвращает размер типа или переменной в байтах.