create table tag
(
    id              bigserial
        primary key,
    tag_description varchar(255),
    tag_name        varchar(255) not null
);

alter table tag
    owner to "user";

create table users
(
    id               bigserial
        primary key,
    login            varchar(255) not null
        unique,
    password         varchar(255) not null,
    user_description varchar(255),
    user_name        varchar(255) not null
);

alter table users
    owner to "user";

create table recipe
(
    cooking_time       integer,
    portions_dish      integer,
    id                 bigserial
        primary key,
    my_recipes_id      bigint
        constraint fksdroynswxs6qt682oaedcid5h
            references users,
    recipe_description varchar(150),
    image_path         varchar(255),
    recipe_name        varchar(255) not null
);

alter table recipe
    owner to "user";

create table ingredient
(
    id                     bigserial
        primary key,
    ingredient_recipe_id   bigint
        constraint fk645tl79psg7vla0wk44n8c5ek
            references recipe,
    ingredient_description varchar(255),
    ingredient_name        varchar(255) not null
);

alter table ingredient
    owner to "user";

create table recipe_description_step
(
    description_step_recipe_id bigint not null
        constraint fkek4x48vt5oi7pfo3ek9bjj6vv
            references recipe,
    description_step           varchar(255)
);

alter table recipe_description_step
    owner to "user";

create table recipe_favorites
(
    favorites_id bigint not null
        constraint fk8o1g5f5u33j2b7253yxkyp1xt
            references users,
    recipe_id    bigint not null
        constraint fkaedlyk80a8smpn81qnbc0g6j2
            references recipe
);

alter table recipe_favorites
    owner to "user";

create table recipe_likes
(
    likes_id  bigint not null
        constraint fkowfdh1akloo7cdb64vmirwj6y
            references users,
    recipe_id bigint not null
        constraint fkiu7ckx4lxgiegaku0nedh47pi
            references recipe
);

alter table recipe_likes
    owner to "user";

create table recipe_tags
(
    recipe_id bigint not null
        constraint fkm8d9e65tioqhbd8eanewapglx
            references recipe,
    tags_id   bigint not null
        constraint fkc61e34yhfyeke62qo2onb9pa8
            references tag
);

alter table recipe_tags
    owner to "user";
