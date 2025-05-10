-- Consultar a tabela
select * from task;

-- Inserir uma linha da tabela
INSERT INTO task (title, description, completed, created_at)
VALUES (
    'Implementar SOLID',
    'Aplicar princípios de SOLID no módulo de tarefas',
    false, 
    CURRENT_TIMESTAMP
);

-- Tarefas concluídas
SELECT title, description FROM task WHERE completed = true;

-- Tarefas criadas hoje
SELECT title, created_at FROM task WHERE created_at::date = CURRENT_DATE;

