INSERT INTO Agenda (title, description, deadline) VALUES
    ('Agenda 1', 'Description for Agenda 1', '2024-05-01 12:00:00'),
    ('Agenda 2', 'Description for Agenda 2', '2024-05-02 12:00:00'),
    ('Agenda 3', 'Description for Agenda 3', '2024-05-03 12:00:00');


INSERT INTO Vote (accepted, associate_id, agenda_id) VALUES
    (true, 1, 1),
    (false, 2, 1),
    (true, 3, 2),
    (false, 1, 2);