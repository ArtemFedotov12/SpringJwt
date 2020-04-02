update user
set user.is_active = 1
where user.is_active is null;

ALTER TABLE user
    CHANGE COLUMN is_active is_active BIT(1) NOT NULL DEFAULT 1 ;