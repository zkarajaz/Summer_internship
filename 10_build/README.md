# Тема 10. Сборка программы. Препроцессор, макросы, Makefile, санитайзер

Этапы сборки (preprocess → compile → link), директивы `#define`, `#ifdef`, `#include`, предопределённые макросы, передача `-D`, Makefile, многофайловая сборка, ловушки макросов, AddressSanitizer.

## Список задач

| № | Название | Сложность | Файл задания | Решение |
|---|----------|-----------|--------------|---------|
| 01 | #define для константы | супер простая | [01_define_const.md](./01_define_const.md) | [01_define_const.c](./01_define_const.c) |
| 02 | Простой макрос с параметром | супер простая | [02_macro_square.md](./02_macro_square.md) | [02_macro_square.c](./02_macro_square.c) |
| 03 | Условная компиляция: #ifdef | супер простая | [03_ifdef_debug.md](./03_ifdef_debug.md) | [03_ifdef_debug.c](./03_ifdef_debug.c) |
| 04 | Предопределённые макросы __FILE__ и __LINE__ | супер простая | [04_file_line.md](./04_file_line.md) | [04_file_line.c](./04_file_line.c) |
| 05 | #include: системный vs пользовательский | супер простая | [05_include_user_vs_system.md](./05_include_user_vs_system.md) | [05_include_user_vs_system.c](./05_include_user_vs_system.c) |
| 06 | Простой Makefile | простая | [06_simple_makefile.md](./06_simple_makefile.md) | [06_simple_makefile.c](./06_simple_makefile.c) |
| 07 | Сборка из нескольких .c файлов | простая | [07_multifile_build.md](./07_multifile_build.md) | [07_multifile_build.c](./07_multifile_build.c) |
| 08 | Передача макроса через -D | простая | [08_dmacro_from_cli.md](./08_dmacro_from_cli.md) | [08_dmacro_from_cli.c](./08_dmacro_from_cli.c) |
| 09 | Ловушка макросов: SQUARE(a+b) | простая | [09_macro_pitfall.md](./09_macro_pitfall.md) | [09_macro_pitfall.c](./09_macro_pitfall.c) |
| 10 | AddressSanitizer ловит выход за границы | простая | [10_asan_buffer_overflow.md](./10_asan_buffer_overflow.md) | [10_asan_buffer_overflow.c](./10_asan_buffer_overflow.c) |
