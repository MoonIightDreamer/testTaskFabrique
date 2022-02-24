INSERT INTO USERS (NAME, EMAIL, PASSWORD)
VALUES ('User', 'user@gmail.com', '{noop}password'),
       ('Admin', 'admin@gmail.com', '{noop}admin');

INSERT INTO USER_ROLE (ROLE, USER_ID)
VALUES ('USER', 1),
       ('ADMIN', 2),
       ('USER', 2);

INSERT INTO QUIZ (NAME, START_DATE, END_DATE, DESCRIPTION)
VALUES ('Уровень IQ', parsedatetime('14-02-2022','dd-MM-yyyy'), parsedatetime('24-02-2022','dd-MM-yyyy'),
        'Ответьте на пару простых логических вопросов!'),
       ('Кто ты из Винкс', parsedatetime('20-02-2022','dd-MM-yyyy'), parsedatetime('30-03-2022','dd-MM-yyyy'),
        'Какой магией бы ты обладала в сказочном мире Алфеи?'),
       ('Студенческая оценка преподавания', parsedatetime('25-03-2022','dd-MM-yyyy'), parsedatetime('31-03-2022','dd-MM-yyyy'),
        'Оцените изученные курсы!');

INSERT INTO QUESTION (QUESTION_TEXT, QUESTION_TYPE, QUIZ_ID)
VALUES ('Расскажите, какое время суток ваше любимое', 'TEXT', 1),
       ('Сколько будет 2+2?', 'SINGLE_CHOICE', 2),
       ('Что из этого правильно?', 'MULTIPLE_CHOICE', 3);

--The id of the quiz goes first, then, after one #, the answers, divided by %
INSERT INTO USER_QUIZ (ID, QUIZ_ID, USER_RESPONSES)
VALUES (1, 1, '1%2%1%5%7%132%стефан'),
       (2, 3, '5%4%5%5%3%4%география');
