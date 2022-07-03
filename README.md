## Запуск
```console
$ sudo docker-compose up
```

## Сопроводительное письмо

### Сложности

При создании приложения основаная сложность для меня заключалась в
тестировании различных компонентов приложения: хоть я и был
знаком с тем, что такое unit-тесты, я не был уверен как изолированно
тестировать репозитории, сервисы, контроллеры. Проблема была решена
при помощи документации Spring и простого поиска решений проблемы в
интернете.

### Структура

Общая структура приложения соответствует стандартной структуре maven-приложения.

Само приложение разделяется на пакеты `controller`, `model`, `repository`,
`service` соответственно четырём различным классам объектов, которые я
использовал в проекте. Также именно с такой структурой приложения я познакомился,
просматривая исходный код других Java-приложений.

Также я рассматривал возможность создания DTO (Data Transfer Objects),
однако я не смог наверняка выяcнить имеет ли это смысл в рамках моего
приложения, потому решил отказаться от этой идеи. Часть источников говорила о том, что DTO
нужно создавать несмотря ни на что, другая же часть — что они необходимы только
в том случае, если внутреннее представление объекта должно каким-то
образом отличаться от внешнего.