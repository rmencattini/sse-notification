# Objective

1. An user logs in.
2. He arrives at a page
3. He triggers an action through a button
4. He receives two notifications:
   5. One specific notification with user-id
   6. One global notification

# Requirements

* notification system should not block overall REST calls.
* Specific notification is catched only by the targeted user
* Global notification is catched by everyone
* Should work even if we change page
* Should work even if we CTRL+MAJ+R

# Roadmap

* add keycloak authentication with two users
* add multiple pages
* add specific notification on click
* add global notification on click
* ensure requirements are met otherwise add more point in Roadmap.
* Clean the readme

# Run

## Keycloak

```bash
docker run --name sse-keycloak -p 8080:8080 \
    -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin \
    -v ./sse-keycloak:/opt/keycloak/data/import \
    quay.io/keycloak/keycloak:latest \
    start-dev --import-realm \
    --http-port 8080 \
    --http-relative-path /auth
```