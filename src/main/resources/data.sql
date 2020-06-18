INSERT INTO origins
VALUES (1, 'igor', '123');

INSERT INTO events (level, event_description, event_log, origin_id)
VALUES (0, 'descricao1', 'log1', 1),
       (2, 'descricao2', 'log2', 1),
       (1, 'descricao3', 'log3', 1);