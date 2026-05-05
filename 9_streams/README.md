# Тема 9. Ввод / вывод. Потоки stdout / stderr

Стандартные потоки, печать через `printf`/`puts`/`putchar`/`fputs`, разделение полезного вывода и логов, буферизация (`fflush`, `setvbuf`), `perror`, безопасный ввод `fgets` вместо `gets`.

## Список задач

| № | Название | Сложность | Файл задания | Решение |
|---|----------|-----------|--------------|---------|
| 01 | Вывод в stdout через printf | супер простая | [01_printf_stdout.md](./01_printf_stdout.md) | [01_printf_stdout.c](./01_printf_stdout.c) |
| 02 | Сообщение об ошибке в stderr | супер простая | [02_fprintf_stderr.md](./02_fprintf_stderr.md) | [02_fprintf_stderr.c](./02_fprintf_stderr.c) |
| 03 | puts против printf | супер простая | [03_puts_vs_printf.md](./03_puts_vs_printf.md) | [03_puts_vs_printf.c](./03_puts_vs_printf.c) |
| 04 | Посимвольный вывод putchar | супер простая | [04_putchar.md](./04_putchar.md) | [04_putchar.c](./04_putchar.c) |
| 05 | fputs в stdout и stderr | супер простая | [05_fputs_two_streams.md](./05_fputs_two_streams.md) | [05_fputs_two_streams.c](./05_fputs_two_streams.c) |
| 06 | Разделение полезного вывода и логов | простая | [06_stdout_vs_stderr.md](./06_stdout_vs_stderr.md) | [06_stdout_vs_stderr.c](./06_stdout_vs_stderr.c) |
| 07 | Принудительный сброс буфера: fflush | простая | [07_fflush.md](./07_fflush.md) | [07_fflush.c](./07_fflush.c) |
| 08 | perror для системных ошибок | простая | [08_perror.md](./08_perror.md) | [08_perror.c](./08_perror.c) |
| 09 | Изменение режима буферизации: setvbuf | простая | [09_setvbuf.md](./09_setvbuf.md) | [09_setvbuf.c](./09_setvbuf.c) |
| 10 | Безопасный ввод строки: fgets вместо gets | простая | [10_fgets_safe_input.md](./10_fgets_safe_input.md) | [10_fgets_safe_input.c](./10_fgets_safe_input.c) |
