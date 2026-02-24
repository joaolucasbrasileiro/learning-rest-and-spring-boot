ALTER TABLE user_tb ADD CONSTRAINT uk_username UNIQUE (username);
ALTER TABLE user_tb ADD CONSTRAINT uk_email UNIQUE (email);