INSERT INTO users (email, encryptedpassword, enabled)
VALUES ('padakshc@sheridancollege.ca', '$2a$10$VeTOTsdXvxwblNQx10EhB.zgfNw0NUcl0cptrX12RTzR/bUsMAy6i', 1);
INSERT INTO users (email, encryptedpassword, enabled)
VALUES ('shressud@sheridancollege.ca', '$2a$10$oFFy45QcZYbJqn1eM8vZeuCuQpU6Emlif7kGAYJv9beYjMjMBNj4q', 1);

--password for padakshc is 1234
--password for shressud is 1111
--please put passowrd here for your assignment4

INSERT INTO roles (rolename)
VALUES ('ROLE_ADMIN');  --1 admin
INSERT INTO roles (rolename)	
VALUES ('ROLE_USER'); --2 user

INSERT INTO user_role (userid, roleid)
VALUES (1, 1); 
INSERT INTO user_role (userid, roleid)
VALUES (2, 2);


alter table reviews
	add constraint book_review_fk foreign key (bookId)
	references books (id);

insert into books (title, author)
values ('The 7 Habits of Highly Effective People', 'Stephen R. Covey');

insert into books (title, author) 
values ('The Martian', 'Andy Weir');

insert into reviews (text, bookId)
values ('An older book, but still a very good read for priniciple-centered leadership.', 1);

insert into reviews (text, bookId)
values ('A great science fiction book about an astronaut stranded on Mars', 2);