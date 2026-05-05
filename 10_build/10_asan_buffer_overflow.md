# 10. AddressSanitizer ловит выход за границы

**Сложность:** простая

**Файл с решением:** [10_asan_buffer_overflow.c](./10_asan_buffer_overflow.c)

## Описание задачи

Напишите программу с намеренным выходом за границы массива (`a[10]`, обращение к `a[10]`). Соберите её **с санитайзером** и запустите — ASan распечатает stack trace и опишет, где произошла ошибка. Без флага программа может «работать» — это и есть опасность UB.

## Описание решения

AddressSanitizer (`-fsanitize=address`, GCC/Clang) — рантайм-инструмент. Он подменяет аллокатор и инструментирует обращения к памяти, ловя buffer overflow, use-after-free, утечки и т.д. Используйте при разработке и тестах.

## Примеры

**Пример 1.**

```
$ cc -g -fsanitize=address 10_asan_buffer_overflow.c && ./a.out
==1234==ERROR: AddressSanitizer: stack-buffer-overflow on address 0x...
WRITE of size 4 at 0x... thread T0
    #0 ... in main 10_asan_buffer_overflow.c:6
...
```

## Документация

https://gcc.gnu.org/onlinedocs/gcc/Instrumentation-Options.html
