insert into product(image, name, price)
values ('/assets/img/chicken.png', '치킨', 20000),
       ('/assets/img/hamburger.jpeg', '햄버거', 10000),
       ('/assets/img/pizza.jpg', '피자', 20000);

insert into members(email, password)
values ('woowacamp@naver.com', 'woowacamp');

insert into cart_products(member_id, product_id, quantity)
values (1, 1, 3),
       (1, 2, 1),
       (1, 3, 2);
