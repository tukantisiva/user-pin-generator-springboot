create table book(
      id int not null primary key,
      name varchar_ignorecase(50) not null,
      author varchar_ignorecase(50) not null,
      price int);


create table user(
    
      user_id varchar_ignorecase(50) not null primary key,
      pin varchar_ignorecase(50) not null);
