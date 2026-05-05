# Тема 12. Динамическая память

`malloc`, `calloc`, `realloc`, `free`, проверка на `NULL`, корректное использование `realloc` через временную переменную, утечки памяти, double-free, `free(NULL)`.

## Список задач

| № | Название | Сложность | Файл задания | Решение |
|---|----------|-----------|--------------|---------|
| 01 | malloc + free | супер простая | [01_malloc_free.md](./01_malloc_free.md) | [01_malloc_free.c](./01_malloc_free.c) |
| 02 | calloc — выделение с обнулением | супер простая | [02_calloc_zeroed.md](./02_calloc_zeroed.md) | [02_calloc_zeroed.c](./02_calloc_zeroed.c) |
| 03 | Проверка результата malloc на NULL | супер простая | [03_null_check.md](./03_null_check.md) | [03_null_check.c](./03_null_check.c) |
| 04 | Динамический массив фиксированной длины | супер простая | [04_dynamic_array.md](./04_dynamic_array.md) | [04_dynamic_array.c](./04_dynamic_array.c) |
| 05 | Динамическое выделение структуры | супер простая | [05_alloc_struct.md](./05_alloc_struct.md) | [05_alloc_struct.c](./05_alloc_struct.c) |
| 06 | Безопасный realloc через временную переменную | простая | [06_realloc_safe.md](./06_realloc_safe.md) | [06_realloc_safe.c](./06_realloc_safe.c) |
| 07 | Ловушка: realloc прямо в исходный указатель | простая | [07_realloc_pitfall.md](./07_realloc_pitfall.md) | [07_realloc_pitfall.c](./07_realloc_pitfall.c) |
| 08 | Демонстрация утечки памяти | простая | [08_memory_leak_demo.md](./08_memory_leak_demo.md) | [08_memory_leak_demo.c](./08_memory_leak_demo.c) |
| 09 | Double-free — что это и как его ловить | простая | [09_double_free.md](./09_double_free.md) | [09_double_free.c](./09_double_free.c) |
| 10 | free(NULL) — безопасно по стандарту | простая | [10_free_null_is_ok.md](./10_free_null_is_ok.md) | [10_free_null_is_ok.c](./10_free_null_is_ok.c) |
