ALTER TABLE USER ADD bio VARCHAR(256) NULL;
COMMENT ON COLUMN USER.bio IS '个人简历';