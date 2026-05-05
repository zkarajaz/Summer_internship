# 03. Условная компиляция: #ifdef

**Сложность:** супер простая

**Файл с решением:** [03_ifdef_debug.c](./03_ifdef_debug.c)

## Описание задачи

Если макрос `DEBUG` определён — программа печатает `debug build`, иначе — `release build`. Соберите оба варианта.

## Описание решения

`#ifdef NAME` ... `#else` ... `#endif` включает в компиляцию ту или иную ветку в зависимости от того, определён ли макрос. Макросы можно задавать ключом `-D` компилятора, не меняя код.

## Примеры

**Пример 1.**

```
$ cc 03_ifdef_debug.c -o demo && ./demo
release build
```

**Пример 2.**

```
$ cc -DDEBUG 03_ifdef_debug.c -o demo && ./demo
debug build
```

## Документация

https://en.cppreference.com/w/c/preprocessor/conditional
