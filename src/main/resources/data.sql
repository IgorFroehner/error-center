INSERT INTO origins
VALUES (1, 'frontend01', '123'),
       (2, 'frontend02', '123');

INSERT INTO events (level, event_description, event_log, origin_id, created_at)
VALUES (0, 'descricao1', 'log1', 1, '2020-02-10'),
       (2, 'descricao2', 'log2', 2, '2020-05-12'),
       (1, 'descricao3', 'log3', 1, '2019-12-25');