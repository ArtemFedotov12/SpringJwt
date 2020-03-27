ALTER TABLE user_roles
    DROP FOREIGN KEY FK55itppkw3i07do3h7qoclqd4k;
ALTER TABLE user_roles
    ADD CONSTRAINT FK55itppkw3i07do3h7qoclqd4k
        FOREIGN KEY (user_id)
            REFERENCES user (id)
            ON DELETE CASCADE
            ON UPDATE CASCADE;