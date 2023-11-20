SELECT B.name, BC.name
FROM books B
         INNER JOIN book_categories BC
                    ON B.book_category_id = BC.id;

-- US01 -1
select count(id)
from users; -- 4891

select count(distinct id)
from users; -- 4891

select count(*)
from book_borrow
where is_returned = 0;

select name
from book_categories;
select distinct author
from books
where name = 'The Scrum Field Guide';

select name
from book_categories;
select distinct author
from books
where name = 'The Scrum Field Guide';

select name, book_borrow.id
from book_borrow
         join books on book_borrow.book_id = books.id
where name = 'Ugly Naked Guy'
group by book_id;

select name, b.id, borrowed_date, planned_return_date, returned_date, is_returned
from books b
         left join book_borrow bb on b.id = bb.book_id
where name = 'Fatima book2';

select *
from book_borrow;