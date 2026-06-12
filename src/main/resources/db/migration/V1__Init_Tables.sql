CREATE TABLE users (
    id UUID PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(50) NOT NULL,
    partner_name VARCHAR(255),
    start_date DATE
);

CREATE TABLE coupons (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    icon VARCHAR(255),
    status VARCHAR(50) NOT NULL,
    redeem_date TIMESTAMP
);

CREATE TABLE notifications (
    id UUID PRIMARY KEY,
    message TEXT NOT NULL,
    created_at TIMESTAMP NOT NULL,
    read_status BOOLEAN NOT NULL DEFAULT FALSE,
    user_id UUID,
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE achievements (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    icon VARCHAR(255),
    unlocked BOOLEAN NOT NULL DEFAULT FALSE,
    unlocked_at TIMESTAMP
);

CREATE TABLE timeline_events (
    id UUID PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT,
    event_date DATE NOT NULL,
    photo_url VARCHAR(500)
);

CREATE TABLE secret_messages (
    id UUID PRIMARY KEY,
    content TEXT NOT NULL,
    active BOOLEAN NOT NULL DEFAULT TRUE
);
