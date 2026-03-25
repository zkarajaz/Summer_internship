# Тема 1. Задание №3: Подавление ошибок
## Описание
При поиске файлов (например, командой `find /`) часто возникают ошибки "Permission denied". Чтобы они не засоряли терминал, необходимо перенаправить поток ошибок (stderr) в `/dev/null`.
## Теория
[GNU Bash: Redirections](https://www.gnu.org/software/bash/manual/html_node/Redirections.html)
## Требования к решению
1. Использовать дескриптор потока ошибок '2>'
2. Перенаправить вывод в '/dev/null'.
## Описание решения
- find /etc -name "passwd" 2> /dev/null