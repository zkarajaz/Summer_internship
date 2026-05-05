# 08. Демонстрация утечки памяти

**Сложность:** простая

**Файл с решением:** [08_memory_leak_demo.c](./08_memory_leak_demo.c)

## Описание задачи

Программа в цикле 5 раз вызывает `malloc`, но ни разу не вызывает `free`. Соберите её с `-fsanitize=address` и запустите — ASan напечатает отчёт о leaked memory. Это типичная утечка.

## Описание решения

Утечка — выделенная и потерянная без `free` память. Не сразу заметна (программа работает), но в долгоживущих процессах приводит к росту RSS. ASan/Valgrind находят такие места при тестировании.

## Примеры

**Пример 1.**

```
$ cc -g -fsanitize=address 08_memory_leak_demo.c && ./a.out
done (but leaked 5 blocks)

=================================================================
==1234==ERROR: LeakSanitizer: detected memory leaks

Direct leak of 20 byte(s) in 5 object(s) allocated from:
    #0 ... in malloc
    #1 ... in main 08_memory_leak_demo.c:6
...
```

## Документация

https://en.cppreference.com/w/c/memory/free
