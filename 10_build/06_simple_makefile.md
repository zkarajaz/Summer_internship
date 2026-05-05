# 06. Простой Makefile

**Сложность:** простая

**Файл с решением:** [06_simple_makefile.c](./06_simple_makefile.c)

## Описание задачи

Соберите программу `hello` через `make`. В каталоге уже есть `06_simple_makefile.c` и `Makefile` с целями `all`, `clean`.

## Описание решения

`make` выполняет правила вида `цель: зависимости \n <TAB> команда`. Правило выполняется, если цели нет или зависимость новее цели. `clean` — соглашение об именах для удаления артефактов сборки.

## Примеры

**Пример 1.**

```
$ make && ./hello
cc -Wall -Wextra -O2 06_simple_makefile.c -o hello
built with make
```

**Пример 2.**

```
$ make clean
rm -f hello
```

## Документация

https://www.gnu.org/software/make/manual/make.html
