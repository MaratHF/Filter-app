Инструкция 

Описание работы: Данная утилита предназначена для фильтрации содержимого файлов, содержащих целые числа, вещественные числа и строки. 
Утилита читает файлы, указанные в командной строке, и записывает отфильтрованные данные в соответствующие выходные файлы, . 

Параметры утилиты:
- Версия Java: 21;
- Система сборки: Apache Maven версии 4.0.0.

Сторонние библиотеки:
- Apache Commons CLI: версия 1.9.0

Зависимость для Maven:
<dependency>
      <groupId>commons-cli</groupId>
      <artifactId>commons-cli</artifactId>
      <version>1.9.0</version>
    </dependency>

Чтобы запустить утилиту, используйте следующую команду в терминале (пример):
java -jar target/filter-app-0.0.1-SNAPSHOT.jar -o [путь_для_результатов] -p [префикс] -a -s -f test1.txt test2.txt ...

Описание опций:
- "-o" — задает путь для записи отфильтрованных файлов (по умолчанию текущая директория);
- "-p" — задает префикс для имен выходных файлов;
- "-a" — записывает данные в уже имеющиеся выходные файлы, а не создает новые;
- "-s" — выводит краткую статистику по входным данным;
- "-f" — выводит полую статистику по входных данным;

