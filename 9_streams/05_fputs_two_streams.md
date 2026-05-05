# 05. fputs в stdout и stderr

**Сложность:** супер простая

**Файл с решением:** [05_fputs_two_streams.c](./05_fputs_two_streams.c)

## Описание задачи

С помощью `fputs` выведите `info` в `stdout` и `warn` в `stderr` (с переводами строк). Покажите, что эти потоки можно разделить перенаправлением.

## Описание решения

`fputs(s, stream)` — низкоуровневый аналог `puts`, но позволяет выбрать поток. В отличие от `puts`, `'\n'` сам не добавляет.

## Примеры

**Пример 1.**

```
$ ./a.out
info
warn
```

**Пример 2.**

```
$ ./a.out 1>out.txt 2>err.txt
(out.txt содержит "info", err.txt содержит "warn")
```

## Документация

https://en.cppreference.com/w/c/io/fputs
