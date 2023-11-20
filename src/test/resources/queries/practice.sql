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

select name, is_returned
from books b
         right join book_borrow bb on b.id = bb.book_id
where name = 'Fatima book2'
  and is_returned = 0;


select full_name
from users u
         inner join book_borrow bb on u.id = bb.user_id
         inner join books b on bb.book_id = b.id
where full_name = 'Test Student 5' and name = 'Ugly Naked Guy' and is_returned = 0;



